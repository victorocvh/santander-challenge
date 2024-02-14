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
public class Produto {
    // id,nome_produto,descricao,preco,dt_atualizacao_preco,ativo
    @Id
    @SequenceGenerator(allocationSize = 1, name = "produto_seq", sequenceName = "produto_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private Long Id;

    @JoinColumn(name = "nome_produto")
    private String nomeProduto;

    private String descricao;

    private Double preco;

    @JoinColumn(name = "dt_atualizacao_preco")
    private Date dtAtualizacaoPreco;

    private Boolean ativo;

    public Produto() {
    }

    public Produto(Produto p, Date dtAtualizacao) {
        this.ativo = p.getAtivo();
        this.descricao = p.getDescricao();
        this.dtAtualizacaoPreco = dtAtualizacao;
        this.Id = p.getId();
        this.nomeProduto = p.getNomeProduto();
        this.preco = p.getPreco();
    }
}
