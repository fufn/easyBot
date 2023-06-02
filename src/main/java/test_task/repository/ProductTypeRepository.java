package test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_task.model.entities.ProductType;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, UUID> {
    Optional<ProductType> findById(UUID uuid);
}
