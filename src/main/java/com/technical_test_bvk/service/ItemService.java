package com.technical_test_bvk.service;

import com.technical_test_bvk.model.Item;
import com.technical_test_bvk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemByItemName(String itemName) {
        return itemRepository.findItemByItemName(itemName);
    }
}
