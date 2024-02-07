package com.example.restapi.implementations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.IVendasRepository;
import com.example.restapi.interfaces.service.IVendasService;
import com.example.restapi.model.Vendas;

@Service
public class VendasService implements IVendasService {

    @Autowired
    private IVendasRepository vendasRepository;

    @Override
    public Vendas save(Vendas vendas) {
        return vendasRepository.save(vendas);
    }

    @Override
    public List<Vendas> findAll() {
        return vendasRepository.findAll();
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
