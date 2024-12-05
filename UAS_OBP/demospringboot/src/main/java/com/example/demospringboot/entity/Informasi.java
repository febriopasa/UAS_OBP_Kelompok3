package com.example.demospringboot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class Informasi {
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Transient
    private Date createdAtAsDate;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.createdAtAsDate = Date.from(this.createdAt.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.createdAtAsDate = Date.from(createdAt.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    public Date getCreatedAtAsDate() {
        return createdAtAsDate;
    }

    public void setCreatedAtAsDate(Date createdAtAsDate) {
        this.createdAtAsDate = createdAtAsDate;
    }

    public void detail() {
        System.out.println("Terimakasih telah berdonasi");
    }
    
}
