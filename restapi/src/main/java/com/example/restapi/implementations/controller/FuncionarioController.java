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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.implementations.service.FuncionarioService;
import com.example.restapi.implementations.service.ProductService;
import com.example.restapi.model.Funcionario;

@RestController
@RequestMapping("/api/v1/funcionarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class FuncionarioController {
  
        @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionario>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(
        @RequestBody Funcionario f){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(f));
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(
    @RequestBody Funcionario f){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.update(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Funcionario> opFuncionario = funcionarioService.findById(id);
        
        if (opFuncionario == null) {
            return ResponseEntity.notFound().build();
        } else {
            Funcionario produto = opFuncionario.get();
            funcionarioService.deleteById(produto);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
