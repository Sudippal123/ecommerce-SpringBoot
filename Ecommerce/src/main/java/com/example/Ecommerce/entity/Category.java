package com.example.Ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;
}
