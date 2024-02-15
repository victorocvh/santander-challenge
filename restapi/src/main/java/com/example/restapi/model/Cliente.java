package com.example.restapi.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;




@Data
@Entity
public class Cliente {
    // id,nome,email,cpf,telefone,dt_criacao,is_deleted

    @Id
    @SequenceGenerator(allocationSize = 1, name = "cliente_seq", sequenceName = "cliente_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente_seq")
    private Long Id;
// #oxe
    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @JoinColumn(name = "dt_criacao")
    private Date dtCriacao;

    @JoinColumn(name = "is_deleted")
    private Boolean isDeleted;
    
}
