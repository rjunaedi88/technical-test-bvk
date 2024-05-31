package com.technical_test_bvk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String id_cart;
    private List<Item> item;
//    private Long id_item;
//    private String name;
//    private String description;
//    private Double price;
}
