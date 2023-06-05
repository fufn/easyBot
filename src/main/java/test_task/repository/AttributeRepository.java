package test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_task.model.entities.Attribute;
import test_task.model.entities.ProductType;

import java.util.UUID;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
    Attribute findByIdAndProductType(UUID id, ProductType productType);
}