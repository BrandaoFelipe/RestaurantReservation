package com.brandao.reserve.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.ReservationDTO;
import com.brandao.reserve.dtos.RestaurantTableDTO;
import com.brandao.reserve.entities.Reservation;
import com.brandao.reserve.mappers.ReservationMapper;
import com.brandao.reserve.repositories.ReservationRepository;
import com.brandao.reserve.services.handlers.EmptyResultException;
import com.brandao.reserve.services.handlers.EntityNotAvailableException;

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
                .orElseThrow(() -> new EmptyResultException("Reservation not found with id: " + id));

        return mapper.toDTO(entity);
    }

    @Transactional
    public ReservationDTO createReservation(ReservationDTO dto) {

        List<Long>tablesId = new ArrayList<>();
        LocalDateTime bookingDateTime = dto.getDateTime();

        for(RestaurantTableDTO rt : dto.getTables()){
            
            tablesId.add(rt.getId());
        }

        if(repository.isTableReserved(tablesId, bookingDateTime)){
            throw new EntityNotAvailableException("table isn't available for booking");
        }
        
        repository.save(mapper.toEntity(dto));
        return dto;

    }
}
