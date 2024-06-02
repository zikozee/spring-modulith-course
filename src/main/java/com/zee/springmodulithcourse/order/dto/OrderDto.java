package com.zee.springmodulithcourse.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

public record OrderDto(
        @NotBlank(message = "customerName is required")
        String customerName,
        @NotBlank(message = "customerEmail is required")
        String customerEmail,
        @Valid
        List<InventoryRequestDto> inventoryRequestDtoList
) {
}
