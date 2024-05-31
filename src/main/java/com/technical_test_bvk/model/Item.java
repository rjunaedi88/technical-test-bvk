package com.technical_test_bvk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id_item;
    private String name;
    private String description;
    private Double price;
}
