package com.example.cadastroproduto.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdutoDao {
    @Query("SELECT * FROM Produto")
    List<Produto> getAll();

    @Query("SELECT * FROM Produto WHERE nome LIKE :name")
    List<Produto> findByName(String name);

    @Query("SELECT * FROM Produto WHERE codigo = :codigo LIMIT 1")
    Produto findByCodigo(int codigo);

    @Insert
    void insertAll(Produto... produto);

    @Delete
    void delete(Produto produto);
}
