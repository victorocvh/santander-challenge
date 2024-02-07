package com.example.restapi.interfaces.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.model.Produto;

/**
 * ProductRepository
 */
public interface IProdutoRepository extends JpaRepository<Produto, Long> {

    
}
