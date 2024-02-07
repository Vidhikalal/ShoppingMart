package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.database;

import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;//

import java.util.List;
//
//import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface ProductRepo extends CrudRepository<Products, Long> {
//    List<Products> readStudentByNameStartingWith(String letter);
//    @Query("SELECT s.id, s.name, s.price FROM PRODUCTS s WHERE s.name LIKE 'B%'")
//
//    List<Products> findAllProductDetails();
//}
@Repository
public class ProductRepo{
    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public Products getProductById(Long id) {
        MapSqlParameterSource mpl = new MapSqlParameterSource();
        String q ="select * from products where id = :id";
        mpl.addValue("id", id);
        List<Products> sList = jdbc.query(q, mpl, new BeanPropertyRowMapper<Products>(Products.class));

        return sList.get(0);


    }
    public List<Products> getAllProducts() {
        String sql = "SELECT * FROM products";

        return jdbc.query(sql, new BeanPropertyRowMapper<>(Products.class));
    }

    public void addProduct(Products product) {

        String sql = "INSERT INTO products (name, price, Id) VALUES (:name, :price, :Id)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());
        params.addValue("Id", product.getId());

        jdbc.update(sql, params);
    }
    public void addToCart(Products product) {

        String sql = "INSERT INTO CART (name, price, Id) VALUES (:name, :price, :Id)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());
        params.addValue("Id", product.getId());

        jdbc.update(sql, params);
    }



}

