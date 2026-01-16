package com.thrifty.product;

import com.thrifty.common.PagedResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public PagedResponse<ProductSummary> listProducts(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return productService.listProducts(page, size);
  }

  @GetMapping("/{id}")
  public ProductDetailResponse getProductDetail(@PathVariable long id) {
    return productService.getProductDetail(id);
  }
}
