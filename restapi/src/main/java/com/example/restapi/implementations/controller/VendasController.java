package com.example.restapi.implementations.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.restapi.dto.request.VendasRequestDTO;
import com.example.restapi.dto.response.VendasResponseDTO;

@RestController
@RequestMapping("/api/v1/vendas")
@CrossOrigin(origins = "http://localhost:4200/")
public class VendasController {
    
    @Autowired
    private VendasService vendasService;

    @GetMapping
    public ResponseEntity<List<VendasResponseDTO>> findAll() {
        List<VendasResponseDTO> res = vendasService.findAll().stream().map(x -> new VendasResponseDTO(x))
        .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vendas>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vendas> create(@RequestBody VendasRequestDTO vendas){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendasService.save(vendas));
    }

    // @PutMapping
    // public ResponseEntity<Vendas> update(@RequestBody VendasRequestDTO vendasDTO){
    //     return ResponseEntity.status(HttpStatus.OK).body(vendasService.update(vendas));
    // }

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
