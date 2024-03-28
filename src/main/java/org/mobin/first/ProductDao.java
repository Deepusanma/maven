package org.mobin.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ProductDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    Product product;


    @Transactional(readOnly = true)
    public void persist(){
        jdbcTemplate.query("select * from products where id = 20", new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
            }
        });
        System.out.println("Name is : " + product.getName() + "\nproduct price : " +  product.getPrice());
    }
}
