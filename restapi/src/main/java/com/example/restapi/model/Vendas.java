package com.example.restapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Vendas {
    // id,id_cliente,id_vendedor,id_produto,quantidade,valor_total,valor_unit,data_venda,observacoes,mes_venda
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    private Integer quantidade;
    private Float valor_total;
    private Float valor_unit;
    private Date data_venda;
    private String observacoes;
    private String mes_venda;
}
