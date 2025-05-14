package com.brandao.reserve.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brandao.reserve.dtos.requestsDTO.ReservationRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ReservationResponseDTO;
import com.brandao.reserve.services.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    private  ReservationService service;

    // @GetMapping
    // public ResponseEntity<List<ReservationResponseDTO>>findAll(){
        
    //     return ResponseEntity.ok(service.findAll());
    // }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>>findbyCpf(@RequestParam String cpf){
        
        return ResponseEntity.ok(service.findByClientCpf(cpf));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservationResponseDTO>findById(@PathVariable Long id){
        
        return ResponseEntity.ok(service.findById(id));
       
    }

     @PostMapping
    public ResponseEntity<ReservationResponseDTO>createClient(@RequestBody ReservationRequestDTO dto){

        var responseDto = service.createReservation(dto);
        
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDto.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservationResponseDTO>updateClient(@RequestBody ReservationRequestDTO dto, @PathVariable Long id){

        return ResponseEntity.ok(service.updateClient(dto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?>deleteClient(@PathVariable Long id){

        service.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

    
    
}
