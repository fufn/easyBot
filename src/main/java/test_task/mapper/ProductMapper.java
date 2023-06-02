package test_task.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test_task.model.dto.ProductDto;
import test_task.model.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final AttributeMapper attributeMapper;

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .manufacturer(product.getManufacturer())
                .price(product.getPrice())
                .serialNumber(product.getSerialNumber())
                .stock(product.getStock())
                .typeName(product.getProductType().getName())
                .typeCode(product.getProductType().getCode())
                .productTypeId(product.getProductType().getId())
                .attributes(attributeMapper.toListDto(product.getAttributeValues()))
                .build();
    }

    public List<ProductDto> toListDto(List<Product> products) {
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }
}
