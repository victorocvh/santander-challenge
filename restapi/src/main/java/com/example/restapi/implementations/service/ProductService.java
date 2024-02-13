package com.example.restapi.implementations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.IFuncionarioRepository;
import com.example.restapi.interfaces.repository.IHistPrecoProdutoRepository;
import com.example.restapi.interfaces.repository.IProdutoRepository;
import com.example.restapi.interfaces.service.IProdutoService;
import com.example.restapi.model.Funcionario;
import com.example.restapi.model.Produto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IHistPrecoProdutoRepository histPrecoProdutoRepository;

    @Autowired
    private IFuncionarioRepository funcionarioRepository;

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
    public Produto update(Long funcionarioId,Produto produto) {
        // Para um produto ser atualizado precisa ter relação com um funcionário. 
        System.out.println("Funcionario" + funcionarioId);
        Optional<Funcionario> opFuncionario = funcionarioRepository.findById(funcionarioId);
        Optional<Produto> opProduto = produtoRepository.findById(produto.getId());

        if (!opFuncionario.isPresent()) {
            throw new EntityNotFoundException("Funcionário não encontrado");
        }

        if (!opProduto.isPresent()) {
            throw new EntityNotFoundException("Produto não encontrado");
        }

        Double precoProdDB = opProduto.get().getPreco();
        Double precoProdRequest = produto.getPreco();

        return produtoRepository.save(produto);
    }

    @Override
    public void deleteById(Produto produto) {
        produtoRepository.delete(produto);
    }
    
}
