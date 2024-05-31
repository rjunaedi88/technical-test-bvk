package com.technical_test_bvk.controller;

import com.technical_test_bvk.model.CalculateCartResponse;
import com.technical_test_bvk.model.Cart;
import com.technical_test_bvk.model.Item;
import com.technical_test_bvk.service.CartService;
import com.technical_test_bvk.service.ItemService;
import com.technical_test_bvk.util.CalculatePrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Slf4j
public class Controller {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CalculatePrice calculatePrice;

    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        //todo search item
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemName}")
    public ResponseEntity<List<Item>> getItemById(@PathVariable String itemName) {
        //todo selected item
        log.info("Req item name :{}", itemName);
        List<Item> getItemByItemName = itemService.getItemByItemName(itemName);
        return new ResponseEntity<>(getItemByItemName, HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addItemToCart(@RequestBody Cart cart) {
        //todo add item to cart
        log.info("Req item add to cart :{}", cart);
        String addToCart = cartService.addToCart(cart);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }

    @PostMapping("/addMoreItemsToCart")
    public ResponseEntity<String> addMoreItemsToCart(@RequestBody Cart cart) {
        //todo add more item to cart
        log.info("Req item add more item to cart :{}", cart);
        String addToCart = cartService.addToCart(cart);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }

    @DeleteMapping("/removeItemFromCart")
    public ResponseEntity<String> removeItemFromCart(@RequestParam String idCart, @RequestParam Long idItem){
        log.info("Req Remove item from cart :{}{}", idCart, idItem);
        //todo remove item from cart
        String removeItemFromCart = cartService.removeItemFromCart(idCart,idItem);
        return new ResponseEntity<>(removeItemFromCart, HttpStatus.OK);
    }

    @GetMapping("/calculatePrice")
    public ResponseEntity<CalculateCartResponse> calculatePrice (@RequestParam String idCart){
        log.info("Req Calculate Price :{}", idCart);
        //todo calculate price
        CalculateCartResponse response = new CalculateCartResponse();
        List<Item> getItemByCatdId = cartService.getItemByCatdId(idCart);
        response.setIdCart(idCart);
        response.setCalculatePrice(calculatePrice.calculatePrice(getItemByCatdId));
        response.setItems(getItemByCatdId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
