package com.zee.springmodulithcourse.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */


public record InventoryRequestDto(
        @NotBlank(message = "inventoryName is required")
        String inventoryName,
        @Min(value = 1L, message = "The value must be greater than Zero")
        int qty
) { }
