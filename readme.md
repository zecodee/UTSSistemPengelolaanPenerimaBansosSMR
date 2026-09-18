# Sistem Pengelolaan Bantuan Sosial Daerah Samarinda

## Mini Project Pemrograman Berorientasi Objek

**Nama:** Nama Mahasiswa  
**NIM:** 0000000000  
**Program Studi:** Informatika  

---

## 1. Deskripsi Studi Kasus

**Sistem Pengelolaan Bantuan Sosial Daerah Samarinda** merupakan program berbasis Java yang digunakan untuk membantu proses pengelolaan data penerima bantuan sosial, data bantuan, serta pengajuan bantuan.

Program dibuat dalam bentuk aplikasi berbasis **Command Line Interface (CLI)** dan dijalankan menggunakan NetBeans.

Dalam program terdapat dua jenis penerima bantuan, yaitu:

1. **Penerima Individu**
2. **Penerima Keluarga**

Kedua jenis penerima memiliki data umum yang sama seperti ID penerima, NIK, nama, alamat, dan penghasilan. Namun, masing-masing jenis penerima juga memiliki data khusus.

**Penerima Individu** memiliki data tambahan berupa:

- Pekerjaan
- Status rumah

Sedangkan **Penerima Keluarga** memiliki data tambahan berupa:

- Jumlah anggota keluarga
- Jumlah tanggungan

Selain mengelola penerima, program juga dapat mengelola data bantuan dan pengajuan bantuan. Setiap pengajuan akan melalui proses pemeriksaan untuk menentukan apakah pengajuan **diterima** atau **ditolak** berdasarkan kriteria yang telah ditentukan.

---

## 2. Tujuan Program

Program ini dibuat untuk menerapkan konsep dasar **Pemrograman Berorientasi Objek (PBO)** melalui sebuah studi kasus pengelolaan bantuan sosial.

Konsep yang diterapkan dalam program antara lain:

- Class dan Object
- Constructor
- Inheritance
- Encapsulation
- ArrayList
- Percabangan
- Perulangan
- CRUD
- Validasi input
- Relasi antar object

---

## 3. Struktur Project

Project dibagi menjadi dua package utama, yaitu `app` dan `model`.

```text
SistemBantuanSosial
│
└── Source Packages
    │
    ├── app
    │   └── Main.java
    │
    └── model
        ├── Bantuan.java
        ├── Penerima.java
        ├── PenerimaIndividu.java
        ├── PenerimaKeluarga.java
        └── Pengajuan.java
```

Package `app` berisi `Main.java` yang digunakan untuk menjalankan program dan mengatur seluruh menu.

Package `model` berisi class yang digunakan untuk membentuk object dan menyimpan data pada sistem.

### Dokumentasi Struktur Project

> **Gambar 1. Struktur Project**
>
> Ambil screenshot tampilan **Projects pada NetBeans** yang memperlihatkan:
>
> - Project `SistemBantuanSosial`
> - Package `app`
> - `Main.java`
> - Package `model`
> - `Bantuan.java`
> - `Penerima.java`
> - `PenerimaIndividu.java`
> - `PenerimaKeluarga.java`
> - `Pengajuan.java`
>
> Screenshot NetBeans yang sudah dibuat sebelumnya dapat digunakan untuk bagian ini.

![Gambar 1 - Struktur Project](images/gambar-01-struktur-project.png)

---

## 4. Hierarki Class

Class utama yang menjadi dasar penerapan inheritance adalah class `Penerima`.

Hierarki class dapat digambarkan secara sederhana sebagai berikut:

```text
                         Penerima
                            │
                ┌───────────┴───────────┐
                │                       │
                ▼                       ▼
       PenerimaIndividu         PenerimaKeluarga


        Bantuan                 Pengajuan
                                   │
                          ┌────────┴────────┐
                          │                 │
                          ▼                 ▼
                      Penerima          Bantuan
```

Penjelasan masing-masing class:

| Class | Fungsi |
|---|---|
| `Main` | Menjalankan program, menu, CRUD, dan proses pengajuan |
| `Penerima` | Menyimpan data umum penerima dan menjadi superclass |
| `PenerimaIndividu` | Menyimpan data khusus penerima individu |
| `PenerimaKeluarga` | Menyimpan data khusus penerima keluarga |
| `Bantuan` | Menyimpan informasi bantuan sosial |
| `Pengajuan` | Menghubungkan penerima dengan bantuan yang diajukan |

---

## 5. Penjelasan Class

### 5.1 Class Penerima

`Penerima` merupakan superclass atau class induk yang menyimpan data umum penerima bantuan.

Atribut yang dimiliki yaitu:

```java
private String idPenerima;
private String nik;
private String nama;
private String alamat;
private double penghasilan;
```

ID penerima dibuat secara otomatis menggunakan:

```java
this.idPenerima = String.format("P%03d", i);
i++;
```

Sehingga ID yang dihasilkan berbentuk:

```text
P001
P002
P003
...
```

---

### 5.2 Class PenerimaIndividu

`PenerimaIndividu` merupakan subclass dari `Penerima`.

```java
public class PenerimaIndividu extends Penerima
```

Class ini memiliki atribut tambahan:

```java
private String pekerjaan;
private String statusRumah;
```

Dengan demikian, Penerima Individu tetap memiliki NIK, nama, alamat, dan penghasilan dari class `Penerima`, tetapi memiliki informasi tambahan berupa pekerjaan dan status rumah.

---

### 5.3 Class PenerimaKeluarga

`PenerimaKeluarga` juga merupakan subclass dari `Penerima`.

```java
public class PenerimaKeluarga extends Penerima
```

Class ini memiliki atribut tambahan:

```java
private int anggotaKeluarga;
private int jumlahTanggungan;
```

Data tersebut digunakan untuk menyimpan jumlah anggota keluarga dan jumlah tanggungan dari penerima.

---

### 5.4 Class Bantuan

Class `Bantuan` digunakan untuk menyimpan informasi bantuan sosial.

Atributnya terdiri dari:

```java
private String idBantuan;
private String namaBantuan;
private double nominal;
private int kuota;
```

ID bantuan dibuat secara otomatis dengan format:

```text
B001
B002
B003
...
```

Class ini juga memiliki method:

```java
public void kurangiKuota() {
    if (kuota > 0) {
        kuota--;
    }
}
```

Method tersebut digunakan untuk mengurangi kuota sebanyak satu ketika suatu pengajuan bantuan diterima.

---

### 5.5 Class Pengajuan

Class `Pengajuan` digunakan untuk menghubungkan object `Penerima` dengan object `Bantuan`.

Atribut utamanya yaitu:

```java
private String idPengajuan;
private String statusPengajuan;
private Bantuan bantuan;
private Penerima penerima;
```

Ketika pengajuan dibuat, ID dibuat otomatis dengan format:

```text
PG001
PG002
PG003
...
```

Sedangkan status awal pengajuan adalah:

```text
Menunggu
```

Setelah diproses, status dapat berubah menjadi:

```text
Diterima
```

atau:

```text
Ditolak
```

---

# 6. Penerapan Konsep PBO

## 6.1 Inheritance

Inheritance diterapkan pada hubungan antara `Penerima`, `PenerimaIndividu`, dan `PenerimaKeluarga`.

```text
Penerima
   │
   ├── PenerimaIndividu
   │
   └── PenerimaKeluarga
```

Pada class `PenerimaIndividu` terdapat:

```java
public class PenerimaIndividu extends Penerima {
```

Sedangkan pada `PenerimaKeluarga`:

```java
public class PenerimaKeluarga extends Penerima {
```

Keyword `extends` menunjukkan bahwa kedua class tersebut merupakan turunan dari `Penerima`.

Constructor subclass juga menggunakan:

```java
super(nik, nama, alamat, penghasilan);
```

`super()` digunakan untuk memanggil constructor milik superclass `Penerima`.

Dengan inheritance, atribut umum seperti NIK, nama, alamat, dan penghasilan tidak perlu ditulis ulang pada masing-masing subclass.

---

## 6.2 Encapsulation

Encapsulation diterapkan dengan memberikan access modifier `private` pada atribut.

Contoh:

```java
private String nik;
private String nama;
private String alamat;
private double penghasilan;
```

Atribut tersebut kemudian diakses menggunakan getter dan setter.

Contoh getter:

```java
public String getNama() {
    return nama;
}
```

Contoh setter:

```java
public void setNama(String nama) {
    this.nama = nama;
}
```

Dengan cara tersebut, data pada object tidak diakses secara langsung dari luar class.

---

## 6.3 Constructor

Constructor digunakan untuk memberikan nilai awal ketika sebuah object dibuat.

Contoh constructor `Penerima`:

```java
public Penerima(String nik, String nama, String alamat, double penghasilan) {
    this.idPenerima = String.format("P%03d", i);
    i++;
    this.nik = nik;
    this.nama = nama;
    this.alamat = alamat;
    this.penghasilan = penghasilan;
}
```

Ketika object penerima dibuat, data langsung dimasukkan melalui constructor dan ID penerima dibuat secara otomatis.

---

## 6.4 ArrayList

Program menggunakan `ArrayList` untuk menyimpan data sementara selama program berjalan.

```java
ArrayList<Penerima> daftarPenerima = new ArrayList<>();
ArrayList<Bantuan> daftarBantuan = new ArrayList<>();
ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();
```

Fungsinya adalah:

- `daftarPenerima` menyimpan object Penerima.
- `daftarBantuan` menyimpan object Bantuan.
- `daftarPengajuan` menyimpan object Pengajuan.

Karena program belum menggunakan database atau file, seluruh data akan kembali kosong ketika program dihentikan dan dijalankan ulang.

---

# 7. Alur Program

## 7.1 Menjalankan Program

Program dimulai melalui method:

```java
public static void main(String[] args) {
    Main program = new Main();
    program.menuUtama();
}
```

Program membuat object `Main`, kemudian menjalankan method `menuUtama()`.

Menu utama menampilkan:

```text
===========================================
 SISTEM PENGELOLAAN BANSOS DAERAH SAMARINDA
===========================================
1. Kelola Data Penerima
2. Kelola Data Bantuan
3. Kelola Data Pengajuan
4. Proses Pengajuan
0. Keluar
```

Menu menggunakan perulangan `do-while`, sehingga program akan terus berjalan sampai pengguna memilih `0`.

### Dokumentasi Running Program

> **Gambar 2. Menu Utama Program**
>
> Jalankan program melalui NetBeans.
>
> Ambil screenshot pada bagian **Output** ketika menu utama pertama kali muncul.
>
> Pastikan screenshot memperlihatkan judul program dan pilihan menu `1` sampai `0`.

![Gambar 2 - Menu Utama](images/gambar-02-menu-utama.png)

---

# 8. Alur Pengelolaan Data Penerima

## 8.1 Create - Menambahkan Penerima Individu

Pengguna memilih:

```text
Menu Utama
→ 1. Kelola Data Penerima
→ 1. Tambah Penerima
→ 1. Penerima Individu
```

Program kemudian meminta:

```text
NIK
Nama
Alamat
Penghasilan
Pekerjaan
Status Rumah
```

Sebelum data disimpan, program melakukan beberapa validasi.

NIK harus memiliki panjang 16 karakter:

```java
if (nik.length() != 16) {
    System.out.println("NIK harus 16 digit.");
}
```

Program juga memeriksa apakah NIK sudah terdaftar:

```java
for (Penerima p : daftarPenerima) {
    if (p.getNik().equals(nik)) {
        System.out.println("NIK sudah terdaftar.");
        return;
    }
}
```

Jika seluruh data valid, object dibuat:

```java
PenerimaIndividu individu =
        new PenerimaIndividu(
                nik,
                nama,
                alamat,
                penghasilan,
                pekerjaan,
                statusRumah
        );
```

Kemudian dimasukkan ke ArrayList:

```java
daftarPenerima.add(individu);
```

ID dibuat otomatis, misalnya:

```text
P001
```

### Dokumentasi Create Penerima Individu

> **Gambar 3. Create Penerima Individu**
>
> Tambahkan satu penerima individu.
>
> Contoh data yang dapat digunakan:
>
> ```text
> NIK         : 6472012345678901
> Nama        : Budi Santoso
> Alamat      : Samarinda
> Penghasilan : 2000000
> Pekerjaan   : Pedagang
> Status Rumah: Kontrak
> ```
>
> Ambil screenshot mulai dari input data sampai muncul:
>
> ```text
> Data penerima individu berhasil ditambahkan.
> ID Penerima : P001
> ```

![Gambar 3 - Create Penerima Individu](images/gambar-03-create-individu.png)

---

## 8.2 Create - Menambahkan Penerima Keluarga

Untuk penerima keluarga, pengguna memilih:

```text
Menu Utama
→ Kelola Data Penerima
→ Tambah Penerima
→ Penerima Keluarga
```

Data umum yang dimasukkan tetap berupa NIK, nama, alamat, dan penghasilan.

Setelah itu program meminta:

```text
Jumlah Anggota Keluarga
Jumlah Tanggungan
```

Program memastikan jumlah anggota keluarga lebih dari 0.

Program juga memastikan jumlah tanggungan tidak negatif dan tidak melebihi jumlah anggota keluarga.

Jika data valid, object:

```java
PenerimaKeluarga keluarga = new PenerimaKeluarga(
        nik,
        nama,
        alamat,
        penghasilan,
        jumlahAnggota,
        jumlahTanggungan
);
```

akan dibuat dan disimpan ke `daftarPenerima`.

### Dokumentasi Create Penerima Keluarga

> **Gambar 4. Create Penerima Keluarga**
>
> Tambahkan satu penerima keluarga.
>
> Contoh:
>
> ```text
> NIK                     : 6472012345678902
> Nama                    : Andi Saputra
> Alamat                  : Samarinda
> Penghasilan             : 3000000
> Jumlah Anggota Keluarga : 4
> Jumlah Tanggungan       : 2
> ```
>
> Screenshot harus memperlihatkan proses input sampai muncul:
>
> ```text
> Data penerima keluarga berhasil ditambahkan.
> ID Penerima : P002
> ```

![Gambar 4 - Create Penerima Keluarga](images/gambar-04-create-keluarga.png)

---

## 8.3 Read - Menampilkan Data Penerima

Menu `Tampilkan Penerima` digunakan untuk membaca seluruh data penerima yang telah tersimpan.

Program melakukan perulangan:

```java
for (Penerima p : daftarPenerima)
```

Kemudian `instanceof` digunakan untuk mengetahui jenis object.

```java
if (p instanceof PenerimaIndividu)
```

dan:

```java
else if (p instanceof PenerimaKeluarga)
```

Jika object merupakan Penerima Individu, program menampilkan data individu.

Jika object merupakan Penerima Keluarga, program menampilkan data keluarga.

### Dokumentasi Read Penerima

> **Gambar 5. Menampilkan Data Penerima**
>
> Pilih:
>
> ```text
> Kelola Data Penerima
> → Tampilkan Penerima
> ```
>
> Ambil screenshot yang memperlihatkan **P001 sebagai Individu dan P002 sebagai Keluarga dalam satu output**.
>
> Screenshot ini penting karena sekaligus menunjukkan bahwa inheritance berhasil digunakan untuk menangani dua jenis penerima.

![Gambar 5 - Read Penerima](images/gambar-05-read-penerima.png)

---

## 8.4 Update - Mengubah Data Penerima

Untuk mengubah penerima, pengguna memilih menu `Ubah Penerima`.

Program menampilkan seluruh penerima kemudian meminta:

```text
Masukkan ID Penerima
```

Program mencari ID tersebut menggunakan perulangan.

Jika ditemukan, data penerima dapat diperbarui melalui setter:

```java
penerimaDipilih.setNik(nik);
penerimaDipilih.setNama(nama);
penerimaDipilih.setAlamat(alamat);
penerimaDipilih.setPenghasilan(penghasilan);
```

Data khusus juga diperbarui sesuai jenis penerima.

Contoh Penerima Individu:

```java
individu.setPekerjaan(pekerjaan);
individu.setStatusRumah(statusRumah);
```

ID penerima tidak berubah karena ID merupakan identitas yang dibuat otomatis oleh sistem.

### Dokumentasi Update Penerima

> **Gambar 6. Update Data Penerima**
>
> Pilih P001 kemudian ubah salah satu atau beberapa datanya.
>
> Contoh:
>
> ```text
> Nama Lama      : Budi Santoso
> Nama Baru      : Budi Setiawan
> Pekerjaan Baru : Wiraswasta
> ```
>
> Ambil screenshot sampai muncul:
>
> ```text
> Data penerima berhasil diubah.
> ```
>
> Jika memungkinkan, setelah update buka kembali `Tampilkan Penerima` agar perubahan datanya terlihat.

![Gambar 6 - Update Penerima](images/gambar-06-update-penerima.png)

---

## 8.5 Delete - Menghapus Data Penerima

Program menyediakan menu `Hapus Penerima`.

Sebelum penerima dihapus, program memeriksa apakah penerima sudah digunakan dalam pengajuan.

```java
for (Pengajuan pg : daftarPengajuan) {
    if (pg.getPenerima().getIdPenerima().equalsIgnoreCase(id)) {
        System.out.println("Penerima tidak dapat dihapus.");
        System.out.println("Penerima sudah memiliki data pengajuan.");
        return;
    }
}
```

Jika belum memiliki pengajuan:

```java
daftarPenerima.remove(penerimaDipilih);
```

akan dijalankan.

### Dokumentasi Delete Penerima

> **Gambar 7. Delete Data Penerima**
>
> Untuk screenshot ini, sebaiknya buat satu penerima tambahan, misalnya P003, yang belum mempunyai pengajuan.
>
> Kemudian hapus P003.
>
> Screenshot harus memperlihatkan:
>
> ```text
> Masukkan ID Penerima : P003
> Data penerima berhasil dihapus.
> ```

![Gambar 7 - Delete Penerima](images/gambar-07-delete-penerima.png)

---

# 9. Alur Pengelolaan Data Bantuan

## 9.1 Create - Menambahkan Bantuan

Pengguna memilih:

```text
Menu Utama
→ Kelola Data Bantuan
→ Tambah Bantuan
```

Program meminta:

```text
Nama Bantuan
Nominal Bantuan
Kuota
```

Nominal harus lebih dari 0 dan kuota juga harus lebih dari 0.

Jika valid:

```java
Bantuan bantuan = new Bantuan(nama, nominal, kuota);
daftarBantuan.add(bantuan);
```

ID bantuan dibuat otomatis:

```text
B001
B002
B003
...
```

### Dokumentasi Create Bantuan

> **Gambar 8. Create Data Bantuan**
>
> Buat bantuan dengan kuota kecil agar perubahan kuota nantinya mudah terlihat.
>
> Contoh:
>
> ```text
> Nama Bantuan    : Bantuan Sembako
> Nominal Bantuan : 500000
> Kuota           : 2
> ```
>
> Ambil screenshot sampai muncul:
>
> ```text
> Data bantuan berhasil ditambahkan.
> ID Bantuan : B001
> ```

![Gambar 8 - Create Bantuan](images/gambar-08-create-bantuan.png)

---

## 9.2 Read - Menampilkan Data Bantuan

Menu `Tampilkan Bantuan` akan melakukan perulangan terhadap seluruh object `Bantuan`.

```java
for (Bantuan b : daftarBantuan) {
    b.tampilData();
}
```

Informasi yang ditampilkan berupa:

```text
ID Bantuan
Nama Bantuan
Nominal
Kuota
```

### Dokumentasi Read Bantuan

> **Gambar 9. Menampilkan Data Bantuan**
>
> Buka:
>
> ```text
> Kelola Data Bantuan
> → Tampilkan Bantuan
> ```
>
> Pastikan B001 terlihat dengan kuota awal `2`.
>
> Screenshot ini nantinya dapat dibandingkan dengan kuota setelah pengajuan diterima.

![Gambar 9 - Read Bantuan](images/gambar-09-read-bantuan.png)

---

## 9.3 Delete - Menghapus Bantuan

Bantuan dapat dihapus apabila belum digunakan dalam pengajuan.

Jika bantuan sudah digunakan, program menampilkan:

```text
Bantuan tidak dapat dihapus.
Bantuan sudah digunakan dalam pengajuan.
```

Validasi tersebut menjaga agar data pengajuan tidak kehilangan data bantuan yang digunakan.

### Dokumentasi Delete Bantuan

> **Gambar 10. Validasi Delete Bantuan**
>
> Screenshot ini sebaiknya diambil **setelah B001 digunakan untuk membuat pengajuan**.
>
> Coba hapus B001.
>
> Ambil screenshot ketika muncul:
>
> ```text
> Bantuan tidak dapat dihapus.
> Bantuan sudah digunakan dalam pengajuan.
> ```
>
> Screenshot ini menunjukkan bahwa program memiliki validasi ketika melakukan Delete.

![Gambar 10 - Validasi Delete Bantuan](images/gambar-10-delete-bantuan.png)

---

# 10. Alur Pengajuan Bantuan

## 10.1 Create - Membuat Pengajuan

Sebelum membuat pengajuan, program memeriksa apakah data penerima dan bantuan tersedia.

Pengguna kemudian memilih ID penerima.

```text
Masukkan ID Penerima : P001
```

Program mencari object penerima berdasarkan ID tersebut.

Setelah penerima ditemukan, pengguna memilih bantuan:

```text
Masukkan ID Bantuan : B001
```

Program kemudian melakukan beberapa validasi.

Alur sederhananya:

```text
Pilih Penerima
      │
      ▼
Penerima ditemukan?
      │
      ▼
Pilih Bantuan
      │
      ▼
Bantuan ditemukan?
      │
      ▼
Sudah mengajukan bantuan yang sama?
      │
      ▼
Kuota masih tersedia?
      │
      ▼
Buat Pengajuan
      │
      ▼
Status = Menunggu
```

Jika seluruh kondisi terpenuhi:

```java
Pengajuan pengajuan =
        new Pengajuan(penerimaDipilih, bantuanDipilih);

daftarPengajuan.add(pengajuan);
```

ID pengajuan dibuat otomatis dan status awalnya `Menunggu`.

### Dokumentasi Create Pengajuan

> **Gambar 11. Create Pengajuan Bantuan**
>
> Gunakan:
>
> ```text
> Penerima : P001
> Bantuan  : B001
> ```
>
> Ambil screenshot sampai terlihat:
>
> ```text
> Pengajuan berhasil dibuat.
> ID Pengajuan : PG001
> Status       : Menunggu
> ```

![Gambar 11 - Create Pengajuan](images/gambar-11-create-pengajuan.png)

---

## 10.2 Read - Menampilkan Data Pengajuan

Menu `Tampilkan Pengajuan` digunakan untuk menampilkan seluruh pengajuan.

Program melakukan:

```java
for (Pengajuan pg : daftarPengajuan) {
    pg.tampilData();
}
```

Data yang ditampilkan meliputi:

```text
ID Pengajuan
Nama Penerima
Nama Bantuan
Status
```

### Dokumentasi Read Pengajuan

> **Gambar 12. Data Pengajuan Sebelum Diproses**
>
> Buka:
>
> ```text
> Kelola Data Pengajuan
> → Tampilkan Pengajuan
> ```
>
> Ambil screenshot yang memperlihatkan:
>
> ```text
> ID Pengajuan : PG001
> Penerima     : ...
> Bantuan      : Bantuan Sembako
> Status       : Menunggu
> ```

![Gambar 12 - Read Pengajuan](images/gambar-12-read-pengajuan.png)

---

# 11. Alur Proses dan Verifikasi Pengajuan

## 11.1 Memproses Pengajuan Individu

Pengguna memilih:

```text
Menu Utama
→ Proses Pengajuan
```

Kemudian memasukkan ID pengajuan:

```text
PG001
```

Program memastikan bahwa status pengajuan masih:

```text
Menunggu
```

Setelah itu program mengambil object penerima dan bantuan:

```java
Penerima penerima = pengajuanDipilih.getPenerima();
Bantuan bantuan = pengajuanDipilih.getBantuan();
```

Untuk `PenerimaIndividu`, syarat yang digunakan adalah:

```text
Penghasilan <= Rp2.500.000
```

Pemeriksaan dilakukan dengan:

```java
if (penerima.getPenghasilan() <= 2500000) {
```

Jika memenuhi syarat:

```java
pengajuanDipilih.setStatusPengajuan("Diterima");
bantuan.kurangiKuota();
```

Status berubah menjadi `Diterima` dan kuota bantuan berkurang satu.

### Dokumentasi Pengajuan Diterima

> **Gambar 13. Proses Pengajuan Diterima**
>
> Karena contoh P001 memiliki penghasilan Rp2.000.000, proses PG001.
>
> Ambil screenshot yang memperlihatkan:
>
> ```text
> Nama        : ...
> Bantuan     : Bantuan Sembako
> Penghasilan : Rp. 2000000
> Kuota       : 2
>
> Pengajuan DITERIMA.
> Sisa Kuota : 1
> ```
>
> Screenshot ini penting karena membuktikan proses verifikasi dan pengurangan kuota berjalan.

![Gambar 13 - Pengajuan Diterima](images/gambar-13-pengajuan-diterima.png)

---

## 11.2 Perubahan Kuota Setelah Pengajuan Diterima

Ketika pengajuan diterima, program menjalankan:

```java
bantuan.kurangiKuota();
```

Method pada class `Bantuan`:

```java
public void kurangiKuota() {
    if (kuota > 0) {
        kuota--;
    }
}
```

Contohnya:

```text
Kuota Awal  : 2
Pengajuan   : Diterima
Kuota Akhir : 1
```

### Dokumentasi Perubahan Kuota

> **Gambar 14. Kuota Setelah Pengajuan Diterima**
>
> Setelah PG001 diterima, kembali ke:
>
> ```text
> Kelola Data Bantuan
> → Tampilkan Bantuan
> ```
>
> Ambil screenshot B001.
>
> Jika pada Gambar 9 kuotanya `2`, pada gambar ini harus terlihat menjadi:
>
> ```text
> Kuota : 1
> ```

![Gambar 14 - Perubahan Kuota](images/gambar-14-kuota-berkurang.png)

---

## 11.3 Pengajuan Ditolak

Program juga dapat menolak pengajuan apabila penerima tidak memenuhi persyaratan.

Untuk Penerima Individu:

```text
Penghasilan > Rp2.500.000
→ Ditolak
```

Untuk Penerima Keluarga:

```text
Penghasilan > Rp3.500.000
atau
Jumlah Tanggungan < 1
→ Ditolak
```

### Dokumentasi Pengajuan Ditolak

> **Gambar 15. Proses Pengajuan Ditolak**
>
> Buat penerima tambahan dengan penghasilan yang tidak memenuhi syarat.
>
> Contoh Penerima Individu:
>
> ```text
> Penghasilan : 4000000
> ```
>
> Buat pengajuan menggunakan bantuan yang masih mempunyai kuota, kemudian proses pengajuan tersebut.
>
> Ambil screenshot ketika muncul:
>
> ```text
> Pengajuan DITOLAK.
> Alasan: Penghasilan melebihi batas.
> ```

![Gambar 15 - Pengajuan Ditolak](images/gambar-15-pengajuan-ditolak.png)

---

# 12. Validasi Pengajuan Ganda

Program mencegah penerima membuat pengajuan yang sama apabila sebelumnya masih memiliki pengajuan yang belum ditolak.

Pengecekan dilakukan dengan membandingkan:

```text
ID Penerima
+
ID Bantuan
+
Status Pengajuan
```

Jika ditemukan pengajuan yang sama:

```text
Pengajuan gagal.
Penerima sudah mengajukan bantuan tersebut.
```

### Dokumentasi Validasi Pengajuan Ganda

> **Gambar 16. Validasi Pengajuan Ganda**
>
> Setelah PG001 diterima, coba buat pengajuan lagi menggunakan:
>
> ```text
> Penerima : P001
> Bantuan  : B001
> ```
>
> Ambil screenshot ketika program menampilkan:
>
> ```text
> Pengajuan gagal.
> Penerima sudah mengajukan bantuan tersebut.
> ```

![Gambar 16 - Validasi Pengajuan Ganda](images/gambar-16-pengajuan-ganda.png)

---

# 13. Validasi Kuota Habis

Program memeriksa kuota sebelum pengajuan dibuat dan ketika pengajuan diproses.

Pengecekan dilakukan dengan:

```java
if (bantuanDipilih.getKuota() <= 0) {
    System.out.println("Pengajuan gagal.");
    System.out.println("Kuota bantuan sudah habis.");
    return;
}
```

Dengan demikian, bantuan dengan kuota `0` tidak dapat digunakan untuk membuat pengajuan baru.

### Dokumentasi Kuota Habis

> **Gambar 17. Validasi Kuota Bantuan Habis**
>
> Untuk mempermudah pengujian, buat bantuan lain dengan kuota `1`.
>
> Gunakan bantuan tersebut sampai satu pengajuan diterima sehingga kuotanya menjadi `0`.
>
> Setelah itu gunakan penerima lain yang belum pernah mengajukan bantuan tersebut dan coba membuat pengajuan.
>
> Ambil screenshot ketika muncul:
>
> ```text
> Pengajuan gagal.
> Kuota bantuan sudah habis.
> ```

![Gambar 17 - Kuota Habis](images/gambar-17-kuota-habis.png)

---

# 14. Validasi Pengajuan yang Sudah Diproses

Pengajuan yang sudah memiliki status `Diterima` atau `Ditolak` tidak dapat diproses kembali.

Program memeriksa:

```java
if (!pengajuanDipilih.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
    System.out.println("Pengajuan sudah pernah diproses.");
    System.out.println("Status : " + pengajuanDipilih.getStatusPengajuan());
    return;
}
```

Validasi ini juga mencegah kuota berkurang berulang kali akibat pengajuan yang sama diproses lebih dari satu kali.

### Dokumentasi Proses Ulang Pengajuan

> **Gambar 18. Validasi Pengajuan yang Sudah Diproses**
>
> Coba proses kembali PG001 yang sebelumnya sudah diterima.
>
> Ambil screenshot ketika muncul:
>
> ```text
> Pengajuan sudah pernah diproses.
> Status : Diterima
> ```

![Gambar 18 - Pengajuan Sudah Diproses](images/gambar-18-proses-ulang.png)

---

# 15. Delete Pengajuan

Pengajuan hanya dapat dihapus apabila statusnya masih `Menunggu`.

Jika status sudah `Diterima` atau `Ditolak`, program akan menampilkan:

```text
Pengajuan tidak dapat dihapus.
Pengajuan sudah diproses.
```

Hal ini dilakukan agar riwayat pengajuan yang sudah diproses tidak hilang.

### Dokumentasi Validasi Delete Pengajuan

> **Gambar 19. Validasi Delete Pengajuan**
>
> Coba hapus PG001 yang sebelumnya sudah diterima.
>
> Ambil screenshot ketika muncul:
>
> ```text
> Pengajuan tidak dapat dihapus.
> Pengajuan sudah diproses.
> ```

![Gambar 19 - Delete Pengajuan](images/gambar-19-delete-pengajuan.png)

---

# 16. Alur Keseluruhan Program

Secara keseluruhan, proses utama sistem dapat digambarkan sebagai berikut:

```text
                         MULAI
                           │
                           ▼
                      Menu Utama
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
      Penerima          Bantuan         Pengajuan
          │                │                │
          ▼                ▼                ▼
      Tambah Data      Tambah Data     Pilih Penerima
          │                │                │
          ▼                ▼                ▼
      Validasi Data    Validasi Data     Pilih Bantuan
          │                │                │
          ▼                ▼                ▼
     Simpan ArrayList  Simpan ArrayList  Cek Pengajuan
                                            │
                                            ▼
                                        Cek Kuota
                                            │
                                            ▼
                                     Buat Pengajuan
                                            │
                                            ▼
                                      Status Menunggu
                                            │
                                            ▼
                                     Proses Pengajuan
                                            │
                            ┌───────────────┴───────────────┐
                            │                               │
                            ▼                               ▼
                    Tidak Memenuhi                    Memenuhi Syarat
                            │                               │
                            ▼                               ▼
                         Ditolak                         Diterima
                                                            │
                                                            ▼
                                                     Kuota Berkurang
                                                            │
                                                            ▼
                                                         SELESAI
```

---

# 17. Penerapan CRUD

Konsep CRUD diterapkan terutama pada pengelolaan data penerima.

| Operasi | Implementasi |
|---|---|
| **Create** | Menambahkan data penerima |
| **Read** | Menampilkan data penerima |
| **Update** | Mengubah data penerima |
| **Delete** | Menghapus data penerima |

Data bantuan menerapkan proses tambah, tampil, dan hapus sesuai kebutuhan program.

Data pengajuan menerapkan proses buat, tampil, hapus, serta proses verifikasi pengajuan.

---

# 18. Validasi yang Diterapkan

Beberapa validasi yang diterapkan dalam program yaitu:

1. Jenis penerima harus tersedia.
2. NIK harus memiliki panjang 16 karakter.
3. NIK tidak boleh digunakan oleh dua penerima.
4. Penghasilan tidak boleh negatif.
5. Jumlah anggota keluarga harus lebih dari 0.
6. Jumlah tanggungan tidak boleh negatif.
7. Jumlah tanggungan tidak boleh melebihi jumlah anggota keluarga.
8. Nominal bantuan harus lebih dari 0.
9. Kuota bantuan harus lebih dari 0 ketika bantuan dibuat.
10. ID penerima harus ditemukan sebelum pengajuan dibuat.
11. ID bantuan harus ditemukan sebelum pengajuan dibuat.
12. Pengajuan yang sama tidak dapat dibuat kembali selama pengajuan sebelumnya belum ditolak.
13. Pengajuan baru tidak dapat dibuat jika kuota bantuan habis.
14. Pengajuan yang sudah diproses tidak dapat diproses kembali.
15. Pengajuan yang sudah diproses tidak dapat dihapus.
16. Penerima yang sudah mempunyai pengajuan tidak dapat dihapus.
17. Bantuan yang sudah digunakan dalam pengajuan tidak dapat dihapus.

---

# 19. Skenario Pengujian Program

Untuk memastikan program berjalan sesuai rancangan, berikut beberapa skenario pengujian yang dapat dilakukan:

| No | Pengujian | Hasil yang Diharapkan |
|---|---|---|
| 1 | Tambah Penerima Individu | Data berhasil disimpan dan mendapat ID otomatis |
| 2 | Tambah Penerima Keluarga | Data berhasil disimpan dan mendapat ID otomatis |
| 3 | Memasukkan NIK yang sama | Program menolak NIK duplikat |
| 4 | Menampilkan penerima | Individu dan Keluarga tampil sesuai jenisnya |
| 5 | Mengubah penerima | Data penerima berhasil diperbarui |
| 6 | Menghapus penerima tanpa pengajuan | Data berhasil dihapus |
| 7 | Menghapus penerima yang memiliki pengajuan | Program menolak penghapusan |
| 8 | Menambahkan bantuan | Bantuan mendapat ID otomatis |
| 9 | Membuat pengajuan | Status awal menjadi Menunggu |
| 10 | Pengajuan memenuhi syarat | Status menjadi Diterima |
| 11 | Pengajuan tidak memenuhi syarat | Status menjadi Ditolak |
| 12 | Pengajuan diterima | Kuota bantuan berkurang satu |
| 13 | Membuat pengajuan ganda | Program menolak pengajuan |
| 14 | Mengajukan bantuan dengan kuota 0 | Program menolak pengajuan |
| 15 | Memproses pengajuan dua kali | Program menolak proses kedua |

---

# 20. Daftar Screenshot Dokumentasi

Agar dokumentasi repository tersusun rapi, seluruh screenshot dapat disimpan pada folder:

```text
images/
```

Gunakan nama file berikut:

```text
images/
├── gambar-01-struktur-project.png
├── gambar-02-menu-utama.png
├── gambar-03-create-individu.png
├── gambar-04-create-keluarga.png
├── gambar-05-read-penerima.png
├── gambar-06-update-penerima.png
├── gambar-07-delete-penerima.png
├── gambar-08-create-bantuan.png
├── gambar-09-read-bantuan.png
├── gambar-10-delete-bantuan.png
├── gambar-11-create-pengajuan.png
├── gambar-12-read-pengajuan.png
├── gambar-13-pengajuan-diterima.png
├── gambar-14-kuota-berkurang.png
├── gambar-15-pengajuan-ditolak.png
├── gambar-16-pengajuan-ganda.png
├── gambar-17-kuota-habis.png
├── gambar-18-proses-ulang.png
└── gambar-19-delete-pengajuan.png
```

Tidak semua screenshot harus memperlihatkan seluruh NetBeans. Screenshot dapat difokuskan pada bagian **Output** agar tulisan mudah dibaca.

Namun untuk **Gambar 1 Struktur Project**, screenshot sebaiknya memperlihatkan panel Projects pada NetBeans.

---

# 21. Kesimpulan

**Sistem Pengelolaan Bantuan Sosial Daerah Samarinda** merupakan program berbasis Java yang digunakan untuk mengelola data penerima, bantuan, serta proses pengajuan bantuan sosial.

Program menerapkan konsep dasar Pemrograman Berorientasi Objek melalui penggunaan class dan object, constructor, encapsulation, inheritance, serta relasi antar object.

Inheritance diterapkan melalui class `Penerima` sebagai superclass, kemudian diturunkan menjadi `PenerimaIndividu` dan `PenerimaKeluarga`.

Program juga menggunakan `ArrayList` sebagai penyimpanan data sementara, percabangan untuk menentukan proses, perulangan untuk menjalankan menu dan membaca data, serta validasi untuk mencegah beberapa kesalahan input.

Pada proses pengajuan, program dapat menentukan apakah pengajuan diterima atau ditolak berdasarkan jenis penerima dan kriteria yang telah ditentukan. Jika pengajuan diterima, kuota bantuan akan berkurang secara otomatis.

Dengan adanya studi kasus ini, konsep dasar Pemrograman Berorientasi Objek dapat diterapkan dalam sebuah program sederhana yang memiliki hubungan antar class, pengelolaan data, validasi, dan aturan proses yang jelas.