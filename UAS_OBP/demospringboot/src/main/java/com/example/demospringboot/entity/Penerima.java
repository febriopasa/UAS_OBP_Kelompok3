package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "penerima")
public class Penerima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int penerimaId;

    @Column(nullable = false, length = 255)
    private String penerimaNama;

    @Column(nullable = false, length = 255)
    private String penerimaAlamat;

    @Column(nullable = false)
    private double totalTerima;

    // Getter dan Setter
    public int getPenerimaId() {
        return penerimaId;
    }

    public void setPenerimaId(int penerimaId) {
        this.penerimaId = penerimaId;
    }

    public String getPenerimaNama() {
        return penerimaNama;
    }

    public void setPenerimaNama(String penerimaNama) {
        this.penerimaNama = penerimaNama;
    }

    public String getPenerimaAlamat() {
        return penerimaAlamat;
    }

    public void setPenerimaAlamat(String penerimaAlamat) {
        this.penerimaAlamat = penerimaAlamat;
    }

    public double getTotalTerima() {
        return totalTerima;
    }

    public void setTotalTerima(double totalTerima) {
        this.totalTerima = totalTerima;
    }
}
