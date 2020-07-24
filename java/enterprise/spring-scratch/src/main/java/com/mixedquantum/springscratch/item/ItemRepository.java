package com.mixedquantum.springscratch.item;

import org.springframework.data.repository.CrudRepository;

/*
 CrudRepository offers basic CRUD APIs against the db (list,findById,etc).
 You need to define the type of the Entity (Item) and the type
 of the Primary key (Integer) in this case
 */
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
