package test_task.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_task.model.dto.ProductDto;
import test_task.service.impl.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{uuid}")
    public List<ProductDto> getProductByType(@PathVariable(name = "uuid") UUID uuid) {
        log.info("GET request to get products by type");
        return productService.getAllProductByType(uuid);
    }

}
