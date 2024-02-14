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
public class HistPrecoProduto {

    // id,id_produto,id_vendedor,preco,dt_atualizacao
    @Id
    @SequenceGenerator(allocationSize = 1, name = "hist_preco_produto_seq", sequenceName = "hist_preco_produto_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hist_preco_produto_seq")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    private Float preco;

    @JoinColumn(name = "dt_atualizacao")
    private Date dtAtualizacao;

    public HistPrecoProduto() {}

    public HistPrecoProduto(Produto pAntigo, Funcionario f, Date dtAtualizacao) {
        this.produto = pAntigo;
        this.funcionario = f;
        this.preco = pAntigo.getPreco().floatValue();
        this.dtAtualizacao = dtAtualizacao;
    }
}
