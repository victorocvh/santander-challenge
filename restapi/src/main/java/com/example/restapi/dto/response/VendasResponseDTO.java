package com.example.restapi.dto.response;

import java.util.Date;

import com.example.restapi.model.Vendas;

import lombok.Data;

@Data
public class VendasResponseDTO {
    
    private String nomeCliente;
    private String nomeFuncionario;
    private String tipoFuncionario;
    private String nomeProduto;
    private Float valorTotal;
    private Integer quantidade;
    private Date dataVenda;
    private Long idFuncionario;
    private Long idCliente;
    private Long idProduto; 
    
    public VendasResponseDTO() {
    }

    public VendasResponseDTO(Vendas venda) {
        this.nomeCliente = venda.getCliente().getNome();
        this.nomeFuncionario = venda.getFuncionario().getNome();
        this.tipoFuncionario = venda.getFuncionario().getTipoFuncionario().getDescricao();
        this.nomeProduto = venda.getProduto().getNomeProduto();
        this.valorTotal = venda.getValorTotal();
        this.quantidade = venda.getQuantidade();
        this.dataVenda = venda.getDataVenda();
        this.idCliente = venda.getCliente().getId();
        this.idFuncionario = venda.getFuncionario().getId();
        this.idProduto = venda.getProduto().getId();
    }
}