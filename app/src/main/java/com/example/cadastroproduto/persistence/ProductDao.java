package com.example.cadastroproduto.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product")
    List<Product> getAll();

    /*@Query("SELECT * FROM Product WHERE name LIKE :name")
    List<Product> findByName(String name);

    @Query("SELECT * FROM Product WHERE code = :code LIMIT 1")
    Product findByCode(int code);*/

    @Insert
    void insertAll(Product... product);

    /*@Delete
    void delete(Product product);*/
}
