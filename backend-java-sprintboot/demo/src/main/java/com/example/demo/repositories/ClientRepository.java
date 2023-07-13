package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}