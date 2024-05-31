package com.technical_test_bvk.repository;

import com.technical_test_bvk.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Service
public class ItemRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private final RowMapper<Item> rowMapper = new RowMapper<Item>() {
//        @Override
//        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new Item(
//                    rs.getLong("id_item"),
//                    rs.getString("name"),
//                    rs.getString("description"),
//                    rs.getDouble("price")
//            );
//        }
//    };

//    public List<Item> findAll() {
//        return jdbcTemplate.query("SELECT * FROM item", rowMapper);
//    }

    public List<Item> findAll() {
        String sql = "SELECT * FROM item";
        List<Item> result =jdbcTemplate.query(sql, new Object[]{}, (rs, rowNum) -> {
            Item item = new Item();
            item.setId_item(rs.getLong("id_item"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setDescription(rs.getString("description"));
            return item;
        });
        return result != null ? result : new ArrayList<>();
    }

    public List<Item> findItemByItemName(String itemName) {
        String sql = "SELECT * FROM item where name=?";
        List<Item> result =jdbcTemplate.query(sql, new Object[]{itemName}, (rs, rowNum) -> {
            Item item = new Item();
            item.setId_item(rs.getLong("id_item"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setDescription(rs.getString("description"));
            return item;
        });
        return result != null ? result : new ArrayList<>();
    }

//    public Optional<Item> findById(Long id) {
//        String sql = "SELECT * FROM items WHERE id = ?";
//        return jdbcTemplate.query(sql, new Object[]{id}, new ItemRowMapper())
//                .stream()
//                .findFirst();
//    }
}
