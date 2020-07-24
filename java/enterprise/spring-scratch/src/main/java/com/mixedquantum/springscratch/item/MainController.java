package com.mixedquantum.springscratch.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class will be automatically picked up by the framework
// with the RestController annotation.
@RestController
public class MainController {

//    @Autowired private ItemService itemService;
    @Autowired private PersistentItemService itemService;

    // RequestMapping does all HTTP operations (by default)
    @RequestMapping("/greet")
    public String greet() {
        return "Hello";
    }

    @RequestMapping("/items")
    public List<Item> items() {
        // The RestController annotation also means automatic conversion of
        // Java objects to JSON in the response
        return itemService.getItems();
    }

    @RequestMapping("/items/{id}")
    public Item getItemById(@PathVariable("id") Integer id) {
        return itemService.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        Item item = new Item();
        item.setId(id);
        itemService.remove(item);
    }
}

// RestController is perhaps too much magic (auto-include URLs, auto-convert response)
// Similarly for @Autowired and @RequestBody??? - Automatic serialization? amazing
