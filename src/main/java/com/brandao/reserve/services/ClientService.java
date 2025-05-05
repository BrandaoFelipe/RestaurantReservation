package com.brandao.reserve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.ClientDTO;
import com.brandao.reserve.entities.Client;
import com.brandao.reserve.mappers.ClientMapper;
import com.brandao.reserve.repositories.ClientRepository;
import com.brandao.reserve.services.handlers.EmptyResultException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository repository;

    @Autowired
    private final ClientMapper mapper;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {

        List<Client> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {

        Client entity = repository.findById(id)
        .orElseThrow(() -> new EmptyResultException("Cliente não encontrado com id " + id));
    
    return mapper.toDTO(entity);
    }

}
