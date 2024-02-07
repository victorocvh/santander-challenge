package com.example.restapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Funcionario {
    // id,nome,email,telefone,dt_contratacao,ativo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String nome;

    private String email;

    private String telefone;

    private Date dt_contratacao;

    private Boolean ativo;

    @ManyToOne
    private TipoFuncionario tipoFuncionario;
}
