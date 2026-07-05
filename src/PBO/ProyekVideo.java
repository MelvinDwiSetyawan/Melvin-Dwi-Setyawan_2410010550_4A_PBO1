
public class ProyekVideo extends Proyek {
    private int durasiMenit;
    private boolean adaAnimasi;

    private static final double BIAYA_PER_MENIT = 100000;
    private static final double BIAYA_ANIMASI = 300000;
    private static final double BIAYA_PER_REVISI = 75000;

    public ProyekVideo(String kodeProyek, String namaProyek, String namaKlien, String deadline,
                        int durasiMenit, boolean adaAnimasi) {
        super(kodeProyek, namaProyek, namaKlien, deadline);
        this.durasiMenit = durasiMenit;
        this.adaAnimasi = adaAnimasi;
    }

    @Override
    public double hitungBiaya() {
        double biaya = durasiMenit * BIAYA_PER_MENIT;
        if (adaAnimasi) {
            biaya += BIAYA_ANIMASI;
        }
        biaya += getJumlahRevisi() * BIAYA_PER_REVISI;
        return biaya;
    }

    @Override
    public String getJenisProyek() {
        return "Video";
    }

    public int getDurasiMenit() { return durasiMenit; }
    public boolean isAdaAnimasi() { return adaAnimasi; }
}
