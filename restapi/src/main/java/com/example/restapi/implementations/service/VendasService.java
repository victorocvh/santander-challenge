package com.example.restapi.implementations.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.restapi.dto.request.VendasRequestDTO;
import com.example.restapi.interfaces.repository.IClienteRepository;
import com.example.restapi.interfaces.repository.IFuncionarioRepository;
import com.example.restapi.interfaces.repository.IProdutoRepository;
import com.example.restapi.interfaces.repository.IVendasRepository;
import com.example.restapi.interfaces.service.IVendasService;
import com.example.restapi.model.Cliente;
import com.example.restapi.model.Funcionario;
import com.example.restapi.model.Produto;
import com.example.restapi.model.Vendas;


import jakarta.persistence.EntityNotFoundException;


import org.springframework.util.ObjectUtils;
@Service
public class VendasService implements IVendasService {

    @Autowired
    private IVendasRepository vendasRepository;
    @Autowired
    private IFuncionarioRepository funcionarioRepository;
    @Autowired 
    private IProdutoRepository produtoRepository;
    @Autowired
    private IClienteRepository clienteRepository;

    @SuppressWarnings("null")
    @Override
    public Vendas save(VendasRequestDTO vendasDTO) {

        if ( ObjectUtils.isEmpty(vendasDTO.getIdCliente()) ||
             ObjectUtils.isEmpty(vendasDTO.getIdProduto()) || 
             ObjectUtils.isEmpty(vendasDTO.getIdFuncionario()) || 
             ObjectUtils.isEmpty(vendasDTO.getQuantidade())) {
           throw new EntityNotFoundException("Faltando parâmetro..");
        }

        
        Optional<Produto> produto = produtoRepository.findById(vendasDTO.getIdProduto());
        Optional<Cliente> cliente = clienteRepository.findById(vendasDTO.getIdCliente());
        Optional<Funcionario> func = funcionarioRepository.findById(vendasDTO.getIdFuncionario());

        if (!produto.isPresent() || !cliente.isPresent() || !func.isPresent()) {
            throw new EntityNotFoundException("Entidade não encontrada");
        }

        Vendas v = new Vendas(vendasDTO,cliente.get(), produto.get(), func.get());
        return vendasRepository.save(v);
    }

    @Override
    public List<Vendas> findAll() {
        return vendasRepository.findAll(Sort.by(Direction.DESC, "dataVenda"));
    }

    @Override
    public Optional<Vendas> findById(Long id) {
        return vendasRepository.findById(id);
    }

    @Override
    public Vendas update(Vendas vendas) {
        return vendasRepository.save(vendas);
    }

    @Override
    public void deleteById(Vendas vendas) {
        vendasRepository.delete(vendas);
    }


    
}
