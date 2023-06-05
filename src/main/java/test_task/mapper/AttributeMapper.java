package test_task.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test_task.model.dto.AttributeDto;
import test_task.model.entities.AttributeValue;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AttributeMapper {
    public AttributeDto toDto(AttributeValue attributeValue) {
        return AttributeDto.builder()
                .attributeId(attributeValue.getAttribute().getId())
                .name(attributeValue.getAttribute().getName())
                .code(attributeValue.getAttribute().getCode())
                .value(attributeValue.getValue())
                .build();
    }

    public List<AttributeDto> toListDto(List<AttributeValue> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
