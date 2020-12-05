package com.example.cadastroproduto.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String code;
    public String name;
    public Double value;

}
