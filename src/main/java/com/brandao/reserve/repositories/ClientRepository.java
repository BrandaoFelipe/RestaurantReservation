package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brandao.reserve.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_CLIENT CLI WHERE CLI.CPF = :cpf" )
    public Client findByCpf(@Param("cpf") String cpf);

}
