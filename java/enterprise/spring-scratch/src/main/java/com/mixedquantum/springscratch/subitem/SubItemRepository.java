package com.mixedquantum.springscratch.subitem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubItemRepository extends CrudRepository<SubItem, Integer> {
    /*
    Now there's a lot of magic happening here.
    Any function of the name findBy<field> is automatically handled by JPA (!)
    to find entries of the given entity (SubItem in this case) where the
     field (Name for findByName) value matches the input.
    There is a logic that splits the term (findByName) by capitalization
     and attempts to find attributes at that level.
    .e.g findByItemDescription would create an attribute lookup: item.description
    If there's no "description" in "item", it would discard the split and try
    a new one, considering the whole term "itemDescription" on the parent entity.
    Talk about unambiguous behaviour... apparently you can specify the break using
    an underscore, but that's against the "naming conventions" and you should
    rather name your variables correctly.
     */
    List<SubItem> findByItemId(Integer itemId);
    List<SubItem> findByName(String name);
}
