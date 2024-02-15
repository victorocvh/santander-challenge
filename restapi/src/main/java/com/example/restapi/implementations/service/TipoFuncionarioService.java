package com.example.restapi.implementations.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.interfaces.repository.ITipoFuncionarioRepository;
import com.example.restapi.interfaces.service.ITipoFuncionarioService;
import com.example.restapi.model.TipoFuncionario;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoFuncionarioService implements ITipoFuncionarioService {
   
    @Autowired
    private ITipoFuncionarioRepository tipoFuncionarioRepository;

    @Override
    public TipoFuncionario save(TipoFuncionario f) {


        return tipoFuncionarioRepository.save(f);
    }

    @Override
    public List<TipoFuncionario> findAll() {
        return tipoFuncionarioRepository.findAll();
    }

    @Override
    public Optional<TipoFuncionario> findById(Long id) {
        return tipoFuncionarioRepository.findById(id);
    }

    @Override
    public TipoFuncionario update(TipoFuncionario f) {
        // Para um produto ser atualizado precisa ter relação com um funcionário. 
        Optional<TipoFuncionario> opTipoFuncionario = tipoFuncionarioRepository.findById(f.getId());
     
        if (!opTipoFuncionario.isPresent()) {
            throw new EntityNotFoundException("Funcionário não encontrado");
        }

        return tipoFuncionarioRepository.save(f);
    }

    @Override
    public void deleteById(TipoFuncionario f) {
        tipoFuncionarioRepository.delete(f);
    }

}
