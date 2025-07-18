package com.example.Ecommerce.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant created_on;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updated_on;

    @PrePersist
    public void onCreate(){
        Instant now = Instant.now();
        this.created_on = now;
        this.updated_on = now;
    }

    @PreUpdate
    public void onUpdate(){
        this.updated_on = Instant.now();
    }


}
