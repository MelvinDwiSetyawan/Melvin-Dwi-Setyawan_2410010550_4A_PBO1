
public class ProyekPoster extends Proyek {
    private int jumlahDesain;
    private String tingkatKerumitan; // "Simpel", "Sedang", "Rumit"

    private static final double BIAYA_DASAR = 75000;
    private static final double BIAYA_PER_REVISI = 25000;

    public ProyekPoster(String kodeProyek, String namaProyek, String namaKlien, String deadline,
                         int jumlahDesain, String tingkatKerumitan) {
        super(kodeProyek, namaProyek, namaKlien, deadline);
        this.jumlahDesain = jumlahDesain;
        this.tingkatKerumitan = tingkatKerumitan;
    }

    @Override
    public double hitungBiaya() {
        double pengali;
        // Seleksi (switch-case)
        switch (tingkatKerumitan.toLowerCase()) {
            case "rumit":
                pengali = 2.0;
                break;
            case "sedang":
                pengali = 1.5;
                break;
            default:
                pengali = 1.0;
        }
        double biaya = jumlahDesain * BIAYA_DASAR * pengali;
        biaya += getJumlahRevisi() * BIAYA_PER_REVISI;
        return biaya;
    }

    @Override
    public String getJenisProyek() {
        return "Poster/Desain";
    }

    public int getJumlahDesain() { return jumlahDesain; }
    public String getTingkatKerumitan() { return tingkatKerumitan; }
}
