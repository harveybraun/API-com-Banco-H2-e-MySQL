package com.example.hbmysql.controller;

import com.example.hbmysql.model.ClientEntity;
import com.example.hbmysql.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Harvey Braun
 * @version 1.0
 * @since 25/04/2020
 */
@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClientEntity>> findAll() {
        return new ResponseEntity<List<ClientEntity>>(
                (List<ClientEntity>) this.clientRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientEntity> findById(@PathVariable("id_cliente") long id) {
        if (this.clientRepository.findById(id).isPresent()) {
            return new ResponseEntity<ClientEntity>(
                    this.clientRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ClientEntity> store(@RequestBody ClientEntity clientEntity) {
        return new ResponseEntity<ClientEntity>(
                this.clientRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> update(@PathVariable("id") long id,
                                               @RequestBody ClientEntity clientEntity) throws Exception {

        if (id == 0 || !this.clientRepository.existsById(id)) {
            throw new Exception("Codigo Não Encontrado ou Inexistente");
        }

        return new ResponseEntity<ClientEntity>(
                this.clientRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> delete(@PathVariable("id") long id) {
        this.clientRepository.deleteById(id);
        return new ResponseEntity<ClientEntity>(new HttpHeaders(), HttpStatus.OK);
    }

    /*
    @GetMapping("/clientes")
    public ClientEntity store(ClientEntity clientEntity) {
        return this.clientRepository.save(clientEntity);
    }
    */

}

