package com.thrifty.product;

import java.math.BigDecimal;

public record ProductSummary(
    Long id,
    String name,
    String shortDescription,
    BigDecimal price,
    String thumbnailUrl
) {}
