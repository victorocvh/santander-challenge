package com.example.restapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Funcionario {
    // id,nome,email,telefone,dt_contratacao,ativo
    @Id
    @SequenceGenerator(allocationSize = 1, name = "funcionario_seq", sequenceName = "funcionario_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    private Long Id;

    private String nome;

    private String email;

    private String telefone;

    @JoinColumn(name = "dt_contratacao")
    private Date dtContratacao;

    private Boolean ativo;

    @ManyToOne
    private TipoFuncionario tipoFuncionario;
}
