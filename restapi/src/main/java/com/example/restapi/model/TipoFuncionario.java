package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class TipoFuncionario {
    
    @Id
    @SequenceGenerator(allocationSize = 1, name = "tipo_funcionario_seq", sequenceName = "tipo_funcionario_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_funcionario_seq")
    private Long id;

    private String descricao;

}
