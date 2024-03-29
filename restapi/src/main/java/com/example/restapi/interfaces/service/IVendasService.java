package com.example.restapi.interfaces.service;

import java.util.List;
import java.util.Optional;

import com.example.restapi.dto.request.VendasRequestDTO;
import com.example.restapi.model.Vendas;

/**
 * IVendasService
 */
public interface IVendasService {

    Vendas save(VendasRequestDTO vendasDTO);

    List<Vendas> findAll();

    Optional<Vendas> findById(Long id);

    Vendas update(Vendas vendas);

    void deleteById(Vendas vendas);
}
// public class IVendasService {
    
// }
