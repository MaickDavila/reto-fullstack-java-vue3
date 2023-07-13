package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ClientModel;
import com.example.demo.repositories.ClientRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public ClientModel createClient(@RequestBody ClientModel client) {
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable Long id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}