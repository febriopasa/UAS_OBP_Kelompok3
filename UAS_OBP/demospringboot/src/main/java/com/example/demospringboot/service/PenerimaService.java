package com.example.demospringboot.service;

import com.example.demospringboot.entity.Penerima;
import com.example.demospringboot.repository.PenerimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerimaService {

    @Autowired
    private PenerimaRepository penerimaRepository;

    public List<Penerima> getAllPenerima() {
        return penerimaRepository.findAll();
    }

    // Method untuk menyalurkan donasi ke penerima
    public void salurkanDonasi(int idPenerima, double nominalDonasi) {
        Penerima penerima = penerimaRepository.findById(idPenerima)
                .orElseThrow(() -> new RuntimeException("Penerima dengan ID " + idPenerima + " tidak ditemukan"));

        // Tambahkan nominal donasi ke total penerimaan
        penerima.setTotalTerima(penerima.getTotalTerima() + nominalDonasi);

        // Simpan perubahan ke database
        penerimaRepository.save(penerima);
    }
}