package com.example.restapi.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.Vendas;

/**
 * IVendasRepository
 */
public interface IVendasRepository extends JpaRepository<Vendas, Long> {

    
}
