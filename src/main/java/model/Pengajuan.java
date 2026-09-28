/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */
public class Pengajuan {
    private final String idPengajuan;
    private String statusPengajuan;
    private String keterangan;
    private final Bantuan bantuan;
    private final Penerima penerima;
    private static int i = 1;

    public Pengajuan(Penerima penerima, Bantuan bantuan) {
        this.idPengajuan = String.format("PG%03d", i);
        i++;

        this.penerima = penerima;
        this.bantuan = bantuan;
        this.statusPengajuan = "Menunggu";
        this.keterangan = "Belum diproses";
    }

    public String getIdPengajuan() {
        return idPengajuan;
    }

    public String getStatusPengajuan() {
        return statusPengajuan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Bantuan getBantuan() {
        return bantuan;
    }

    public Penerima getPenerima() {
        return penerima;
    }

    public void setStatusPengajuan(String statusPengajuan) {
        if (statusPengajuan.equalsIgnoreCase("Menunggu")
                || statusPengajuan.equalsIgnoreCase("Diterima")
                || statusPengajuan.equalsIgnoreCase("Ditolak")) {
            this.statusPengajuan = statusPengajuan;
        }
    }

    public void setKeterangan(String keterangan) {
        if (keterangan != null && !keterangan.trim().isEmpty()) {
            this.keterangan = keterangan;
        }
    }

    public void tampilData() {
        System.out.println("ID Pengajuan    : " + idPengajuan);
        System.out.println("Penerima        : " + penerima.getNama());
        System.out.println("Bantuan         : " + bantuan.getNamaBantuan());
        System.out.println("Status          : " + statusPengajuan);
        System.out.println("Keterangan      : " + keterangan);
    }
}