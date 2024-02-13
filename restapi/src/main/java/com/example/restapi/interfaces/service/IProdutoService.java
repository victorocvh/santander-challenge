package com.example.restapi.interfaces.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Produto;

/**
 * ProdutoService
 */
public interface IProdutoService {

    Produto save(Produto produto);

    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    Produto update(Long funcionarioId, Produto produto);

    void deleteById(Produto produto);
    
}
