package com.brandao.reserve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.requestsDTO.RestaurantTableRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.RestaurantTableResponseDTO;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.mappers.RestaurantTableMapper;
import com.brandao.reserve.repositories.RestaurantTableRepository;
import com.brandao.reserve.services.exceptions.EmptyResultException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {

    @Autowired
    private final RestaurantTableRepository repository;

    @Autowired
    private final RestaurantTableMapper mapper;

    @Transactional(readOnly = true)
    public List<RestaurantTableResponseDTO> findAll() {

        List<RestaurantTable> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public RestaurantTableResponseDTO findById(Long id) {

        RestaurantTable entity = repository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Table not found with id: " + id));

        return mapper.toDTO(entity);

    }

    @Transactional
    public RestaurantTableResponseDTO createTable(RestaurantTableRequestDTO dto) {

        if (dto == null) throw new EmptyResultException("TableNotFound");

       RestaurantTable entity = mapper.toNewEntity(dto);

        repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Transactional
    public RestaurantTableResponseDTO updateTable(RestaurantTableRequestDTO dto, Long id) {

        RestaurantTable entity = repository.getReferenceById(id);

        entity = mapper.toNewEntity(dto);

        repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Transactional
    public void deleteTable(Long id) {

        if (!repository.existsById(id))
            throw new EmptyResultException("TableNotFound");

        repository.deleteById(id);
    }

}
