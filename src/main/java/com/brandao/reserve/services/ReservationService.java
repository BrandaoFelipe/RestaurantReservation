package com.brandao.reserve.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brandao.reserve.dtos.requestsDTO.ReservationRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ReservationResponseDTO;
import com.brandao.reserve.entities.Reservation;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.entities.TableReservation;
import com.brandao.reserve.mappers.ReservationMapper;
import com.brandao.reserve.repositories.ReservationRepository;
import com.brandao.reserve.services.exceptions.EmptyResultException;
import com.brandao.reserve.services.exceptions.EntityNotAvailableException;
import com.brandao.reserve.services.exceptions.InvalidRequestException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository repository;

    @Autowired
    private final ReservationMapper mapper;

    @Transactional(readOnly = true)
    public List<ReservationResponseDTO> findAll() {

        List<Reservation> entities = repository.findAll();
        if (entities.isEmpty()) {

            throw new EmptyResultException("Nothing found");
        }

        return entities.stream().map(mapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public ReservationResponseDTO findById(Long id) {

        Reservation entity = repository.findById(id)
                .orElseThrow(() -> new EmptyResultException("Reservation not found with id: " + id));

        return mapper.toDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ReservationResponseDTO> findByClientCpf(String cpf) {

        List<Reservation> entities = repository.reservationByClientCpf(cpf);

        List<ReservationResponseDTO> responseDTO = entities.stream().map(mapper::toDTO).toList();

        return responseDTO;
    }

    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO dto) {

        if (dto == null)
            throw new InvalidRequestException("Reservation data is required");

        List<Integer> tablesNumber = new ArrayList<>();

        LocalDateTime beginReservation = dto.getBeginReservation();
        LocalDateTime endReservation = dto.getEndReservation();

        
        for (Integer rt : dto.getTableNumbers()) {

            tablesNumber.add(rt);
        }

        if (repository.isTableReserved(tablesNumber, beginReservation, endReservation)) {
            throw new EntityNotAvailableException("table isn't available for booking");
        }
        

        Reservation entity = mapper.toEntity(dto);
        entity.setClient(repository.getClient(dto.getClientCpf()));

        List<RestaurantTable> tables = repository.getTable(tablesNumber);
        
        List<TableReservation> tableReservation = tables.stream().map(tableDTO ->
            TableReservation.builder()
            .reservation(entity)
            .restaurantTable(tableDTO)
            .build()
        ).collect(Collectors.toList());

        entity.setReservations(tableReservation);

        repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Transactional
    public ReservationResponseDTO updateClient(ReservationRequestDTO dto, Long id) {

        Reservation entity = repository.getReferenceById(id);

        entity = mapper.toEntity(dto);

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
