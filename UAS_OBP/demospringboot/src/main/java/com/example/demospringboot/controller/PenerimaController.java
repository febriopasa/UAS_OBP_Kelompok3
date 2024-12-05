package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Donasi;
import com.example.demospringboot.entity.Penerima;
import com.example.demospringboot.service.DonasiService;
import com.example.demospringboot.service.PenerimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PenerimaController {

    @Autowired
    private PenerimaService penerimaService;

    @Autowired
    private DonasiService donasiService;

    @GetMapping("/penerima")
    public String getPenerimaList(Model model) {
        // Ambil daftar penerima
        List<Penerima> penerimaList = penerimaService.getAllPenerima();
        model.addAttribute("penerimaList", penerimaList);

        // Ambil daftar donasi dan total nominal donasi
        List<Donasi> donasiList = donasiService.getDonasi(null);
        BigDecimal totalNominal = donasiService.getTotalNominalDonasiTerkonfirmasi();
        model.addAttribute("donasiList", donasiList);
        model.addAttribute("totalNominal", totalNominal);

        return "penerima"; // Nama file HTML (Thymeleaf Template)
    }

    // Endpoint untuk menyalurkan donasi
    @PostMapping("/salurkan-donasi")
    public String salurkanDonasi(@RequestParam int idPenerima, @RequestParam double nominalDonasi, Model model) {
        try {
            // Panggil service untuk menyalurkan donasi
            penerimaService.salurkanDonasi(idPenerima, nominalDonasi);
            model.addAttribute("successMessage", "Donasi berhasil disalurkan!");
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        // Redirect kembali ke halaman penerima
        return "redirect:/penerima";
    }
}
