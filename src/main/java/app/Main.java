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
    
    //    Menu Utama
    public void menuUtama() {
        int pilih;
        
        do {
            System.out.println();
            System.out.println("===========================================");
            System.out.println(" SISTEM PENGELOLAAN BANSOS DAERAH SAMARINDA");
            System.out.println("===========================================");
            System.out.println("1. Kelola Data Penerima");
            System.out.println("2. Kelola Data Bantuan");
            System.out.println("3. Kelola Data Pengajuan");
            System.out.println("4. Proses Pengajuan");
            System.out.println("0. Keluar\n");
            System.out.print("Pilih menu : ");
            pilih = input.nextInt();
            System.out.println("===========================================");
            input.nextLine();

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
            System.out.print("Pilih menu : ");
            pilih = input.nextInt();
            input.nextLine();

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
            System.out.print("Pilih menu : ");
            pilih = input.nextInt();
            input.nextLine();

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
            System.out.print("Pilih menu : ");
            pilih = input.nextInt();
            input.nextLine();

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

    //    Kumpulan Methods
    public void tambahPenerima() {
        System.out.println();
        System.out.println("=-=-=-=-= TAMBAH PENERIMA =-=-=-=-=");
        System.out.println("1. Penerima Individu");
        System.out.println("2. Penerima Keluarga");
        System.out.print("Pilih jenis penerima : ");
        int jenis = input.nextInt();
        input.nextLine();
        
        if (jenis != 1 && jenis != 2) {
            System.out.println("Jenis penerima tidak tersedia.");
            return;
        }
        
        String nik;

        do {
            System.out.print("\nNIK 16 digit : ");
            nik = input.nextLine();

            if (nik.length() != 16) {
                System.out.println("NIK harus 16 digit.");
            }
        } while (nik.length() != 16);
        
        for (Penerima p : daftarPenerima) {
            if (p.getNik().equals(nik)) {
                System.out.println("NIK sudah terdaftar.");
                return;
            }
        }

        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("Alamat : ");
        String alamat = input.nextLine();
        double penghasilan;

        do {
            System.out.print("Penghasilan : ");
            penghasilan = input.nextDouble();

            if (penghasilan < 0) {
                System.out.println("Penghasilan tidak boleh negatif.");
            }
        } while (penghasilan < 0);

        input.nextLine();

        if (jenis == 1) {
            System.out.print("Pekerjaan : ");
            String pekerjaan = input.nextLine();
            System.out.print("Status Rumah : ");
            String statusRumah = input.nextLine();
            PenerimaIndividu individu = new PenerimaIndividu(nik, nama, alamat, penghasilan, pekerjaan, statusRumah);
            daftarPenerima.add(individu);
            System.out.println("Data penerima individu berhasil ditambahkan.");
            System.out.println("ID Penerima : " + individu.getIdPenerima());
        } else if (jenis == 2) {
            int jumlahAnggota;

            do {
                System.out.print("Jumlah Anggota Keluarga : ");
                jumlahAnggota = input.nextInt();

                if (jumlahAnggota <= 0) {
                    System.out.println("Jumlah anggota keluarga harus lebih dari 0.");
                }
            } while (jumlahAnggota <= 0);

            int jumlahTanggungan;

            do {
                System.out.print("Jumlah Tanggungan : ");
                jumlahTanggungan = input.nextInt();

                if (jumlahTanggungan < 0) {
                    System.out.println("Jumlah tanggungan tidak boleh negatif.");
                } else if (jumlahTanggungan > jumlahAnggota) {
                    System.out.println("Jumlah tanggungan tidak boleh melebihi jumlah anggota keluarga.");
                }

            } while (jumlahTanggungan < 0 || jumlahTanggungan > jumlahAnggota);

            input.nextLine();
            PenerimaKeluarga keluarga = new PenerimaKeluarga(nik, nama, alamat, penghasilan, jumlahAnggota, jumlahTanggungan);
            daftarPenerima.add(keluarga);
            System.out.println("Data penerima keluarga berhasil ditambahkan.");
            System.out.println("ID Penerima : " + keluarga.getIdPenerima());            
        } else {
            System.out.println("Jenis penerima tidak tersedia.");
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
        Penerima penerimaDipilih = null;

        for (Penerima p : daftarPenerima) {
            if (p.getIdPenerima().equalsIgnoreCase(id)) {
                penerimaDipilih = p;
                break;
            }
        }

        if (penerimaDipilih == null) {
            System.out.println("Penerima tidak ditemukan.");
            return;
        }

        System.out.print("NIK Baru : ");
        String nik = input.nextLine();

        while (nik.length() != 16) {
            System.out.println("NIK harus 16 digit.");
            System.out.print("NIK Baru : ");
            nik = input.nextLine();
        }
        
        for (Penerima p : daftarPenerima) {
            if (p.getNik().equals(nik)
                    && !p.getIdPenerima().equalsIgnoreCase(penerimaDipilih.getIdPenerima())) {

                System.out.println("NIK sudah digunakan penerima lain.");
                return;
            }
        }

        System.out.print("Nama Baru : ");
        String nama = input.nextLine();
        System.out.print("Alamat Baru : ");
        String alamat = input.nextLine();
        double penghasilan;

        do {
            System.out.print("Penghasilan Baru : ");
            penghasilan = input.nextDouble();

            if (penghasilan < 0) {
                System.out.println("Penghasilan tidak boleh negatif.");
            }
        } while (penghasilan < 0);
        
        input.nextLine();
        penerimaDipilih.setNik(nik);
        penerimaDipilih.setNama(nama);
        penerimaDipilih.setAlamat(alamat);
        penerimaDipilih.setPenghasilan(penghasilan);

        if (penerimaDipilih instanceof PenerimaIndividu) {
            PenerimaIndividu individu = (PenerimaIndividu) penerimaDipilih;
            System.out.print("Pekerjaan Baru : ");
            String pekerjaan = input.nextLine();
            System.out.print("Status Rumah Baru : ");
            String statusRumah = input.nextLine();
            individu.setPekerjaan(pekerjaan);
            individu.setStatusRumah(statusRumah);

        } else if (penerimaDipilih instanceof PenerimaKeluarga) {
            PenerimaKeluarga keluarga = (PenerimaKeluarga) penerimaDipilih;
            System.out.print("Jumlah Anggota Keluarga : ");
            int jumlahAnggota = input.nextInt();
            
            do {
                System.out.print("Jumlah Anggota Keluarga : ");
                jumlahAnggota = input.nextInt();

                if (jumlahAnggota <= 0) {
                    System.out.println("Jumlah anggota keluarga harus lebih dari 0.");
                }
            } while (jumlahAnggota <= 0);
            
            System.out.print("Jumlah Tanggungan : ");
            int jumlahTanggungan = input.nextInt();
            do {
                System.out.print("Jumlah Tanggungan : ");
                jumlahTanggungan = input.nextInt();

                if (jumlahTanggungan < 0) {
                    System.out.println("Jumlah tanggungan tidak boleh negatif.");
                }
            } while (jumlahTanggungan < 0);
            
            do {
                System.out.print("Jumlah Tanggungan : ");
                jumlahTanggungan = input.nextInt();

                if (jumlahTanggungan < 0) {
                    System.out.println("Jumlah tanggungan tidak boleh negatif.");
                } else if (jumlahTanggungan > jumlahAnggota) {
                    System.out.println("Jumlah tanggungan tidak boleh melebihi jumlah anggota keluarga.");
                }

            } while (jumlahTanggungan < 0 || jumlahTanggungan > jumlahAnggota);
            
            input.nextLine();

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
        Penerima penerimaDipilih = null;

        for (Penerima p : daftarPenerima) {
            if (p.getIdPenerima().equalsIgnoreCase(id)) {
                penerimaDipilih = p;
                break;
            }
        }

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
            if (p instanceof PenerimaIndividu) {
                PenerimaIndividu individu = (PenerimaIndividu) p;
                individu.tampilDataIndividu();

            } else if (p instanceof PenerimaKeluarga) {
                PenerimaKeluarga keluarga = (PenerimaKeluarga) p;
                keluarga.tampilDataKeluarga();
            }
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
    public void tambahBantuan() {
        System.out.println();
        System.out.println("=-=-= TAMBAH BANTUAN =-=-=");

        System.out.print("Nama Bantuan : ");
        String nama = input.nextLine();

        double nominal;

        do {
            System.out.print("Nominal Bantuan : ");
            nominal = input.nextDouble();

            if (nominal <= 0) {
                System.out.println("Nominal harus lebih dari 0.");
            }
        } while (nominal <= 0);

        int kuota;

        do {
            System.out.print("Kuota : ");
            kuota = input.nextInt();

            if (kuota <= 0) {
                System.out.println("Kuota harus lebih dari 0.");
            }
        } while (kuota <= 0);

        input.nextLine();
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
        Bantuan bantuanDipilih = null;

        for (Bantuan b : daftarBantuan) {
            if (b.getIdBantuan().equalsIgnoreCase(id)) {
                bantuanDipilih = b;
                break;
            }
        }

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
        Penerima penerimaDipilih = null;

        for (Penerima p : daftarPenerima) {
            if (p.getIdPenerima().equalsIgnoreCase(idPenerima)) {
                penerimaDipilih = p;
                break;
            }
        }

        if (penerimaDipilih == null) {
            System.out.println("Penerima tidak ditemukan.");
            return;
        }

        tampilBantuan();

        System.out.print("Masukkan ID Bantuan : ");
        String idBantuan = input.nextLine();

        Bantuan bantuanDipilih = null;

        for (Bantuan b : daftarBantuan) {
            if (b.getIdBantuan().equalsIgnoreCase(idBantuan)) {
                bantuanDipilih = b;
                break;
            }
        }

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
        Pengajuan pengajuanDipilih = null;

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getIdPengajuan().equalsIgnoreCase(id)) {
                pengajuanDipilih = pg;
                break;
            }
        }

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
        Pengajuan pengajuanDipilih = null;

        for (Pengajuan pg : daftarPengajuan) {
            if (pg.getIdPengajuan().equalsIgnoreCase(id)) {
                pengajuanDipilih = pg;
                break;
            }
        }

        if (pengajuanDipilih == null) {
            System.out.println("Pengajuan tidak ditemukan.");
            return;
        }
        
        if (!pengajuanDipilih.getStatusPengajuan().equalsIgnoreCase("Menunggu")) {
            System.out.println("Pengajuan sudah pernah diproses.");
            System.out.println("Status : " + pengajuanDipilih.getStatusPengajuan());
            return;
        }

        Penerima penerima = pengajuanDipilih.getPenerima();
        Bantuan bantuan = pengajuanDipilih.getBantuan();
 
        if (bantuan.getKuota() <= 0) {
            pengajuanDipilih.setStatusPengajuan("Ditolak");
            System.out.println("Pengajuan DITOLAK.");
            System.out.println("Alasan: Kuota bantuan sudah habis.");
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
                bantuan.kurangiKuota();
                System.out.println("Pengajuan DITERIMA.");
                System.out.println("Sisa Kuota : " + bantuan.getKuota());
            } else {
                pengajuanDipilih.setStatusPengajuan("Ditolak");
                System.out.println("Pengajuan DITOLAK.");
                System.out.println("Alasan: Penghasilan melebihi batas."
                );
            }

        } else if (penerima instanceof PenerimaKeluarga) {
            PenerimaKeluarga keluarga = (PenerimaKeluarga) penerima;

            if (penerima.getPenghasilan() <= 3500000 && keluarga.getJumlahTanggungan() >= 1) {
                pengajuanDipilih.setStatusPengajuan("Diterima");
                bantuan.kurangiKuota();
                System.out.println("Pengajuan DITERIMA.");
                System.out.println("Sisa Kuota : " + bantuan.getKuota());
            } else {
                pengajuanDipilih.setStatusPengajuan("Ditolak");
                System.out.println("Pengajuan DITOLAK.");

                if (penerima.getPenghasilan() > 3500000) {
                    System.out.println("Alasan: Penghasilan melebihi batas.");
                }

                if (keluarga.getJumlahTanggungan() < 1) {
                    System.out.println("Alasan: Tidak memiliki tanggungan.");
                }
            }
        }
    }
}
