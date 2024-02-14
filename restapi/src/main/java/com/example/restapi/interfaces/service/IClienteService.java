package com.example.restapi.interfaces.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Cliente;

/**
 * IClienteService
 */
public interface IClienteService {

    Cliente save(Cliente f);

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente update(Cliente f);

    void deleteById(Cliente f);
}
// public class IClienteService {
    
// }
