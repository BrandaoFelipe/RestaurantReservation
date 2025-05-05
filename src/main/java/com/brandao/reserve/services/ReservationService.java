package com.brandao.reserve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.ReservationDTO;
import com.brandao.reserve.entities.Reservation;
import com.brandao.reserve.mappers.ReservationMapper;
import com.brandao.reserve.repositories.ReservationRepository;
import com.brandao.reserve.services.handlers.EmptyResultException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository repository;
    @Autowired
    private final ReservationMapper mapper;
    

    @Transactional(readOnly = true)
    public List<ReservationDTO> findAll() {

        List<Reservation> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public ReservationDTO findById(Long id) {

        Reservation entity = repository.findById(id)
        .orElseThrow(() -> new EmptyResultException("Cliente não encontrado com id " + id));
    
    return mapper.toDTO(entity);
    }

}
