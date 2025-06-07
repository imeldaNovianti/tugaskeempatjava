package com.example.buku;

public class Buku {
    private String id;
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Constructor
    public Buku(String id, String judul, String penulis, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter untuk id
    public String getId() {
        return id;
    }

    // Setter untuk id (opsional tapi disarankan)
    public void setId(String id) {
        this.id = id;
    }

    // Getter dan Setter untuk atribut lain juga dibuat, contoh:
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }

    public int getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(int tahunTerbit) { this.tahunTerbit = tahunTerbit; }
}
