package com.brandao.reserve.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brandao.reserve.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

     @Query(nativeQuery = true, value = "SELECT * FROM TB_ROLE AS TB WHERE TB.USER_ROLE IN (:getRoles)" )
    public Set<Roles> getRoleByName(@Param("getRoles") List<String> getRoles);

}
