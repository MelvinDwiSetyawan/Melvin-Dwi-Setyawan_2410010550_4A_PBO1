import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudioManager manager = new StudioManager();
    private static int counterKode = 1;

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = bacaPilihanMenu();
            switch (pilihan) {
                case 1:
                    tambahProyekBaru();
                    break;
                case 2:
                    manager.tampilkanSemuaProyek();
                    break;
                case 3:
                    cariProyek();
                    break;
                case 4:
                    ubahStatusProyek();
                    break;
                case 5:
                    tambahRevisiProyek();
                    break;
                case 6:
                    cetakLaporan();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Studio Kreasi Digital!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia, silakan coba lagi.");
            }
            System.out.println();
        } while (pilihan != 0); // Perulangan do-while

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("========================================");
        System.out.println(" SISTEM MANAJEMEN STUDIO KREASI DIGITAL");
        System.out.println("========================================");
        System.out.println("1. Tambah Proyek Baru");
        System.out.println("2. Tampilkan Semua Proyek");
        System.out.println("3. Cari Proyek Berdasarkan Kode");
        System.out.println("4. Ubah Status Pengerjaan Proyek");
        System.out.println("5. Tambah Revisi Proyek");
        System.out.println("6. Cetak Laporan Pendapatan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static int bacaPilihanMenu() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1;
        }
    }

    private static void tambahProyekBaru() {
        System.out.println("\nPilih jenis proyek:");
        System.out.println("1. Website");
        System.out.println("2. Poster/Desain");
        System.out.println("3. Video");
        System.out.print("Jenis: ");

        try {
            int jenis = Integer.parseInt(scanner.nextLine());

            System.out.print("Nama Proyek   : ");
            String namaProyek = scanner.nextLine();
            System.out.print("Nama Klien    : ");
            String namaKlien = scanner.nextLine();
            System.out.print("Deadline (dd/mm/yyyy): ");
            String deadline = scanner.nextLine();

            String kodeProyek = "PRJ" + String.format("%03d", counterKode);
            Proyek proyekBaru = null;

            switch (jenis) {
                case 1:
                    System.out.print("Jumlah Halaman: ");
                    int jumlahHalaman = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ada Fitur Login? (y/n): ");
                    boolean adaLogin = scanner.nextLine().equalsIgnoreCase("y");
                    proyekBaru = new ProyekWeb(kodeProyek, namaProyek, namaKlien, deadline, jumlahHalaman, adaLogin);
                    break;
                case 2:
                    System.out.print("Jumlah Desain: ");
                    int jumlahDesain = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tingkat Kerumitan (Simpel/Sedang/Rumit): ");
                    String tingkat = scanner.nextLine();
                    proyekBaru = new ProyekPoster(kodeProyek, namaProyek, namaKlien, deadline, jumlahDesain, tingkat);
                    break;
                case 3:
                    System.out.print("Durasi (menit): ");
                    int durasi = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ada Animasi? (y/n): ");
                    boolean adaAnimasi = scanner.nextLine().equalsIgnoreCase("y");
                    proyekBaru = new ProyekVideo(kodeProyek, namaProyek, namaKlien, deadline, durasi, adaAnimasi);
                    break;
                default:
                    System.out.println("Jenis proyek tidak valid!");
                    return;
            }

            boolean berhasil = manager.tambahProyek(proyekBaru);
            if (berhasil) {
                counterKode++;
                System.out.println("Proyek berhasil ditambahkan dengan kode: " + kodeProyek);
            } else {
                System.out.println("Kapasitas penyimpanan proyek sudah penuh!");
            }

        } catch (NumberFormatException e) {
            // Error Handling
            System.out.println("Input angka tidak valid! Proyek gagal ditambahkan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void cariProyek() {
        System.out.print("Masukkan kode proyek: ");
        String kode = scanner.nextLine();
        Proyek hasil = manager.cariProyekByKode(kode);
        if (hasil != null) {
            hasil.cetakDetail();
        } else {
            System.out.println("Proyek dengan kode " + kode + " tidak ditemukan.");
        }
    }

    private static void ubahStatusProyek() {
        System.out.print("Masukkan kode proyek: ");
        String kode = scanner.nextLine();
        Proyek proyek = manager.cariProyekByKode(kode);
        if (proyek == null) {
            System.out.println("Proyek tidak ditemukan.");
            return;
        }
        System.out.println("Status saat ini: " + proyek.getStatusPengerjaan());
        System.out.print("Status baru (Belum Mulai/Proses/Selesai): ");
        String statusBaru = scanner.nextLine();
        proyek.setStatusPengerjaan(statusBaru);
        System.out.println("Status berhasil diubah.");
    }

    private static void tambahRevisiProyek() {
        System.out.print("Masukkan kode proyek: ");
        String kode = scanner.nextLine();
        Proyek proyek = manager.cariProyekByKode(kode);
        if (proyek == null) {
            System.out.println("Proyek tidak ditemukan.");
            return;
        }
        proyek.tambahRevisi();
        System.out.println("Revisi ditambahkan. Total revisi sekarang: " + proyek.getJumlahRevisi());
    }

    private static void cetakLaporan() {
        System.out.println("\n=========== LAPORAN STUDIO ===========");
        System.out.println("Total Proyek Tercatat              : " + manager.getJumlahProyek());
        System.out.printf("Total Pendapatan (Proyek Selesai)   : Rp%,.2f%n", manager.hitungTotalPendapatan());
        System.out.println("=======================================");
    }
}
