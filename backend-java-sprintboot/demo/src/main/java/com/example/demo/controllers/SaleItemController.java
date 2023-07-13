package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.SaleItemModel;
import com.example.demo.models.SaleModel;
import com.example.demo.repositories.SaleItemRepository;
import com.example.demo.repositories.SaleRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/sale-items")
public class SaleItemController {
    private final SaleItemRepository saleItemRepository;

    @Autowired
    public SaleItemController(SaleItemRepository saleItemRepository, SaleRepository saleRepository) {
        this.saleItemRepository = saleItemRepository;
        this.saleRepository = saleRepository;
    }

    @GetMapping
    public List<SaleItemModel> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public SaleItemModel getSaleItemById(@PathVariable Long id) {
        return saleItemRepository.findById(id).orElse(null);
    }

    @PostMapping
    public SaleItemModel createSaleItem(@RequestBody SaleItemModel saleItem) {
        return saleItemRepository.save(saleItem);
    }

    private SaleRepository saleRepository;

    @GetMapping("/sale/{saleId}")
    public ResponseEntity<List<SaleItemModel>> getSaleItemsBySaleId(@PathVariable Long saleId) {
        Optional<SaleModel> sale = saleRepository.findById(saleId);
        if (sale.isPresent()) {
            SaleModel saleModel = sale.get();
            List<SaleItemModel> list = saleItemRepository.findBySaleId(saleModel);
            return ResponseEntity.ok(list);
        }

        return ResponseEntity.badRequest().build();
    }

}