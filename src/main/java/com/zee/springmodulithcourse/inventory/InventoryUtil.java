package com.zee.springmodulithcourse.inventory;

import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;
import lombok.experimental.UtilityClass;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@UtilityClass
public class InventoryUtil {

    public InventoryDto mapInventoryDto(Inventory inventory) {
        return new InventoryDto(inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice());
    }
}
