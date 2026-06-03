package com.example.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "receipts") // Explicitly table name defined
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private LocalDateTime saleDate;
    private Double totalAmount;

    // 🌟 FIXED: Join table and column names changed to standard snake_case for Linux/Railway compatibility
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "receipt_items",
            joinColumns = @JoinColumn(name = "receipt_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    )
    private List<Medicine> items;
}
