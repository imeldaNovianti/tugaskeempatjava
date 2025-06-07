package com.example.buku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    // Tampilkan semua buku
    @GetMapping
    public List<Buku> tampilkanSemuaBuku() {
        return bukuService.getAllBuku();
    }

    // Tambah buku baru
    @PostMapping
    public ResponseEntity<String> tambahBuku(@RequestBody Buku buku) {
        bukuService.tambahBuku(buku);
        return ResponseEntity.status(HttpStatus.CREATED).body("Buku berhasil ditambahkan!");
    }

    // Ambil buku berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBukuById(@PathVariable String id) {
        Buku buku = bukuService.getBukuById(id);
        if (buku == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buku dengan ID " + id + " tidak ditemukan.");
        }
        return ResponseEntity.ok(buku);
    }

}
