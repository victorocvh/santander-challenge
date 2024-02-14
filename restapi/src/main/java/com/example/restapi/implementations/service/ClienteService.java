package com.example.restapi.implementations.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.IClienteRepository;
import com.example.restapi.interfaces.service.IClienteService;
import com.example.restapi.model.Cliente;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService implements IClienteService {


    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente f) {

        f.setDt_criacao(new Date());
        return clienteRepository.save(f);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(Cliente f) {
        // Para um c ser atualizado precisa ter relação com um funcionário. 
        Optional<Cliente> opCliente = clienteRepository.findById(f.getId());
     
        if (!opCliente.isPresent()) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }

        return clienteRepository.save(f);
    }

    @Override
    public void deleteById(Cliente c) {
        clienteRepository.delete(c);
    }
    
}
