package com.example.restapi.implementations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.IProdutoRepository;
import com.example.restapi.interfaces.service.IProdutoService;
import com.example.restapi.model.Produto;

@Service
public class ProductService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteById(Produto produto) {
        produtoRepository.delete(produto);
    }
    
}
