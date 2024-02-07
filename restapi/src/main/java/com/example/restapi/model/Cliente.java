package com.example.restapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
    // id,nome,email,cpf,telefone,dt_criacao,is_deleted

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
// #oxe
    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    private Date dt_criacao;

    private Boolean is_deleted;
    
}
