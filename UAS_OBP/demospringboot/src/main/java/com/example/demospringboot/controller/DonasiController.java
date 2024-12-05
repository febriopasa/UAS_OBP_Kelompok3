package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Donasi;
import com.example.demospringboot.entity.Donasi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demospringboot.service.DonasiService;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class DonasiController {

    @Autowired
    private DonasiService donasiService;

    @GetMapping("/buktidonasi")
    public String getDonasi(@RequestParam(required = false) String search, Model model) {
        List<Donasi> donasiList = donasiService.getDonasi(search);
        
        // Konversi LocalDateTime ke Date
        for (Donasi donasi : donasiList) {
            if (donasi.getCreatedAt() != null) {
                donasi.setCreatedAtAsDate(Date.from(donasi.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant()));
            }
        }
        
        model.addAttribute("donasiList", donasiList);
        return "buktidonasi"; // Nama template Thymeleaf (HTML)
    }

    @GetMapping("/laporan")
    public String getLaporan(@RequestParam(required = false) String search, Model model) {
        List<Donasi> donasiList = donasiService.getDonasi(search);
        
        // Konversi LocalDateTime ke Date
        for (Donasi donasi : donasiList) {
            if (donasi.getCreatedAt() != null) {
                donasi.setCreatedAtAsDate(Date.from(donasi.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant()));
            }
        }

        // Hitung total nominal hanya dari donasi terkonfirmasi
        BigDecimal totalNominal = donasiService.getTotalNominalDonasiTerkonfirmasi();
        
        model.addAttribute("donasiList", donasiList);
        model.addAttribute("totalNominal", totalNominal);
        return "laporan"; // Nama template Thymeleaf (HTML)
    }

    @PostMapping("/lakukandonasi/new")
    @ResponseBody
    public Donasi createDonasi(@RequestBody Donasi donasi) {
        // Tetapkan nilai default untuk status (BELUM_KONFIRMASI)
        if (donasi.getStatus() == null) {
            donasi.setStatus(Status.belum_konfirmasi);
        }
    
        // Simpan data donasi
        return donasiService.saveDonasi(donasi);
    }

    @PostMapping("/konfirmasiDonasi")
    public String konfirmasiDonasi(@RequestParam int id, Model model) {
        // Cari donasi berdasarkan ID
        Donasi donasi = donasiService.getDonasiById(id);
        
        if (donasi != null) {
            // Ubah status menjadi "terkonfirmasi"
            donasi.setStatus(Donasi.Status.terkonfirmasi);
            donasiService.saveDonasi(donasi);
        }
    
        // Ambil daftar donasi terkini dan tampilkan kembali halaman konfirmasi
        List<Donasi> donasiList = donasiService.getDonasi(null);
        model.addAttribute("donasiList", donasiList);
        return "konfirmasi";
    }

    @GetMapping("/konfirmasi")
    public String getKonfirmasi(@RequestParam(required = false) Integer search, Model model) {
        List<Donasi> donasiList;
    
        if (search != null) {
            // Cari donasi berdasarkan ID
            Donasi donasi = donasiService.getDonasiById(search);
            donasiList = (donasi != null) ? List.of(donasi) : List.of();
        } else {
            // Jika tidak ada pencarian, ambil semua donasi
            donasiList = donasiService.getDonasi(null);
        }
    
        model.addAttribute("donasiList", donasiList);
        return "konfirmasi"; // Nama template Thymeleaf (HTML)
    }

    
}