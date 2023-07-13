package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.SaleModel;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel, Long> {

}