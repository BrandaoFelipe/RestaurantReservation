package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.brandao.reserve.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);
}
