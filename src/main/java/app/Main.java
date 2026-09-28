/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Penerima;
import model.PenerimaIndividu;
import model.PenerimaKeluarga;
import model.Bantuan;
import model.Pengajuan;

/**
 *
 * @author zefrialrizkullah 
 */
public class Main {
    Scanner input = new Scanner(System.in);
    ArrayList<Penerima> daftarPenerima = new ArrayList<>();
    ArrayList<Bantuan> daftarBantuan = new ArrayList<>();
    ArrayList<Pengajuan> daftarPengajuan = new ArrayList<>();
    
    public static void main(String[] args) {
        Main program = new Main();
        program.menuUtama();
    }

    public Main() {
        tambahDummyData();
    }

    //    Menu Utama
    public void menuUtama() {
        int pilih;

        do {
            System.out.println();
            System.out.println("===========================================");
            System.out.println(" SISTEM PENGELOLAAN BANSOS DAERAH SAMARINDA");
            System.out.println("===========================================");
            tampilDashboard();
            System.out.println("1. Kelola Data Penerima");
            System.out.println("2. Kelola Data Bantuan");
            System.out.println("3. Kelola Data Pengajuan");
            System.out.println("4. Proses Pengajuan");
            System.out.println("5. Laporan Bansos");
            System.out.println("0. Keluar\n");
            pilih = inputMenu("Pilih menu : ");
            System.out.println("===========================================");

            switch (pilih) {
                case 1:
                    menuPenerima();
                    break;

                case 2:
                    menuBantuan();
                    break;

                case 3:
                    menuPengajuan();
                    break;

                case 4:
                    prosesPengajuan();
                    break;

                case 5:
                    menuLaporan();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilih != 0);
    }
    
    //    Menu Lainnya
    public void menuPenerima() {
        int pilih;

        do {
            System.out.println();
            System.out.println("=-=-=-=-= KELOLA DATA PENERIMA =-=-=-=-=");
            System.out.println("1. Tambah Penerima");
            System.out.println("2. Tampilkan Penerima");
            System.out.println("3. Ubah Penerima");
            System.out.println("4. Hapus Penerima");
            System.out.println("0. Kembali");
            pilih = inputMenu("Pilih menu : ");

            switch (pilih) {
                case 1:
                    tambahPenerima();
                    break;

                case 2:
                    tampilPenerima();
                    break;

                case 3:
                    ubahPenerima();
                    break;

                case 4:
                    hapusPenerima();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 0);
    }
    
    public void menuBantuan() {
        int pilih;

        do {
            System.out.println();
            System.out.println("=-=-=-=-= KELOLA DATA BANTUAN =-=-=-=-=");
            System.out.println("1. Tambah Bantuan");
            System.out.println("2. Tampilkan Bantuan");
            System.out.println("3. Hapus Bantuan");
            System.out.println("0. Kembali");
            pilih = inputMenu("Pilih menu : ");

            switch (pilih) {
                case 1:
                    tambahBantuan();
                    break;

                case 2:
                    tampilBantuan();
                    break;

                case 3:
                    hapusBantuan();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 0);
    }

    public void menuPengajuan() {
        int pilih;

        do {
            System.out.println();
            System.out.println("=-=-=-=-= KELOLA DATA PENGAJUAN =-=-=-=-=");
            System.out.println("1. Buat Pengajuan");
            System.out.println("2. Tampilkan Pengajuan");
            System.out.println("3. Hapus Pengajuan");
            System.out.println("0. Kembali");
            pilih = inputMenu("Pilih menu : ");

            switch (pilih) {
                case 1:
                    tambahPengajuan();
                    break;

                case 2:
                    tampilPengajuan();
                    break;

                case 3:
                    hapusPengajuan();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 0);
    }
    
    public void menuLaporan() {
        int pilih;

        do {
            System.out.println();
            System.out.println("=-=-=-=-=-=-= LAPORAN BANSOS =-=-=-=-=-=-=");
            System.out.println("1. Ringkasan Penerima");
            System.out.println("2. Ringkasan Bantuan");
            System.out.println("3. Pengajuan Menunggu");
            System.out.println("4. Pengajuan Diterima");
            System.out.println("5. Pengajuan Ditolak");
            System.out.println("6. Statistik Bansos");
            System.out.println("0. Kembali");
            pilih = inputMenu("Pilih menu : ");

            switch (pilih) {
                case 1:
                    laporanPenerima();
                    break;

                case 2:
                    laporanBantuan();
                    break;

                case 3:
                    laporanPengajuan("Menunggu");
                    break;

                case 4:
                    laporanPengajuan("Diterima");
                    break;

                case 5:
                    laporanPengajuan("Ditolak");
                    break;

                case 6:
                    statistikBansos();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilih != 0);
    }
    
    public void tampilDashboard() {
        int menunggu = 0;
        int diterima = 0;
        int ditolak = 0;

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
                menunggu++;
            } else if (pg.getStatusPengajuan().equalsIgnoreCase("Diterima")) {
                diterima++;
            } else if (pg.getStatusPengajuan().equalsIgnoreCase("Ditolak")) {
                ditolak++;
            }
        }

        System.out.println("------------- RINGKASAN SISTEM ------------");
        System.out.println("Total Penerima       : " + daftarPenerima.size());
        System.out.println("Total Jenis Bantuan  : " + daftarBantuan.size());
        System.out.println("Total Pengajuan      : " + daftarPengajuan.size());
        System.out.println("Menunggu             : " + menunggu);
        System.out.println("Diterima             : " + diterima);
        System.out.println("Ditolak              : " + ditolak);
        System.out.println("-------------------------------------------");
    }
    
    public Penerima cariPenerima(String id) {
        for (Penerima p : daftarPenerima) {
            if (p.getIdPenerima().equalsIgnoreCase(id)) {
                return p;
            }
        }

        return null;
    }

    public Bantuan cariBantuan(String id) {
        for (Bantuan b : daftarBantuan) {
            if (b.getIdBantuan().equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    public Pengajuan cariPengajuan(String id) {
        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getIdPengajuan().equalsIgnoreCase(id)) {
                return pg;
            }
        }

        return null;
    }
    
    public int inputInt(String pesan) {
        String nilai;

        do {
            System.out.print(pesan);
            nilai = input.nextLine();

            if (!nilai.matches("\\d{1,9}")) {
                System.out.println("Input harus berupa angka yang valid.");
            }

        } while (!nilai.matches("\\d{1,9}"));

        return Integer.parseInt(nilai);
    }

    public double inputDouble(String pesan) {
        String nilai;

        do {
            System.out.print(pesan);
            nilai = input.nextLine();

            if (!nilai.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Input harus berupa angka.");
            }

        } while (!nilai.matches("\\d+(\\.\\d+)?"));

        return Double.parseDouble(nilai);
    }

    public int inputMenu(String pesan) {
        String nilai;

        do {
            System.out.print(pesan);
            nilai = input.nextLine();

            if (!nilai.matches("\\d")) {
                System.out.println("Pilihan harus berupa satu angka.");
            }

        } while (!nilai.matches("\\d"));

        return Integer.parseInt(nilai);
    }

    //    Kumpulan Methods
    public void tambahPenerima() {
        System.out.println();
        System.out.println("=-=-=-=-= TAMBAH PENERIMA =-=-=-=-=");
        System.out.println("1. Penerima Individu");
        System.out.println("2. Penerima Keluarga");
        String jenis;

        do {
            System.out.print("Pilih jenis penerima : ");
            jenis = input.nextLine();

            if (!jenis.equals("1") && !jenis.equals("2")) {
                System.out.println("Pilihan hanya 1 atau 2.");
            }

        } while (!jenis.equals("1") && !jenis.equals("2"));
        
        String nik;

        do {
            System.out.print("\nNIK 16 digit : ");
            nik = input.nextLine();

            if (!nik.matches("\\d{16}")) {
                System.out.println("NIK harus terdiri dari 16 digit angka.");
            }

        } while (!nik.matches("\\d{16}"));
        
        for (Penerima p : daftarPenerima) {
            if (p.getNik().equals(nik)) {
                System.out.println("NIK sudah terdaftar.");
                return;
            }
        }

        String nama;

        do {
            System.out.print("Nama : ");
            nama = input.nextLine();

            if (nama.trim().isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
            }

        } while (nama.trim().isEmpty());
        
        String alamat;

        do {
            System.out.print("Alamat : ");
            alamat = input.nextLine();

            if (alamat.trim().isEmpty()) {
                System.out.println("Alamat tidak boleh kosong.");
            }

        } while (alamat.trim().isEmpty());
        
        double penghasilan = inputDouble("Penghasilan : ");

        if (jenis.equals("1")) {
            String pekerjaan;

            do {
                System.out.print("Pekerjaan : ");
                pekerjaan = input.nextLine();

                if (pekerjaan.trim().isEmpty()) {
                    System.out.println("Pekerjaan tidak boleh kosong.");
                }

            } while (pekerjaan.trim().isEmpty());

            String statusRumah;

            do {
                System.out.print("Status Rumah (Milik Sendiri/Sewa) : ");
                statusRumah = input.nextLine();

                if (!statusRumah.equalsIgnoreCase("Milik Sendiri")
                        && !statusRumah.equalsIgnoreCase("Sewa")) {

                    System.out.println("Status rumah harus Milik Sendiri atau Sewa.");
                }

            } while (!statusRumah.equalsIgnoreCase("Milik Sendiri")
                    && !statusRumah.equalsIgnoreCase("Sewa"));

            PenerimaIndividu individu = new PenerimaIndividu(
                    nik, nama, alamat, penghasilan, pekerjaan, statusRumah
            );

            daftarPenerima.add(individu);

            System.out.println("Data penerima individu berhasil ditambahkan.");
            System.out.println("ID Penerima : " + individu.getIdPenerima());

        } else {
            int jumlahAnggota;

            do {
                jumlahAnggota = inputInt("Jumlah Anggota Keluarga : ");

                if (jumlahAnggota <= 0) {
                    System.out.println(
                            "Jumlah anggota keluarga harus lebih dari 0."
                    );
                }

            } while (jumlahAnggota <= 0);

            int jumlahTanggungan;

            do {
                jumlahTanggungan = inputInt("Jumlah Tanggungan : ");

                if (jumlahTanggungan > jumlahAnggota) {
                    System.out.println(
                            "Jumlah tanggungan tidak boleh melebihi jumlah anggota keluarga."
                    );
                }

            } while (jumlahTanggungan > jumlahAnggota);

            PenerimaKeluarga keluarga = new PenerimaKeluarga(
                    nik,
                    nama,
                    alamat,
                    penghasilan,
                    jumlahAnggota,
                    jumlahTanggungan
            );

            daftarPenerima.add(keluarga);

            System.out.println("Data penerima keluarga berhasil ditambahkan.");
            System.out.println("ID Penerima : " + keluarga.getIdPenerima());
        }
    }
    
    public void ubahPenerima() {
        System.out.println();
        System.out.println("=-=-=-=-= UBAH DATA PENERIMA =-=-=-=-=");

        if (daftarPenerima.isEmpty()) {
            System.out.println("Belum ada data penerima.");
            return;
        }

        tampilPenerima();
        System.out.print("Masukkan ID Penerima : ");
        String id = input.nextLine();
        Penerima penerimaDipilih = cariPenerima(id);

        if (penerimaDipilih == null) {
            System.out.println("Penerima tidak ditemukan.");
            return;
        }

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getPenerima().getIdPenerima()
                    .equalsIgnoreCase(penerimaDipilih.getIdPenerima())
                    && pg.getStatusPengajuan().equalsIgnoreCase("Diterima")) {
                System.out.println("Data penerima tidak dapat diubah.");
                System.out.println("Penerima memiliki pengajuan yang sudah diterima.");
                return;
            }
        }

        String nik;
        boolean nikDuplikat;

        do {
            System.out.print("NIK Baru : ");
            nik = input.nextLine();

            if (!nik.matches("\\d{16}")) {
                System.out.println("NIK harus terdiri dari 16 digit angka.");
            }

            nikDuplikat = false;

            if (nik.matches("\\d{16}")) {
                for (Penerima p : daftarPenerima) {
                    if (p.getNik().equals(nik)
                            && !p.getIdPenerima().equalsIgnoreCase(
                                    penerimaDipilih.getIdPenerima())) {

                        System.out.println("NIK sudah digunakan penerima lain.");
                        nikDuplikat = true;
                        break;
                    }
                }
            }

        } while (!nik.matches("\\d{16}") || nikDuplikat);

        String nama;
        do {
            System.out.print("Nama Baru : ");
            nama = input.nextLine();

            if (nama.trim().isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
            }

        } while (nama.trim().isEmpty());
        
        String alamat;

        do {
            System.out.print("Alamat Baru: ");
            alamat = input.nextLine();

            if (alamat.trim().isEmpty()) {
                System.out.println("Alamat tidak boleh kosong.");
            }

        } while (alamat.trim().isEmpty());
        
        double penghasilan = inputDouble("Penghasilan Baru : ");

        penerimaDipilih.setNik(nik);
        penerimaDipilih.setNama(nama);
        penerimaDipilih.setAlamat(alamat);
        penerimaDipilih.setPenghasilan(penghasilan);

        if (penerimaDipilih instanceof PenerimaIndividu) {
            PenerimaIndividu individu = (PenerimaIndividu) penerimaDipilih;
            String pekerjaan;

            do {
                System.out.print("Pekerjaan Baru: ");
                pekerjaan = input.nextLine();

                if (pekerjaan.trim().isEmpty()) {
                    System.out.println("Pekerjaan tidak boleh kosong.");
                }

            } while (pekerjaan.trim().isEmpty());
            
            String statusRumah;

            do {
                System.out.print("Status Rumah (Milik Sendiri/Sewa) : ");
                statusRumah = input.nextLine();

                if (!statusRumah.equalsIgnoreCase("Milik Sendiri")
                        && !statusRumah.equalsIgnoreCase("Sewa")) {

                    System.out.println("Status rumah harus Milik Sendiri atau Sewa.");
                }

            } while (!statusRumah.equalsIgnoreCase("Milik Sendiri")
                    && !statusRumah.equalsIgnoreCase("Sewa"));
            
            individu.setPekerjaan(pekerjaan);
            individu.setStatusRumah(statusRumah);

        } else if (penerimaDipilih instanceof PenerimaKeluarga) {
            PenerimaKeluarga keluarga = (PenerimaKeluarga) penerimaDipilih;
            int jumlahAnggota;

            do {
                jumlahAnggota = inputInt("Jumlah Anggota Keluarga Baru : ");

                if (jumlahAnggota <= 0) {
                    System.out.println(
                            "Jumlah anggota keluarga harus lebih dari 0."
                    );
                }

            } while (jumlahAnggota <= 0);

            int jumlahTanggungan;
            do {
                jumlahTanggungan = inputInt("Jumlah Tanggungan Baru : ");

                if (jumlahTanggungan > jumlahAnggota) {
                    System.out.println(
                            "Jumlah tanggungan tidak boleh melebihi jumlah anggota keluarga."
                    );
                }

            } while (jumlahTanggungan > jumlahAnggota);

            keluarga.setAnggotaKeluarga(jumlahAnggota);
            keluarga.setJumlahTanggungan(jumlahTanggungan);
        }

        System.out.println("Data penerima berhasil diubah.");
    }
    
    public void hapusPenerima() {
        System.out.println();
        System.out.println("=-=-=-=-= HAPUS DATA PENERIMA =-=-=-=-=");

        if (daftarPenerima.isEmpty()) {
            System.out.println("Belum ada data penerima.");
            return;
        }

        tampilPenerima();
        System.out.print("Masukkan ID Penerima : ");
        String id = input.nextLine();
        Penerima penerimaDipilih = cariPenerima(id);

        if (penerimaDipilih == null) {
            System.out.println("Penerima tidak ditemukan.");
            return;
        }

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getPenerima().getIdPenerima().equalsIgnoreCase(id)) {
                System.out.println("Penerima tidak dapat dihapus.");
                System.out.println("Penerima sudah memiliki data pengajuan.");
                return;
            }
        }

        daftarPenerima.remove(penerimaDipilih);
        System.out.println("Data penerima berhasil dihapus.");
    }
    
    public void tampilPenerima() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=  DATA PENERIMA  =-=-=-=-=-=-=-=-=");

        if (daftarPenerima.isEmpty()) {
            System.out.println("Belum ada data penerima.");
            return;
        }
        for (Penerima p : daftarPenerima) {
            p.tampilData();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
    public void tambahBantuan() {
        System.out.println();
        System.out.println("=-=-= TAMBAH BANTUAN =-=-=");
        String nama;

        do {
            System.out.print("Nama Bantuan : ");
            nama = input.nextLine();

            if (nama.trim().isEmpty()) {
                System.out.println("Nama bantuan tidak boleh kosong.");
            }

        } while (nama.trim().isEmpty());

        double nominal;

        do {
            nominal = inputDouble("Nominal Bantuan : ");

            if (nominal <= 0) {
                System.out.println("Nominal harus lebih dari 0.");
            }

        } while (nominal <= 0);

        int kuota;

        do {
            kuota = inputInt("Kuota : ");

            if (kuota <= 0) {
                System.out.println("Kuota harus lebih dari 0.");
            }

        } while (kuota <= 0);

        Bantuan bantuan = new Bantuan(nama, nominal, kuota);
        daftarBantuan.add(bantuan);
        System.out.println("Data bantuan berhasil ditambahkan.");
        System.out.println("ID Bantuan : " + bantuan.getIdBantuan());
    }

    public void hapusBantuan() {
        System.out.println();
        System.out.println("=-=-=-=-= HAPUS DATA BANTUAN =-=-=-=-=");

        if (daftarBantuan.isEmpty()) {
            System.out.println("Belum ada data bantuan.");
            return;
        }

        tampilBantuan();
        System.out.print("Masukkan ID Bantuan : ");
        String id = input.nextLine();
        Bantuan bantuanDipilih = cariBantuan(id);

        if (bantuanDipilih == null) {
            System.out.println("Bantuan tidak ditemukan.");
            return;
        }

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getBantuan().getIdBantuan().equalsIgnoreCase(id)) {
                System.out.println("Bantuan tidak dapat dihapus.");
                System.out.println("Bantuan sudah digunakan dalam pengajuan.");
                return;
            }
        }

        daftarBantuan.remove(bantuanDipilih);
        System.out.println("Data bantuan berhasil dihapus.");
    }
    
    public void tampilBantuan() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=  DATA BANTUANN  =-=-=-=-=-=-=-=-=");

        if (daftarBantuan.isEmpty()) {
            System.out.println("Belum ada data bantuan.");
            return;
        }

        for (Bantuan b : daftarBantuan) {
            b.tampilData();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
    public void tambahPengajuan() {
        System.out.println();
        System.out.println("=-=-=-=-= BUAT PENGAJUAN =-=-=-=-=");

        if (daftarPenerima.isEmpty()) {
            System.out.println("Data penerima masih kosong.");
            return;
        }

        if (daftarBantuan.isEmpty()) {
            System.out.println("Data bantuan masih kosong.");
            return;
        }

        tampilPenerima();
        System.out.print("Masukkan ID Penerima : ");
        String idPenerima = input.nextLine();
        Penerima penerimaDipilih = cariPenerima(idPenerima);

        if (penerimaDipilih == null) {
            System.out.println("Penerima tidak ditemukan.");
            return;
        }

        tampilBantuan();

        System.out.print("Masukkan ID Bantuan : ");
        String idBantuan = input.nextLine();

        Bantuan bantuanDipilih = cariBantuan(idBantuan);

        if (bantuanDipilih == null) {
            System.out.println("Bantuan tidak ditemukan.");
            return;
        }

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getPenerima().getIdPenerima()
                    .equalsIgnoreCase(penerimaDipilih.getIdPenerima())
                    && pg.getBantuan().getIdBantuan()
                    .equalsIgnoreCase(bantuanDipilih.getIdBantuan())
                    && !pg.getStatusPengajuan().equalsIgnoreCase("Ditolak")) {

                System.out.println("Pengajuan gagal.");
                System.out.println("Penerima sudah mengajukan bantuan tersebut.");
                return;
            }
        }

        if (bantuanDipilih.getKuota() <= 0) {
            System.out.println("Pengajuan gagal.");
            System.out.println("Kuota bantuan sudah habis.");
            return;
        }

        Pengajuan pengajuan = new Pengajuan(penerimaDipilih, bantuanDipilih);
        daftarPengajuan.add(pengajuan);
        System.out.println("Pengajuan berhasil dibuat.");
        System.out.println("ID Pengajuan : " + pengajuan.getIdPengajuan());
        System.out.println("Status       : " + pengajuan.getStatusPengajuan());
    }
    
    public void hapusPengajuan() {
        System.out.println();
        System.out.println("=-=-=-=-= HAPUS DATA PENGAJUAN =-=-=-=-=");

        if (daftarPengajuan.isEmpty()) {
            System.out.println("Belum ada data pengajuan.");
            return;
        }

        tampilPengajuan();
        System.out.print("Masukkan ID Pengajuan : ");
        String id = input.nextLine();
        Pengajuan pengajuanDipilih = cariPengajuan(id);

        if (pengajuanDipilih == null) {
            System.out.println("Pengajuan tidak ditemukan.");
            return;
        }

        if (!pengajuanDipilih.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
            System.out.println("Pengajuan tidak dapat dihapus.");
            System.out.println("Pengajuan sudah diproses.");
            return;
        }

        daftarPengajuan.remove(pengajuanDipilih);
        System.out.println("Data pengajuan berhasil dihapus.");
    }
    
    public void tampilPengajuan() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-= DATA PENGAJUANN =-=-=-=-=-=-=-=-=");

        if (daftarPengajuan.isEmpty()) {
            System.out.println("Belum ada data pengajuan.");
            return;
        }

        for (Pengajuan pg : daftarPengajuan) {
            pg.tampilData();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
    public void prosesPengajuan() {
        System.out.println();
        System.out.println("=-=-= PROSES PENGAJUAN =-=-=");

        if (daftarPengajuan.isEmpty()) {
            System.out.println("Belum ada pengajuan.");
            return;
        }

        tampilPengajuan();
        System.out.print("Masukkan ID Pengajuan : ");
        String id = input.nextLine();
        Pengajuan pengajuanDipilih = cariPengajuan(id);

        if (pengajuanDipilih == null) {
            System.out.println("Pengajuan tidak ditemukan.");
            return;
        }

        if (!pengajuanDipilih.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
            System.out.println("Pengajuan sudah pernah diproses.");
            System.out.println("Status     : " + pengajuanDipilih.getStatusPengajuan());
            System.out.println("Keterangan : " + pengajuanDipilih.getKeterangan());
            return;
        }

        Penerima penerima = pengajuanDipilih.getPenerima();
        Bantuan bantuan = pengajuanDipilih.getBantuan();

        if (bantuan.getKuota() <= 0) {
            pengajuanDipilih.setStatusPengajuan("Ditolak");
            pengajuanDipilih.setKeterangan("Kuota bantuan sudah habis.");
            System.out.println("Pengajuan DITOLAK.");
            System.out.println("Alasan : " + pengajuanDipilih.getKeterangan());
            return;
        }

        System.out.println();
        System.out.println("Nama        : " + penerima.getNama());
        System.out.println("Bantuan     : " + bantuan.getNamaBantuan());
        System.out.println("Penghasilan : Rp. " + penerima.getPenghasilan());
        System.out.println("Kuota       : " + bantuan.getKuota());

        if (penerima instanceof PenerimaIndividu) {
            if (penerima.getPenghasilan() <= 2500000) {
                pengajuanDipilih.setStatusPengajuan("Diterima");
                pengajuanDipilih.setKeterangan("Penghasilan memenuhi kriteria penerima individu.");
                bantuan.kurangiKuota();
                System.out.println("Pengajuan DITERIMA.");
                System.out.println("Keterangan : " + pengajuanDipilih.getKeterangan());
                System.out.println("Sisa Kuota : " + bantuan.getKuota());
            } else {
                pengajuanDipilih.setStatusPengajuan("Ditolak");
                pengajuanDipilih.setKeterangan("Penghasilan melebihi batas penerima individu.");
                System.out.println("Pengajuan DITOLAK.");
                System.out.println("Alasan : " + pengajuanDipilih.getKeterangan());
            }

        } else if (penerima instanceof PenerimaKeluarga) {
            PenerimaKeluarga keluarga = (PenerimaKeluarga) penerima;

            if (penerima.getPenghasilan() <= 3500000
                    && keluarga.getJumlahTanggungan() >= 1) {
                pengajuanDipilih.setStatusPengajuan("Diterima");
                pengajuanDipilih.setKeterangan("Penghasilan dan jumlah tanggungan memenuhi kriteria keluarga.");
                bantuan.kurangiKuota();
                System.out.println("Pengajuan DITERIMA.");
                System.out.println("Keterangan : " + pengajuanDipilih.getKeterangan());
                System.out.println("Sisa Kuota : " + bantuan.getKuota());
            } else {
                pengajuanDipilih.setStatusPengajuan("Ditolak");

                if (penerima.getPenghasilan() > 3500000
                        && keluarga.getJumlahTanggungan() < 1) {
                    pengajuanDipilih.setKeterangan("Penghasilan melebihi batas dan tidak memiliki tanggungan.");
                } else if (penerima.getPenghasilan() > 3500000) {
                    pengajuanDipilih.setKeterangan("Penghasilan melebihi batas penerima keluarga.");
                } else {
                    pengajuanDipilih.setKeterangan("Tidak memiliki tanggungan.");
                }

                System.out.println("Pengajuan DITOLAK.");
                System.out.println("Alasan : " + pengajuanDipilih.getKeterangan());
            }
        }
    }
    
    public void tambahDummyData() {
        PenerimaIndividu individu = new PenerimaIndividu(
                "6472052404070001",
                "Zezey",
                "Samarinda",
                2000000,
                "Bisnisman",
                "Sewa"
        );

        PenerimaKeluarga keluarga = new PenerimaKeluarga(
                "6472052404070002",
                "Zeyya",
                "Samarinda",
                3000000,
                4,
                2
        );

        Bantuan bantuan1 = new Bantuan(
                "Bantuan Sembako",
                500000,
                5
        );

        Bantuan bantuan2 = new Bantuan(
                "Bantuan Tunai",
                1000000,
                3
        );

        daftarPenerima.add(individu);
        daftarPenerima.add(keluarga);

        daftarBantuan.add(bantuan1);
        daftarBantuan.add(bantuan2);
    }
    
    public void laporanPenerima() {
        int individu = 0;
        int keluarga = 0;

        for (Penerima p : daftarPenerima) {
            if (p instanceof PenerimaIndividu) {
                individu++;
            } else if (p instanceof PenerimaKeluarga) {
                keluarga++;
            }
        }

        System.out.println();
        System.out.println("=-=-=-=-= RINGKASAN PENERIMA =-=-=-=-=");
        System.out.println("Total Penerima       : " + daftarPenerima.size());
        System.out.println("Penerima Individu    : " + individu);
        System.out.println("Penerima Keluarga    : " + keluarga);
    }
    
    public void laporanBantuan() {
        System.out.println();
        System.out.println("=-=-=-=-= RINGKASAN BANTUAN =-=-=-=-=");

        if (daftarBantuan.isEmpty()) {
            System.out.println("Belum ada data bantuan.");
            return;
        }

        int totalKuota = 0;

        for (Bantuan b : daftarBantuan) {
            System.out.println("ID Bantuan    : " + b.getIdBantuan());
            System.out.println("Nama Bantuan  : " + b.getNamaBantuan());
            System.out.println("Nominal       : Rp. " + b.getNominal());
            System.out.println("Sisa Kuota    : " + b.getKuota());
            System.out.println("------------------------------------");
            totalKuota += b.getKuota();
        }

        System.out.println("Total Jenis Bantuan : " + daftarBantuan.size());
        System.out.println("Total Sisa Kuota    : " + totalKuota);
    }
    
    public void laporanPengajuan(String status) {
        System.out.println();
        System.out.println("=-=-=-=-= PENGAJUAN " + status.toUpperCase() + " =-=-=-=-=");
        int jumlah = 0;

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getStatusPengajuan().equalsIgnoreCase(status)) {
                pg.tampilData();
                System.out.println("------------------------------------");
                jumlah++;
            }
        }

        if (jumlah == 0) {
            System.out.println("Tidak ada pengajuan dengan status " + status + ".");
        } else {
            System.out.println("Total Pengajuan " + status + " : " + jumlah);
        }
    }
    
    public void statistikBansos() {
        int individu = 0;
        int keluarga = 0;
        int menunggu = 0;
        int diterima = 0;
        int ditolak = 0;
        int totalKuota = 0;

        for (Penerima p : daftarPenerima) {
            if (p instanceof PenerimaIndividu) {
                individu++;
            } else if (p instanceof PenerimaKeluarga) {
                keluarga++;
            }
        }

        for (Bantuan b : daftarBantuan) {
            totalKuota += b.getKuota();
        }

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
                menunggu++;
            } else if (pg.getStatusPengajuan().equalsIgnoreCase("Diterima")) {
                diterima++;
            } else if (pg.getStatusPengajuan().equalsIgnoreCase("Ditolak")) {
                ditolak++;
            }
        }

        System.out.println();
        System.out.println("=-=-=-=-=-=-= STATISTIK BANSOS =-=-=-=-=-=-=");
        System.out.println("DATA PENERIMA");
        System.out.println("Total Penerima       : " + daftarPenerima.size());
        System.out.println("Individu             : " + individu);
        System.out.println("Keluarga             : " + keluarga);
        System.out.println();
        System.out.println("DATA BANTUAN");
        System.out.println("Jenis Bantuan        : " + daftarBantuan.size());
        System.out.println("Total Sisa Kuota     : " + totalKuota);
        System.out.println();
        System.out.println("DATA PENGAJUAN");
        System.out.println("Total Pengajuan      : " + daftarPengajuan.size());
        System.out.println("Menunggu             : " + menunggu);
        System.out.println("Diterima             : " + diterima);
        System.out.println("Ditolak              : " + ditolak);
    }
}
