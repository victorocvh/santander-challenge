package com.example.restapi.interfaces.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.TipoFuncionario;

public interface ITipoFuncionarioService {
    TipoFuncionario save(TipoFuncionario f);

    List<TipoFuncionario> findAll();

    Optional<TipoFuncionario> findById(Long id);

    TipoFuncionario update(TipoFuncionario f);

    void deleteById(TipoFuncionario f);
    
}
