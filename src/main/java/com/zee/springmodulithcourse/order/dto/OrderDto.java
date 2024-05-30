package com.zee.springmodulithcourse.order.dto;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

public record OrderDto(
        String customerName,
        String customerEmail,
        List<InventoryRequestDto> inventoryRequestDtoList
) {
}
