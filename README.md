# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah aplikasi Sistem Manajemen Studio Kreasi Digital menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini mensimulasikan pengelolaan proyek di sebuah studio kreasi digital kecil (freelance) yang menangani tiga jenis proyek: Website, Poster/Desain, dan Video. Pengguna dapat mendaftarkan proyek baru beserta data klien, menghitung biaya secara otomatis (berbeda-beda tergantung jenis proyek), mengubah status pengerjaan, menambah jumlah revisi, mencari proyek berdasarkan kode, hingga mencetak laporan total pendapatan dari proyek yang sudah selesai.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Proyek`, `ProyekWeb`, `ProyekPoster`, `ProyekVideo`, dan `StudioManager` adalah contoh dari class.

```java
public abstract class Proyek {
    ...
}

public class ProyekWeb extends Proyek {
    ...
}

public class StudioManager {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `proyekBaru = new ProyekWeb(kodeProyek, namaProyek, namaKlien, deadline, jumlahHalaman, adaLogin);` adalah contoh pembuatan object.

```java
proyekBaru = new ProyekWeb(kodeProyek, namaProyek, namaKlien, deadline, jumlahHalaman, adaLogin);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `namaProyek` dan `namaKlien` adalah contoh atribut.

```java
private String namaProyek;
private String namaKlien;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Proyek` dan `ProyekWeb`.

```java
public Proyek(String kodeProyek, String namaProyek, String namaKlien, String deadline) {
    this.kodeProyek = kodeProyek;
    this.namaProyek = namaProyek;
    this.namaKlien = namaKlien;
    this.deadline = deadline;
    this.statusPengerjaan = "Belum Mulai";
    this.jumlahRevisi = 0;
}

public ProyekWeb(String kodeProyek, String namaProyek, String namaKlien, String deadline,
                  int jumlahHalaman, boolean adaFiturLogin) {
    super(kodeProyek, namaProyek, namaKlien, deadline);
    this.jumlahHalaman = jumlahHalaman;
    this.adaFiturLogin = adaFiturLogin;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setStatusPengerjaan` dan `tambahRevisi` adalah contoh method mutator.

```java
public void setStatusPengerjaan(String statusPengerjaan) {
    this.statusPengerjaan = statusPengerjaan;
}

public void tambahRevisi() {
    this.jumlahRevisi++;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNamaProyek`, `getNamaKlien`, `getStatusPengerjaan`, dan `getJumlahRevisi` adalah contoh method accessor.

```java
public String getNamaProyek() {
    return namaProyek;
}

public String getStatusPengerjaan() {
    return statusPengerjaan;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di class `Proyek` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```java
private String kodeProyek;
private String namaProyek;
private String namaKlien;
private String statusPengerjaan;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `ProyekWeb`, `ProyekPoster`, dan `ProyekVideo` mewarisi `Proyek` dengan sintaks `extends`.

```java
public class ProyekWeb extends Proyek {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `cetakDetail(String)` di `Proyek` merupakan overloading dari method `cetakDetail()`, dan method `hitungBiaya()` beserta `getJenisProyek()` di `ProyekWeb`, `ProyekPoster`, dan `ProyekVideo` merupakan override dari method abstract yang ada di `Proyek`.

```java
public void cetakDetail(String catatanTambahan) {
    cetakDetail();
    System.out.println("Catatan Tambahan: " + catatanTambahan);
    System.out.println("========================================");
}

// Override di ProyekWeb
@Override
public double hitungBiaya() {
    double biaya = jumlahHalaman * BIAYA_PER_HALAMAN;
    if (adaFiturLogin) {
        biaya += BIAYA_FITUR_LOGIN;
    }
    biaya += getJumlahRevisi() * BIAYA_PER_REVISI;
    return biaya;
}

// Override di ProyekPoster (isi/perhitungan berbeda)
@Override
public double hitungBiaya() {
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `switch` dalam method `hitungBiaya()` di `ProyekPoster` dan seleksi `switch` pada menu utama di `Main`.

```java
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
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `do-while` untuk menampilkan menu berulang, dan loop `for` untuk menampilkan seluruh data proyek.

```java
do {
    tampilkanMenu();
    pilihan = bacaPilihanMenu();
    ...
} while (pilihan != 0);

for (int i = 0; i < jumlahProyek; i++) {
    daftarProyek[i].cetakDetail();
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Nama Proyek   : ");
String namaProyek = scanner.nextLine();

System.out.println("Proyek berhasil ditambahkan dengan kode: " + kodeProyek);
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `Proyek[] daftarProyek = new Proyek[KAPASITAS_MAKSIMAL];` adalah contoh penggunaan array.

```java
private Proyek[] daftarProyek;
...
daftarProyek = new Proyek[KAPASITAS_MAKSIMAL];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani kesalahan input pada method `tambahProyekBaru()` dan `bacaPilihanMenu()`.

```java
try {
    int jenis = Integer.parseInt(scanner.nextLine());
    ...
} catch (NumberFormatException e) {
    System.out.println("Input angka tidak valid! Proyek gagal ditambahkan.");
} catch (Exception e) {
    System.out.println("Terjadi kesalahan: " + e.getMessage());
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Melvin Dwi Setyawan
NPM: 2410010550