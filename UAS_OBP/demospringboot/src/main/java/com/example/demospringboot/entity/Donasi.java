package com.example.demospringboot.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "donasi")
public class Donasi extends Informasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String nama;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 15)
    private String telepon;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rekening rekening;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, precision = 15, scale = 2, columnDefinition = "DECIMAL(15,2)")
    private BigDecimal nominal;

    // Enum untuk rekening
    public enum Rekening {
        bca, mandiri, bni
    }

    // Enum untuk status
    public enum Status {
        terkonfirmasi, belum_konfirmasi
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }

    @Override
    public void detail() {
        System.out.println("Terimakasih telah berdonasi, " + this.nama + "!");
    }
}
