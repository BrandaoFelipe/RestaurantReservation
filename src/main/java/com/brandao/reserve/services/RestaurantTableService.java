package com.brandao.reserve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.RestaurantTableDTO;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.mappers.RestaurantTableMapper;
import com.brandao.reserve.repositories.RestaurantTableRepository;
import com.brandao.reserve.services.handlers.EmptyResultException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {

    @Autowired
    private final RestaurantTableRepository repository;

    @Autowired
    private final RestaurantTableMapper mapper;

    @Transactional(readOnly = true)
    public List<RestaurantTableDTO> findAll() {

        List<RestaurantTable> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public RestaurantTableDTO findById(Long id) {

        RestaurantTable entity = repository.findById(id)
        .orElseThrow(() -> new EmptyResultException("Table not found with id: " + id));
    
    return mapper.toDTO(entity);
    }

    

}
