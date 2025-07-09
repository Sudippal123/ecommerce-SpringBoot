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
    private Instant createOn;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedOn;

    @PrePersist
    public void onCreate(){
        Instant now = Instant.now();
        this.createOn = now;
        this.updatedOn = now;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedOn = Instant.now();
    }


}
