package com.example.cadastroproduto.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produto {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String codigo;
    public String nome;
    public Double valor;

}
