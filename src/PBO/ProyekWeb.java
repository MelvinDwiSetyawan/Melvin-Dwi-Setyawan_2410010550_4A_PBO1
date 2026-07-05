
public class ProyekWeb extends Proyek {
    private int jumlahHalaman;
    private boolean adaFiturLogin;

    private static final double BIAYA_PER_HALAMAN = 150000;
    private static final double BIAYA_FITUR_LOGIN = 200000;
    private static final double BIAYA_PER_REVISI = 50000;

    public ProyekWeb(String kodeProyek, String namaProyek, String namaKlien, String deadline,
                      int jumlahHalaman, boolean adaFiturLogin) {
        super(kodeProyek, namaProyek, namaKlien, deadline); // panggil constructor parent
        this.jumlahHalaman = jumlahHalaman;
        this.adaFiturLogin = adaFiturLogin;
    }

    // Override method abstract -> Polymorphism
    @Override
    public double hitungBiaya() {
        double biaya = jumlahHalaman * BIAYA_PER_HALAMAN;
        if (adaFiturLogin) {
            biaya += BIAYA_FITUR_LOGIN;
        }
        biaya += getJumlahRevisi() * BIAYA_PER_REVISI;
        return biaya;
    }

    @Override
    public String getJenisProyek() {
        return "Website";
    }

    public int getJumlahHalaman() { return jumlahHalaman; }
    public boolean isAdaFiturLogin() { return adaFiturLogin; }
}
