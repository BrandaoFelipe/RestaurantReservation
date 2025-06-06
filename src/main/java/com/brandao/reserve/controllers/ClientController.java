package com.brandao.reserve.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brandao.reserve.dtos.requestsDTO.ClientRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ClientResponseDTO;
import com.brandao.reserve.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));

    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO dto) {

        var responseDto = service.createClient(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@RequestBody ClientRequestDTO dto, @PathVariable Long id) {

        return ResponseEntity.ok(service.updateClient(dto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {

        service.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/encode")
    public String encodePassword() {
        return new BCryptPasswordEncoder().encode("123lotr");
    }

}
