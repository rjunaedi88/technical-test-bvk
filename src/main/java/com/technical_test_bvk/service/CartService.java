package com.technical_test_bvk.service;

import com.technical_test_bvk.model.Cart;
import com.technical_test_bvk.model.Item;
import com.technical_test_bvk.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public String addToCart(Cart cart) {
        List<Item> items = cart.getItem();
        String add="";
        for (Item item : items){
             add= cartRepository.addToCart(cart.getId_cart(),item);
        }
        return add;
    }

    public String removeItemFromCart(String idCart, Long idItem) {
        return cartRepository.removeItem(idCart,idItem);
    }

    public List<Item> getItemByCatdId(String idCart) {
        return cartRepository.findItemByItemIdCart(idCart);
    }
}
