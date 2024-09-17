package com.zee.springmodulithcourse.inventory;

import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

public final class InventoryUtil {

    public static InventoryDto mapInventoryDto(Inventory inventory) {
        return new InventoryDto(inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice());
    }
}
