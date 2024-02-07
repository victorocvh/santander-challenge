package com.example.restapi.implementations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.implementations.service.VendasService;
import com.example.restapi.model.Vendas;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendasController {
    
    @Autowired
    private VendasService vendasService;

    @GetMapping
    public ResponseEntity<List<Vendas>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vendas>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vendas> create(@RequestBody Vendas product){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendasService.save(product));
    }

    @PutMapping
    public ResponseEntity<Vendas> update(@RequestBody Vendas product){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Vendas> opVendas = vendasService.findById(id);
        
        if (opVendas == null) {
            return ResponseEntity.notFound().build();
        } else {
            Vendas vendas = opVendas.get();
            vendasService.deleteById(vendas);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
