package com.example.restapi.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.restapi.dto.request.VendasRequestDTO;

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
public class Vendas {
    // id,id_cliente,id_vendedor,id_produto,quantidade,valor_total,valor_unit,data_venda,observacoes,mes_venda
    @Id
    @SequenceGenerator(allocationSize = 1, name = "vendas_seq", sequenceName = "vendas_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendas_seq")
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

    @JoinColumn(name = "valor_total")
    private Float valorTotal;

    @JoinColumn(name = "valor_unit")
    private Float valorUnit;
    @JoinColumn(name = "data_venda")
    private Date dataVenda;
    private String observacoes;
    @JoinColumn(name = "mes_venda")
    private String mesVenda;

    public Vendas() {
        super();
    }
    
    public Vendas(VendasRequestDTO v, Cliente c, Produto p, Funcionario f) {
        this.cliente = c;
        this.produto = p;
        this.funcionario = f;
        this.quantidade = v.getQuantidade();
        this.valorTotal = v.getQuantidade() * p.getPreco().floatValue();
        this.valorUnit = p.getPreco().floatValue();
        this.dataVenda = new Date();
        this.observacoes = v.getObservacoes();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        String mesVenda = sdf.format(dataVenda);
        this.mesVenda = mesVenda.replaceAll("\\.", "");
    }
}
