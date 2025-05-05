package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.brandao.reserve.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
