package test_task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductDto {

    private UUID id;
    private String serialNumber;
    private String manufacturer;
    private Double price;
    private Integer stock;
    private UUID productTypeId;
    private String typeName;
    private String typeCode;
    private List<AttributeDto> attributes;
}
