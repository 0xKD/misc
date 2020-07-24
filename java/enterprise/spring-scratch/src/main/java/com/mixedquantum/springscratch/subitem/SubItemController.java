package com.mixedquantum.springscratch.subitem;

import com.mixedquantum.springscratch.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubItemController {
    @Autowired
    private SubItemService subItemService;

    @RequestMapping(value="/items/{id}/subitem", method=RequestMethod.POST)
    public void createSubItem(@RequestBody SubItem subItem, @PathVariable(name="id") Integer itemId) {
        /*
        Seems like a hacky way to specify FK value, there must be a better way to do this
         (.e.g internal item_id attr that can be set)
         */
        subItem.setItem(new Item(itemId, "", ""));
        subItemService.save(subItem);
    }

    @RequestMapping(value="/subitems", method=RequestMethod.GET)
    public List<SubItem> getSubItems() {
        return subItemService.findAll();
    }

    @RequestMapping(value="/items/{id}/subitems", method=RequestMethod.GET)
    // If you miss @PathVariable, it won't work as expected, but it won't throw an error either
    public List<SubItem> getSubItemsByItemId(@PathVariable Integer id) {
        return subItemService.findByItemId(id);
    }
}
