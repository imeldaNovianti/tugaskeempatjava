package com.example.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    // CREATE
    @PostMapping
    public ResponseEntity<Map<String, Object>> tambahMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.tambahMahasiswa(mahasiswa);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Mahasiswa berhasil ditambahkan.");
        response.put("data", mahasiswa);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ semua
    @GetMapping
    public List<Mahasiswa> tampilkanSemuaMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }

    // READ by NIM
    @GetMapping("/{nim}")
    public ResponseEntity<?> getMahasiswaByNim(@PathVariable String nim) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNim(nim);
        if (mahasiswa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Mahasiswa dengan NIM " + nim + " tidak ditemukan."));
        }
        return ResponseEntity.ok(mahasiswa);
    }

    // UPDATE
    @PutMapping("/{nim}")
    public ResponseEntity<?> updateMahasiswa(@PathVariable String nim, @RequestBody Mahasiswa updatedMahasiswa) {
        boolean updated = mahasiswaService.updateMahasiswa(nim, updatedMahasiswa);
        if (updated) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Mahasiswa berhasil diperbarui.");
            response.put("data", updatedMahasiswa);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Mahasiswa dengan NIM " + nim + " tidak ditemukan."));
        }
    }

    // DELETE
    @DeleteMapping("/{nim}")
    public ResponseEntity<?> hapusMahasiswa(@PathVariable String nim) {
        boolean deleted = mahasiswaService.hapusMahasiswa(nim);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Mahasiswa berhasil dihapus."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Mahasiswa dengan NIM " + nim + " tidak ditemukan."));
        }
    }
}
