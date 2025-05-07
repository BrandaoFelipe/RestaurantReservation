package com.brandao.reserve.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brandao.reserve.dtos.ReservationDTO;
import com.brandao.reserve.services.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    private  ReservationService service;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>>findAll(){
        
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservationDTO>findById(@PathVariable Long id){
        
        return ResponseEntity.ok(service.findById(id));
       
    }

    @PostMapping
    public ResponseEntity<ReservationDTO>booking(@RequestBody ReservationDTO dto){
        
        dto = service.createReservation(dto);
        
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(dto.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(dto); 
    }
    
}
