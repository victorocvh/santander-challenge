package com.example.restapi.implementations.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.restapi.implementations.service.ClienteService;
import com.example.restapi.model.Cliente;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClienteController {
  
        @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(
        @RequestBody Cliente f){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(f));
    }

    @PutMapping
    public ResponseEntity<Cliente> update(   
    @RequestBody Cliente f){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Cliente> opCliente = clienteService.findById(id);
        
        if (opCliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            Cliente produto = opCliente.get();
            clienteService.deleteById(produto);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
