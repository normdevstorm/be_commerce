package com.normdevstorm.commerce_platform.service;


import com.normdevstorm.commerce_platform.dto.brand.BrandRequestDto;
import com.normdevstorm.commerce_platform.dto.product.ProductRequestDTO;
import com.normdevstorm.commerce_platform.dto.product.ProductResponseDTO;
import com.normdevstorm.commerce_platform.dto.review.ReviewRequestDto;
import com.normdevstorm.commerce_platform.entity.Brand;
import com.normdevstorm.commerce_platform.entity.Product;
import com.normdevstorm.commerce_platform.entity.Review;
import com.normdevstorm.commerce_platform.mapper.brand.BrandRequestMapper;
import com.normdevstorm.commerce_platform.mapper.product.ProductRequestMapper;
import com.normdevstorm.commerce_platform.mapper.product.ProductResponseMapper;
import com.normdevstorm.commerce_platform.mapper.review.ReviewRequestMapper;
import com.normdevstorm.commerce_platform.model.response.GenericResponse;
import com.normdevstorm.commerce_platform.repository.BrandRepository;
import com.normdevstorm.commerce_platform.repository.ProductRepository;
import com.normdevstorm.commerce_platform.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRequestMapper productRequestMapper;

    @Autowired
    private ProductResponseMapper productResponseMapper;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ReviewRequestMapper reviewRequestMapper;
    @Autowired
    private BrandRequestMapper brandRequestMapper;

    public Set<ProductResponseDTO> addProducts(Set<ProductRequestDTO> products) {
        ///todo: resolve unhappy case later on : detect if the product has been existed in db
        Set<Product> productSet = products.stream().map(productRequestDTO -> {
            return productRequestMapper.toProductWithBrandAndReviews(productRequestDTO, findBrand(productRequestDTO, false), findReviewSet(productRequestDTO));
        }).collect(Collectors.toSet());
        Set<ProductResponseDTO> productResponseDTOSet = productRepository.saveAll(productSet).stream().map(productResponseMapper::toProductResponseDTO).collect(Collectors.toSet());
//        return ResponseEntity.ok(GenericResponse.<Set<ProductResponseDTO>>builder().success(true).data(productResponseDTOSet).message("Add products successfully!!!").build());
        return productResponseDTOSet;
    }

    public ProductResponseDTO updateProduct(String productId, ProductRequestDTO productRequestDTO) {
        try {
            Product product = productRepository.findById(UUID.fromString(productId)).get();
            return productResponseMapper.toProductResponseDTO(productRepository.save(productRequestMapper.partialUpdateWithBrandAndReviews(productRequestDTO, findBrand(productRequestDTO, true), findReviewSet(productRequestDTO), product)));
        } catch (Exception e) {
            log.error(e.toString());
            throw new RuntimeException("Product not found !!!");
        }
    }

    public String deleteProduct(String productId) {
        try {
             Product product = productRepository.findById(UUID.fromString(productId)).get();
             productRepository.deleteById(product.getProductId());
            return "Delete product successfully!!!";
        } catch (Exception e) {
            log.error(e.toString());
            return "Product not found !!! Delete failed !!!";
        }
    }

    public Set<ProductResponseDTO> getProducts() {
        Set<ProductResponseDTO> productSet = productRepository.findAll().stream().map(productResponseMapper::toProductResponseDTO).collect(Collectors.toSet());
        return productSet;
    }

    private Brand findBrand(ProductRequestDTO productRequestDTO, boolean isUpdate) {
        BrandRequestDto brandRequestDto = productRequestDTO.getBrand();
        try {
            if (brandRequestDto.getBrandId() != null) {
                //FE handle: fetch brand list, if the user not choose one of the options => brandId = null
                //id != null -> query 1. exist -> return 2. not existed -> save into db
                Brand existedBrand = brandRepository.findById(brandRequestDto.getBrandId()).orElse(null);
                if ((existedBrand != null)) {
//                    brandRepository.updateNameAndAboutAndProductsByBrandId(brandRequestDto.getName(), brandRequestDto.getAbout(), brandRequestDto.getBrandId());
                    return brandRepository.save(brandRequestMapper.partialUpdate(brandRequestDto, existedBrand));
                }
            }
                return brandRepository.save(brandRequestMapper.toEntity(brandRequestDto));
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }

    private Set<Review> findReviewSet(ProductRequestDTO productRequestDTO) {
        Set<ReviewRequestDto> reviewsDto = productRequestDTO.getReviews();
        Set<Review> reviews = new HashSet<>();
        for (ReviewRequestDto reviewRequestDto : reviewsDto) {
            try {
                if (reviewRequestDto.getReviewId() != null) {
                    //id != null -> query 1. exist -> return 2. not existed -> save into db
                    Review existedReview = reviewRepository.findById(reviewRequestDto.getReviewId()).orElse(null);
                    Review review = reviewRepository.save((existedReview != null) ? reviewRequestMapper.partialUpdate(reviewRequestDto, existedReview) : reviewRequestMapper.toEntity(reviewRequestDto));
                    reviews.add(review);
                } else {
                    reviews.add(reviewRepository.save(reviewRequestMapper.toEntity(reviewRequestDto)));
                }
            } catch (Exception e) {
                log.error(e.toString());
                throw e;
            }
        }
        return reviews;
    }


}
