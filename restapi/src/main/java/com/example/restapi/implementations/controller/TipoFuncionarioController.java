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

import com.example.restapi.implementations.service.TipoFuncionarioService;
import com.example.restapi.model.TipoFuncionario;

import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/api/v1/tipofuncionarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class TipoFuncionarioController {
    
    @Autowired
    private TipoFuncionarioService tipoFuncionarioService;

    @GetMapping
    public ResponseEntity<List<TipoFuncionario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoFuncionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TipoFuncionario>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoFuncionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoFuncionario> create(
        @RequestBody TipoFuncionario f){
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoFuncionarioService.save(f));
    }

    @PutMapping
    public ResponseEntity<TipoFuncionario> update(
    @RequestBody TipoFuncionario f){
        return ResponseEntity.status(HttpStatus.OK).body(tipoFuncionarioService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<TipoFuncionario> opTipoFuncionario = tipoFuncionarioService.findById(id);
        
        if (opTipoFuncionario == null) {
            throw new EntityNotFoundException("Tipo Funcionário Não Encontrado");
        } else {
            TipoFuncionario produto = opTipoFuncionario.get();
            tipoFuncionarioService.deleteById(produto);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
