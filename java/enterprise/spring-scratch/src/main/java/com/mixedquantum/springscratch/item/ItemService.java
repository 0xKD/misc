package com.mixedquantum.springscratch.item;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This annotation enables injection of an instance of this class
@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>(Arrays.asList(
        new Item(10, "hello", "World. Bob. Sinclair"),
        new Item(20, "useless", "Framework")
    ));

    public List<Item> getItems() {
        return items;
    }

    public Item findById(Integer id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
