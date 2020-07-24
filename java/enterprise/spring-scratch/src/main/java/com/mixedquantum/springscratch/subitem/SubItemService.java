package com.mixedquantum.springscratch.subitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubItemService {
    @Autowired
    private SubItemRepository subItemRepository;

    public void save(SubItem subItem) {
        subItemRepository.save(subItem);
    }

    public List<SubItem> findAll() {
        List<SubItem> items = new ArrayList<>();
        subItemRepository.findAll().forEach(items::add);
        return items;
    }

    public List<SubItem> findByItemId(Integer id) {
        return new ArrayList<>(subItemRepository.findByItemId(id));
    }

    public List<SubItem> findByItemName(String name) {
        System.out.println("size:" + subItemRepository.findByName(name).size());
        return new ArrayList<>(subItemRepository.findByName(name));
    }
}
