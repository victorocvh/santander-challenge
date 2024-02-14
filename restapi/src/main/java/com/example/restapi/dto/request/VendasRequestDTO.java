package com.example.restapi.dto.request;

import lombok.Data;

@Data
public class VendasRequestDTO {
    private Integer quantidade;
    private String observacoes;
    private Long idProduto;
    private Long idFuncionario;
    private Long idCliente;
}
