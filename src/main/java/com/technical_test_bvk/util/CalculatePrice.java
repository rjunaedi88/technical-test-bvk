package com.technical_test_bvk.util;

import com.technical_test_bvk.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatePrice {

    public Double calculatePrice(List<Item> items){
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }
}
