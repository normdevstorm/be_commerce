package com.normdevstorm.commerce_platform.controller.product;

import com.normdevstorm.commerce_platform.dto.product.ProductRequestDTO;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<GenericResponse<Set<ProductResponseDTO>>> getProducts(){
        Set<ProductResponseDTO> productResponseDTOSet = productService.getProducts();
        return ResponseEntity.ok(GenericResponse.<Set<ProductResponseDTO>>builder().success(true).data(productResponseDTOSet).message("Add products successfully!!!").build());
    }

    @PutMapping("/add")
    public ResponseEntity<GenericResponse<Set<ProductResponseDTO>>> addProducts(@RequestBody Set<ProductRequestDTO> products){
        Set<ProductResponseDTO> productResponseDTOSet = productService.addProducts(products);
        return ResponseEntity.ok(GenericResponse.<Set<ProductResponseDTO>>builder().success(true).data(productResponseDTOSet).message("Add products successfully!!!").build());
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<GenericResponse<String>> deleteProduct(@PathVariable String productId){
        String result = productService.deleteProduct(productId);
        return ResponseEntity.ok(GenericResponse.<String>builder().success(true).data("").message(result).build());
    }

    @PatchMapping("/update/{productId}")
    public ResponseEntity<GenericResponse<ProductResponseDTO>> updateProduct(@PathVariable String productId, @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.updateProduct(productId, productRequestDTO);
//        return productService.updateProduct(productId, productRequestDTO);
        return  ResponseEntity.ok(GenericResponse.<ProductResponseDTO>builder().success(true).data(productResponseDTO).message("Update product successfully!!!").build());

    }

}
