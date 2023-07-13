package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sale_item")
public class SaleItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleModel saleId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public SaleItemModel() {
    }

    public SaleItemModel(Long id, SaleModel saleId, ProductModel productId, int quantity) {
        this.id = id;
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public SaleModel getSaleId() {
        return saleId;
    }

    public ProductModel getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

}