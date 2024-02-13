package com.example.restapi.implementations.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.restapi.implementations.service.ProductService;
import com.example.restapi.model.Produto;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping
    public ResponseEntity<Produto> update(
    @RequestParam Long funcionarioId,    
    @RequestBody Produto product){
        System.out.println("AOXNXXBA");
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(funcionarioId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Produto> opProduto = productService.findById(id);
        
        if (opProduto == null) {
            return ResponseEntity.notFound().build();
        } else {
            Produto produto = opProduto.get();
            productService.deleteById(produto);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
