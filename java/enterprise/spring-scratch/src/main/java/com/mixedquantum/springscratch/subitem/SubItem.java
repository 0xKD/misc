package com.mixedquantum.springscratch.subitem;

import com.mixedquantum.springscratch.item.Item;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="subitem")
public class SubItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable=false)
    public String name;

    public String description;

    @ManyToOne(optional=false) // nullable (optional=true) by default..
    private Item item;
}
