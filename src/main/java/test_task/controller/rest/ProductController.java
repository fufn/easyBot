package test_task.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_task.model.dto.ProductDto;
import test_task.payload.request.ProductCreation;
import test_task.payload.request.ProductEdit;
import test_task.service.impl.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/type/{uuid}")
    public List<ProductDto> getProductsByType(@PathVariable(name = "uuid") UUID uuid) {
        log.info("GET request to get products by type");
        return productService.getAllProductByType(uuid);
    }

    @GetMapping("/{uuid}")
    public ProductDto getProductByUUID(@PathVariable(name = "uuid") UUID uuid) {
        log.info("GET request to get product by uuid");
        return productService.getProductByUUID(uuid);
    }

    @PostMapping
    public ProductDto addProduct(@Valid @RequestBody ProductCreation productCreation){
        log.info("POST request to add new product {}", productCreation);
        return productService.addProduct(productCreation);
    }

    @PutMapping
    public ProductDto editProduct(@Valid @RequestBody ProductEdit productEdit){
        log.info("PUT request to edit product {}", productEdit);
        return productService.editProduct(productEdit);
    }
}
