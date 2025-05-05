package com.brandao.reserve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
