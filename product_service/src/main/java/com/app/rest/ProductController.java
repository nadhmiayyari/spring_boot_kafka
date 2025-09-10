package com.app.rest;


import com.app.dto.ErrorMessage;
import com.app.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(ProductDto product) {
        try {
            productService.createProduct(product);
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.error(e.getMessage());
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(new Date(),"error occured",e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created");
    }
}
