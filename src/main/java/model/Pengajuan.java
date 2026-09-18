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
    private String idPengajuan;
    private String statusPengajuan;
    private Bantuan bantuan;
    private Penerima penerima;
    private static int i = 1;
    
    public Pengajuan(Penerima penerima, Bantuan bantuan) {
        this.idPengajuan = String.format("PG%03d", i);
        i++;        
        this.penerima = penerima;
        this.bantuan = bantuan;
        
        this.statusPengajuan = "Menunggu";
    }
    
    public String getIdPengajuan() {
        return idPengajuan;
    }
    
    public String getStatusPengajuan() {
        return statusPengajuan;
    }
    
    public Bantuan getBantuan() {
        return bantuan;
    }
    
    public Penerima getPenerima() {
        return penerima;
    }
    
    public void setStatusPengajuan(String statusPengajuan) {
        this.statusPengajuan = statusPengajuan;
    }
    
    public void setPenerima(Penerima penerima) {
        this.penerima = penerima;
    }
    
    public void setBantuan(Bantuan bantuan) {
        this.bantuan = bantuan;
    }
    
    public void tampilData() {
        System.out.println("ID Pengajuan    : " + idPengajuan);
        System.out.println("Penerima        : " + penerima.getNama());
        System.out.println("Bantuan         : " + bantuan.getNamaBantuan());
        System.out.println("Status          : " + statusPengajuan);
    }
}
