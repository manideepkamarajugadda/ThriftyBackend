package com.thrifty.product;

import java.math.BigDecimal;

public record ProductDetailResponse(
    Long id,
    String name,
    String shortDescription,
    BigDecimal price,
    String description,
    String brand,
    String sku,
    Integer weightGrams,
    String dimensions,
    String material,
    String color,
    Integer stock,
    String thumbnailUrl,
    String imageUrl
) {}
