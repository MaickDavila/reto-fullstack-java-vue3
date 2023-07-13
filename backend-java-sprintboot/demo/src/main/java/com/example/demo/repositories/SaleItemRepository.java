package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.SaleItemModel;
import com.example.demo.models.SaleModel;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItemModel, Long> {
    List<SaleItemModel> findBySaleId(SaleModel sale);

}