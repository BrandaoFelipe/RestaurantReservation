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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brandao.reserve.dtos.requestsDTO.RestaurantTableRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.RestaurantTableResponseDTO;
import com.brandao.reserve.services.RestaurantTableService;

@RestController
@RequestMapping(value = "/restaurantTables")
public class RestaurantTableController {

    @Autowired
    private  RestaurantTableService service;

    @GetMapping
    public ResponseEntity<List<RestaurantTableResponseDTO>>findAll(){
        
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantTableResponseDTO>findById(@PathVariable Long id){
        
        return ResponseEntity.ok(service.findById(id));
       
    }

    @PostMapping
    public ResponseEntity<RestaurantTableResponseDTO>createTable(@RequestBody RestaurantTableRequestDTO dto){

        var responseDto = service.createTable(dto);
        
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(responseDto.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RestaurantTableResponseDTO>updateTable(@RequestBody RestaurantTableRequestDTO dto, @PathVariable Long id){

        return ResponseEntity.ok(service.updateTable(dto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?>deleteClient(@PathVariable Long id){

        service.deleteTable(id);

        return ResponseEntity.noContent().build();
    }
    
}
