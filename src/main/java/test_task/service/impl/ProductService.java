package test_task.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test_task.controller.exceptions.ServiceException;
import test_task.mapper.ProductMapper;
import test_task.model.dto.AttributeDto;
import test_task.model.dto.AttributeValueDto;
import test_task.model.dto.ProductDto;
import test_task.model.entities.Attribute;
import test_task.model.entities.AttributeValue;
import test_task.model.entities.Product;
import test_task.model.entities.ProductType;
import test_task.payload.codes.ErrorCode;
import test_task.payload.request.ProductCreation;
import test_task.payload.request.ProductEdit;
import test_task.repository.AttributeRepository;
import test_task.repository.AttributeValueRepository;
import test_task.repository.ProductRepository;
import test_task.repository.ProductTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductMapper productMapper;
    private final AttributeValueRepository attributeValueRepository;
    private final AttributeRepository attributeRepository;

    public List<ProductDto> getAllProductByType(UUID uuid) {
        log.debug("Trying to find ProductType by uuid");
        ProductType productType  = productTypeRepository.findById(uuid).orElseThrow(
                () -> ServiceException.builder()
                        .message("No product with that type")
                        .errorCode(ErrorCode.NOT_EXISTS)
                        .build()
        );
        log.debug("Product Type was found");
        List<Product> products = productRepository.findAllByProductType(productType);
        log.debug("Found products with given product type");
        return productMapper.toListDto(products);
    }

    public ProductDto getProductByUUID(UUID uuid) {
        log.debug("Finding product with uuid {}", uuid);
        Product product = productRepository.findById(uuid).orElseThrow(
                () -> ServiceException.builder()
                        .message("No product with that uuid")
                        .errorCode(ErrorCode.NOT_EXISTS)
                        .build()
        );
        log.debug("Product was found");
        return productMapper.toDto(product);
    }

    public ProductDto addProduct(ProductCreation productCreation) {
        log.debug("Checking if product with such serial number exists {}", productCreation.getSerialNumber());
        Product product = productRepository.findBySerialNumber(productCreation.getSerialNumber());
        if (product != null) {
            throw ServiceException.builder()
                    .message("Product with such serial number exists")
                    .errorCode(ErrorCode.ALREADY_EXISTS)
                    .build();
        }
        log.debug("Checking if product type with such uuid exists {}", productCreation.getProductType());
        ProductType productType = productTypeRepository.findById(productCreation.getProductType()).orElseThrow(
                () -> ServiceException.builder()
                        .message("No product with that type")
                        .errorCode(ErrorCode.NOT_EXISTS)
                        .build()
        );

        product = Product.builder()
                .productType(productType)
                .serialNumber(productCreation.getSerialNumber())
                .manufacturer(productCreation.getManufacturer())
                .stock(productCreation.getStock())
                .price(productCreation.getPrice())
                .build();
        log.debug("Saving product without assigned attributes");
        Product savedProduct = productRepository.save(product);
        savedProduct.setAttributeValues(new ArrayList<>());
        log.debug("Assigning new attributes");
        for (AttributeDto attributeDto : productCreation.getAttributeDtoList()){
            Attribute attribute = attributeRepository.findByIdAndProductType(attributeDto.getAttributeId(), productType);
            if (attribute == null) throw ServiceException.builder()
                    .message("Product cannot have such attribute")
                    .errorCode(ErrorCode.INVALID_ATTRIBUTE)
                    .build();
            AttributeValue attributeValue = AttributeValue.builder()
                            .attribute(attribute)
                            .product(savedProduct)
                            .value(attributeDto.getValue())
                            .build();
            AttributeValue savedAttributeValue = attributeValueRepository.save(attributeValue);
            savedProduct.getAttributeValues().add(savedAttributeValue);
        }

        return productMapper.toDto(savedProduct);
    }

    public ProductDto editProduct(ProductEdit productEdit) {
        log.debug("Checking if product with such serial number exists {}", productEdit.getSerialNumber());
        Product product = productRepository.findById(productEdit.getUuid()).orElseThrow(
                () -> ServiceException.builder()
                        .message("Product with such serial number does not exists")
                        .errorCode(ErrorCode.NOT_EXISTS)
                        .build()
        );
        log.debug("Checking if product type with such uuid exists {}", productEdit.getProductType());
        ProductType productType = productTypeRepository.findById(productEdit.getProductType()).orElseThrow(
                () -> ServiceException.builder()
                        .message("No product with that type")
                        .errorCode(ErrorCode.NOT_EXISTS)
                        .build()
        );

        if (!product.getSerialNumber().equals(productEdit.getSerialNumber())){
            Product existingProduct = productRepository.findBySerialNumber(productEdit.getSerialNumber());
            if (existingProduct != null) {
                throw ServiceException.builder()
                        .message("Product with such serial number already exists")
                        .errorCode(ErrorCode.ALREADY_EXISTS)
                        .build();
            }
        }

        log.debug("Assigning new values");
        product.setProductType(productType);
        product.setPrice(productEdit.getPrice());
        product.setStock(product.getStock());
        product.setManufacturer(product.getManufacturer());

        log.debug("Assigning new attributes");
        for (AttributeValueDto attributeValueDto : productEdit.getAttributeDtoList()){
            log.debug("Finding attribute value for product {}", attributeValueDto);
            AttributeValue attributeValue = attributeValueRepository.findById(attributeValueDto.getAttributeValueId()).orElseThrow(
                    () ->  ServiceException.builder()
                            .message("No attribute value with that id")
                            .errorCode(ErrorCode.NOT_EXISTS)
                            .build()
            );
            Attribute attribute = attributeRepository.findByIdAndProductType(attributeValue.getAttribute().getId(), productType);
            if (attribute == null) {
                throw ServiceException.builder()
                        .message("Product cannot have such attributes")
                        .errorCode(ErrorCode.INVALID_ATTRIBUTE)
                        .build();
            }
            attributeValue.setValue(attributeValueDto.getValue());
            attributeValueRepository.save(attributeValue);
        }

        return productMapper.toDto(product);
    }
}
