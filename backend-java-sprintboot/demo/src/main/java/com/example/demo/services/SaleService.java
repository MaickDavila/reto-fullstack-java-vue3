package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.SaleModel;
import com.example.demo.repositories.SaleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public SaleModel registerSale(SaleModel sale) {
        return saleRepository.save(sale);
    }

    public List<SaleModel> getAllSales() {
        return saleRepository.findAll();
    }

    public SaleModel getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sale not found with id: " + id));
    }

    public List<SaleModel> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        List<SaleModel> salesByDate = new ArrayList<>();
        List<SaleModel> allSales = saleRepository.findAll();
        for (SaleModel sale : allSales) {
            LocalDate saleDate = sale.getDate();
            if (saleDate.isEqual(startDate)
                    || (saleDate.isAfter(startDate) && saleDate.isBefore(endDate.plusDays(1)))) {
                salesByDate.add(sale);
            }
        }
        return salesByDate;
    }
}