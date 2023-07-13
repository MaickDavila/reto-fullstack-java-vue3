package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.SaleModel;
import com.example.demo.services.SaleService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public SaleModel registerSale(@RequestBody SaleModel sale) {
        return saleService.registerSale(sale);
    }

    @GetMapping("/{id}")
    public SaleModel getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }

    @GetMapping
    public List<SaleModel> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/date")
    public List<SaleModel> getSalesByDateRange(@RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return saleService.getSalesByDateRange(start, end);
    }
}