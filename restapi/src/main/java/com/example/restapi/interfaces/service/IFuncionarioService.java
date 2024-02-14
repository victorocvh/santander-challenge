package com.example.restapi.interfaces.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Funcionario;

/**
 * IFuncionarioService
 */
public interface IFuncionarioService {

    Funcionario save(Funcionario f);

    List<Funcionario> findAll();

    Optional<Funcionario> findById(Long id);

    Funcionario update(Funcionario f);

    void deleteById(Funcionario f);
}
// public class IFuncionarioService {
    
// }
