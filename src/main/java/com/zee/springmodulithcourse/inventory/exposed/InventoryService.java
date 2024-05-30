package com.zee.springmodulithcourse.inventory.exposed;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */


public interface InventoryService {

    InventoryDto fetchInventoryByName(String name);

    List<InventoryDto> fetchAllInName(List<String> inventoryNames);
}
