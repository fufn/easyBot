package test_task.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "attribute_value")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttributeValue {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    private Attribute attribute;

    @ManyToOne
    private Product product;

    @Column(name = "value")
    private String value;
}
