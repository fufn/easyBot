package test_task.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test_task.model.dto.AttributeDto;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreation {

    private String serialNumber;
    private String manufacturer;
    private Double price;
    private Integer stock;
    private UUID productType;
    private List<AttributeDto> attributeDtoList;
}
