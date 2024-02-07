package com.example.restapi.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {
    // id,nome_produto,descricao,preco,dt_atualizacao_preco,ativo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome_produto;

    private String descricao;

    private Double preco;

    private Date dt_atualizacao_preco;

    private Boolean ativo;
}
