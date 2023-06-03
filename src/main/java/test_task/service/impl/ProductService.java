package test_task.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test_task.controller.exceptions.ServiceException;
import test_task.mapper.ProductMapper;
import test_task.model.dto.ProductDto;
import test_task.model.entities.Product;
import test_task.model.entities.ProductType;
import test_task.payload.codes.ErrorCode;
import test_task.repository.ProductRepository;
import test_task.repository.ProductTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductMapper productMapper;

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
}
