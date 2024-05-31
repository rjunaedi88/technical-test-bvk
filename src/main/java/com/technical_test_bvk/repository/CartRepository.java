package com.technical_test_bvk.repository;

import com.technical_test_bvk.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addToCart(String idCart, Item item) {
        String sql = "INSERT INTO cart (id_cart,id_item, description,name,price) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, idCart, item.getId_item(),item.getDescription(), item.getName(), item.getPrice());
        return "Item added to cart successfully.";
    }

    public String removeItem(String idCart, Long idItem){
        String sql = "delete from cart where id_cart =? and id_item =?";
        jdbcTemplate.update(sql, idCart, idItem);
        return "Item deleted to cart successfully.";
    }

    public List<Item> findItemByItemIdCart(String idCart) {
        String sql = "SELECT * FROM cart where id_cart=?";
        List<Item> result =jdbcTemplate.query(sql, new Object[]{idCart}, (rs, rowNum) -> {
            Item item = new Item();
            item.setId_item(rs.getLong("id_item"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setDescription(rs.getString("description"));
            return item;
        });
        return result != null ? result : new ArrayList<>();
    }
}
