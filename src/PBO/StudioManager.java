
public class StudioManager {
    private Proyek[] daftarProyek; // Array of object
    private int jumlahProyek;
    private static final int KAPASITAS_MAKSIMAL = 100;

    public StudioManager() {
        daftarProyek = new Proyek[KAPASITAS_MAKSIMAL];
        jumlahProyek = 0;
    }

    public boolean tambahProyek(Proyek proyek) {
        if (jumlahProyek >= KAPASITAS_MAKSIMAL) {
            return false;
        }
        daftarProyek[jumlahProyek] = proyek;
        jumlahProyek++;
        return true;
    }

    // Perulangan (for) untuk menampilkan semua data
    public void tampilkanSemuaProyek() {
        if (jumlahProyek == 0) {
            System.out.println("Belum ada proyek yang tercatat.");
            return;
        }
        for (int i = 0; i < jumlahProyek; i++) {
            daftarProyek[i].cetakDetail();
        }
    }

    public Proyek cariProyekByKode(String kode) {
        for (int i = 0; i < jumlahProyek; i++) {
            if (daftarProyek[i].getKodeProyek().equalsIgnoreCase(kode)) {
                return daftarProyek[i];
            }
        }
        return null; // tidak ditemukan
    }

    public double hitungTotalPendapatan() {
        double total = 0;
        for (int i = 0; i < jumlahProyek; i++) {
            if (daftarProyek[i].getStatusPengerjaan().equalsIgnoreCase("Selesai")) {
                total += daftarProyek[i].hitungBiaya();
            }
        }
        return total;
    }

    public int getJumlahProyek() {
        return jumlahProyek;
    }
}
