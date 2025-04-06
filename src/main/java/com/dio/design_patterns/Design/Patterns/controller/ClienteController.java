package com.dio.design_patterns.Design.Patterns.controller;

import com.dio.design_patterns.Design.Patterns.models.Cliente;
import com.dio.design_patterns.Design.Patterns.servico.serviceImplementations.ClienteServiceImplemenation1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    ClienteServiceImplemenation1 clienteServiceImplemenation1;


    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getAll(){
        return ResponseEntity.ok( clienteServiceImplemenation1.getAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getById(@PathVariable String cpf){
        return ResponseEntity.ok(clienteServiceImplemenation1.getById(cpf));
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServiceImplemenation1.saveCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteServiceImplemenation1.updateCliente(cliente));
    }


}
