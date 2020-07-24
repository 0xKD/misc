package com.mixedquantum.springscratch.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersistentItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Item findById(Integer itemId) {
        return itemRepository.findById(itemId).get();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void remove(Item item) {
        itemRepository.delete(item);
    }
}
