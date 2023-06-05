package test_task.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test_task.model.dto.AttributeDto;
import test_task.model.dto.AttributeValueDto;
import test_task.model.entities.AttributeValue;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEdit {

    private UUID uuid;
    private String serialNumber;
    private String manufacturer;
    private Double price;
    private Integer stock;
    private UUID productType;
    private List<AttributeValueDto> attributeDtoList;
}
