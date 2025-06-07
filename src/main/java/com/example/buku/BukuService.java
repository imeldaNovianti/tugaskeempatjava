package com.example.buku;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BukuService {
    private final List<Buku> daftarBuku = new ArrayList<>();

    public List<Buku> getAllBuku() {
        return daftarBuku;
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public Buku getBukuById(String id) {
        Optional<Buku> result = daftarBuku.stream()
            .filter(buku -> buku.getId().equals(id))
            .findFirst();

        return result.orElse(null);
    }
}
