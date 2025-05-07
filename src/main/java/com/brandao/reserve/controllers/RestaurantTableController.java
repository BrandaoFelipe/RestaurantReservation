package com.brandao.reserve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandao.reserve.dtos.RestaurantTableDTO;
import com.brandao.reserve.services.RestaurantTableService;

@RestController
@RequestMapping(value = "/restaurantTables")
public class RestaurantTableController {

    @Autowired
    private  RestaurantTableService service;

    @GetMapping
    public ResponseEntity<List<RestaurantTableDTO>>findAll(){
        
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantTableDTO>findById(@PathVariable Long id){
        
        return ResponseEntity.ok(service.findById(id));
       
    }
}
