package com.thrifty.product;

import com.thrifty.common.PagedResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {
  private static final int MAX_PAGE_SIZE = 50;

  private final ProductRepository productRepository;
  private final ProductDetailRepository detailRepository;

  public ProductService(ProductRepository productRepository, ProductDetailRepository detailRepository) {
    this.productRepository = productRepository;
    this.detailRepository = detailRepository;
  }

  public PagedResponse<ProductSummary> listProducts(int page, int size) {
    int safePage = Math.max(page, 0);
    int safeSize = Math.min(Math.max(size, 1), MAX_PAGE_SIZE);

    Page<Product> products = productRepository.findAll(
        PageRequest.of(safePage, safeSize, Sort.by("id").ascending()));

    List<ProductSummary> content = products.map(this::toSummary).getContent();

    return new PagedResponse<>(
        content,
        products.getNumber(),
        products.getSize(),
        products.getTotalElements(),
        products.getTotalPages());
  }

  public ProductDetailResponse getProductDetail(long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    ProductDetail detail = detailRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product details not found"));

    return new ProductDetailResponse(
        product.getId(),
        product.getName(),
        product.getShortDescription(),
        product.getPrice(),
        detail.getDescription(),
        detail.getBrand(),
        detail.getSku(),
        detail.getWeightGrams(),
        detail.getDimensions(),
        detail.getMaterial(),
        detail.getColor(),
        detail.getStock(),
        product.getThumbnailUrl(),
        detail.getImageUrl());
  }

  private ProductSummary toSummary(Product product) {
    return new ProductSummary(
        product.getId(),
        product.getName(),
        product.getShortDescription(),
        product.getPrice(),
        product.getThumbnailUrl());
  }
}
