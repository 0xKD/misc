package com.mixedquantum.springscratch.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // specifies Item as a persistence class
public class Item {
    // specifies id as the primary key
    @Id
    // Specifies that id is an auto-generated field
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    // Mark this column as not-null (default is allow null)
    @Column(nullable=false)
    private String name;
    private String description;
}

/*
  If @Column(nullable=false) is added after the first application run,
  then it isn't updated on the db level.
  For a framework that touts itself for doing a lot,
  migrations are poorly handled but there's probably a plugin for that
 */
