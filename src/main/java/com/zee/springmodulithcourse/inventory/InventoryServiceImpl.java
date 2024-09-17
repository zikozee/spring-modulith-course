package com.zee.springmodulithcourse.inventory;

import com.zee.springmodulithcourse.exception.ModulithException;
import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;
import com.zee.springmodulithcourse.inventory.exposed.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Service
class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryDto fetchInventoryByName(String name) {
        return inventoryRepository.getInventoryByName(name)
                .map(InventoryUtil::mapInventoryDto)
                .orElseThrow(() -> new ModulithException("Could not find inventory by name: " + name));
    }

    @Override
    public List<InventoryDto> fetchAllInName(List<String> inventoryNames) {
        return inventoryRepository.getInventoryByNameIn(inventoryNames)
                .stream()
                .map(InventoryUtil::mapInventoryDto)
                .toList();
    }
}
