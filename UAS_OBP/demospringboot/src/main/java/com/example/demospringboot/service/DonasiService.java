package com.example.demospringboot.service;

import com.example.demospringboot.entity.Donasi;
import com.example.demospringboot.repository.DonasiRepository;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonasiService {

    @Autowired
    private DonasiRepository donasiRepository;

    @Autowired
    private EntityManager entityManager; 

    public Donasi saveDonasi(Donasi donasi) {
        return donasiRepository.save(donasi);
    }

    // Method utama yang dipanggil oleh controller
    public List<Donasi> getDonasi(String search) {
        if (search != null && !search.isEmpty()) {
            // Panggil method untuk mencari berdasarkan pencarian dan limit
            return findDonasiWithLimit(search);
        } else {
            // Jika tidak ada pencarian, panggil method untuk mendapatkan donasi terbatas
            return findTopDonasiWithLimit();
        }
    }
    

    // Query dengan pencarian dan limit
    private List<Donasi> findDonasiWithLimit(String search) {
        // Menambahkan % pada search sebelum digunakan dalam query
        String searchPattern = "%" + search + "%";
        
        String queryStr = "SELECT d FROM Donasi d WHERE d.nama LIKE :search OR d.status LIKE :search OR d.email LIKE :search OR d.telepon LIKE :search";
        TypedQuery<Donasi> query = entityManager.createQuery(queryStr, Donasi.class); 
        query.setParameter("search", searchPattern);  // Set parameter dengan searchPattern
        
        return query.getResultList();  
    }
    
    // Query untuk mendapatkan donasi terbatas tanpa pencarian
    private List<Donasi> findTopDonasiWithLimit() {
        String queryStr = "SELECT d FROM Donasi d";
        TypedQuery<Donasi> query = entityManager.createQuery(queryStr, Donasi.class);
        query.setMaxResults(3);  //Batas disetel maksimal 3, di atas itu, harus search by nama
        return query.getResultList();  
    }

        public BigDecimal getTotalNominalDonasiTerkonfirmasi() {
        String queryStr = "SELECT SUM(d.nominal) FROM Donasi d WHERE d.status = :status";
        TypedQuery<BigDecimal> query = entityManager.createQuery(queryStr, BigDecimal.class);
        query.setParameter("status", Donasi.Status.terkonfirmasi); // Status harus terkonfirmasi
        BigDecimal totalNominal = query.getSingleResult();
        return totalNominal != null ? totalNominal : BigDecimal.ZERO;
    }
    

    public Donasi getDonasiById(int id) {
        return donasiRepository.findById((int) id).orElse(null);
    }
    
    
    
}