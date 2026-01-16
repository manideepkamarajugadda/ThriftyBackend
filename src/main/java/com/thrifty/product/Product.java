package com.thrifty.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "short_description")
  private String shortDescription;

  private BigDecimal price;

  @Column(name = "thumbnail_url")
  private String thumbnailUrl;

  protected Product() {}

  public Product(Long id, String name, String shortDescription, BigDecimal price, String thumbnailUrl) {
    this.id = id;
    this.name = name;
    this.shortDescription = shortDescription;
    this.price = price;
    this.thumbnailUrl = thumbnailUrl;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }
}
