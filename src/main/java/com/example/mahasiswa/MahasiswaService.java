package com.example.mahasiswa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {
    private final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public List<Mahasiswa> getAllMahasiswa() {
        return daftarMahasiswa;
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa.add(mahasiswa);
    }

    public Mahasiswa getMahasiswaByNim(String nim) {
        Optional<Mahasiswa> result = daftarMahasiswa.stream()
            .filter(mahasiswa -> mahasiswa.getNim().equals(nim))
            .findFirst();

        return result.orElse(null);
    }

    public boolean updateMahasiswa(String nim, Mahasiswa updatedMahasiswa) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                daftarMahasiswa.set(i, updatedMahasiswa);
                return true;
            }
        }
        return false;
    }

    public boolean hapusMahasiswa(String nim) {
        return daftarMahasiswa.removeIf(mahasiswa -> mahasiswa.getNim().equals(nim));
    }
}
