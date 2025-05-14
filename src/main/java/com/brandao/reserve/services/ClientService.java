package com.brandao.reserve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.requestsDTO.ClientRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ClientResponseDTO;
import com.brandao.reserve.entities.Client;
import com.brandao.reserve.mappers.ClientMapper;
import com.brandao.reserve.repositories.ClientRepository;
import com.brandao.reserve.services.exceptions.EmptyResultException;
import com.brandao.reserve.services.exceptions.EntityNotAvailableException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository repository;

    @Autowired
    private final ClientMapper mapper;

    @Transactional(readOnly = true)
    public List<ClientResponseDTO> findAll() {

        List<Client> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public ClientResponseDTO findById(Long id) {

        Client entity = repository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Client not found with id: " + id));

        return mapper.toDTO(entity);

    }

    @Transactional
    public ClientResponseDTO createClient(ClientRequestDTO dto) {

        if (dto == null)
            throw new EmptyResultException("ClientNotFound");

        Client entity = mapper.toEntity(dto);

        repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Transactional
    public ClientResponseDTO updateClient(ClientRequestDTO dto, Long id) {

        Client entity = repository.findById(id).orElseThrow(() -> new EntityNotAvailableException("EntityNotFound"));

        entity = mapper.UpdateDtoToEntity(dto, entity);
        
        repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Transactional
    public void deleteClient(Long id) {

        if (!repository.existsById(id))
            throw new EmptyResultException("ClientNotFound");

        repository.deleteById(id);
    }

}
