package com.thrifty.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetail {
  @Id
  @Column(name = "product_id")
  private Long productId;

  private String description;
  private String brand;
  private String sku;

  @Column(name = "weight_grams")
  private Integer weightGrams;

  private String dimensions;
  private String material;
  private String color;
  private Integer stock;

  @Column(name = "image_url")
  private String imageUrl;

  protected ProductDetail() {}

  public ProductDetail(Long productId, String description, String brand, String sku, Integer weightGrams,
      String dimensions, String material, String color, Integer stock, String imageUrl) {
    this.productId = productId;
    this.description = description;
    this.brand = brand;
    this.sku = sku;
    this.weightGrams = weightGrams;
    this.dimensions = dimensions;
    this.material = material;
    this.color = color;
    this.stock = stock;
    this.imageUrl = imageUrl;
  }

  public Long getProductId() {
    return productId;
  }

  public String getDescription() {
    return description;
  }

  public String getBrand() {
    return brand;
  }

  public String getSku() {
    return sku;
  }

  public Integer getWeightGrams() {
    return weightGrams;
  }

  public String getDimensions() {
    return dimensions;
  }

  public String getMaterial() {
    return material;
  }

  public String getColor() {
    return color;
  }

  public Integer getStock() {
    return stock;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
