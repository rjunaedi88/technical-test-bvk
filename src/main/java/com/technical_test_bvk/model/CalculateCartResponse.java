package com.technical_test_bvk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateCartResponse {
    private String idCart;
    private Double calculatePrice;
    private List<Item> items;
}
