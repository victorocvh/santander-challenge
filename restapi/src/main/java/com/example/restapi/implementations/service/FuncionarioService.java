package com.example.restapi.implementations.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.IFuncionarioRepository;
import com.example.restapi.interfaces.service.IFuncionarioService;
import com.example.restapi.model.Funcionario;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService implements IFuncionarioService {


    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario f) {

        f.setAtivo(true);
        f.setDtContratacao(new Date());
        return funcionarioRepository.save(f);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public Funcionario update(Funcionario f) {
        // Para um produto ser atualizado precisa ter relação com um funcionário. 
        Optional<Funcionario> opFuncionario = funcionarioRepository.findById(f.getId());
     
        if (!opFuncionario.isPresent()) {
            throw new EntityNotFoundException("Funcionário não encontrado");
        }

        return funcionarioRepository.save(f);
    }

    @Override
    public void deleteById(Funcionario produto) {
        funcionarioRepository.delete(produto);
    }
    
}
