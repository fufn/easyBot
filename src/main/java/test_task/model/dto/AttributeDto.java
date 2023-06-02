package test_task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AttributeDto {

    private UUID id;
    private String name;
    private String code;
    private String value;
}
