/**
 * Class abstract Proyek - parent class untuk semua jenis proyek digital.
 * Mendemonstrasikan: Class, Atribut, Constructor, Accessor, Mutator, Encapsulation
 */
public abstract class Proyek {
    // Atribut (private -> Encapsulation)
    private String kodeProyek;
    private String namaProyek;
    private String namaKlien;
    private String deadline;
    private String statusPengerjaan; // "Belum Mulai", "Proses", "Selesai"
    private int jumlahRevisi;

    // Constructor
    public Proyek(String kodeProyek, String namaProyek, String namaKlien, String deadline) {
        this.kodeProyek = kodeProyek;
        this.namaProyek = namaProyek;
        this.namaKlien = namaKlien;
        this.deadline = deadline;
        this.statusPengerjaan = "Belum Mulai";
        this.jumlahRevisi = 0;
    }

    // Accessor (getter)
    public String getKodeProyek() { return kodeProyek; }
    public String getNamaProyek() { return namaProyek; }
    public String getNamaKlien() { return namaKlien; }
    public String getDeadline() { return deadline; }
    public String getStatusPengerjaan() { return statusPengerjaan; }
    public int getJumlahRevisi() { return jumlahRevisi; }

    // Mutator (setter)
    public void setStatusPengerjaan(String statusPengerjaan) {
        this.statusPengerjaan = statusPengerjaan;
    }

    public void tambahRevisi() {
        this.jumlahRevisi++;
    }

    // Method abstract -> wajib di-override tiap subclass -> dasar Polymorphism
    public abstract double hitungBiaya();
    public abstract String getJenisProyek();

    // Method biasa yang dipakai bersama (memanggil method abstract -> hasil beda tiap subclass)
    public void cetakDetail() {
        System.out.println("========================================");
        System.out.println("Kode Proyek     : " + kodeProyek);
        System.out.println("Nama Proyek     : " + namaProyek);
        System.out.println("Klien           : " + namaKlien);
        System.out.println("Jenis Proyek    : " + getJenisProyek());
        System.out.println("Deadline        : " + deadline);
        System.out.println("Status          : " + statusPengerjaan);
        System.out.println("Jumlah Revisi   : " + jumlahRevisi);
        System.out.printf("Total Biaya     : Rp%,.2f%n", hitungBiaya());
        System.out.println("========================================");
    }

    // Overloading -> method dengan nama sama (cetakDetail) tapi parameter berbeda
    public void cetakDetail(String catatanTambahan) {
        cetakDetail();
        System.out.println("Catatan Tambahan: " + catatanTambahan);
        System.out.println("========================================");
    }
}