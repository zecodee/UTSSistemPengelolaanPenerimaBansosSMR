/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */
public class Penerima {
    private String idPenerima;
    private String nik;
    private String nama;
    private String alamat;
    private double penghasilan;
    private static int i = 1;

    public Penerima(String nik, String nama, String alamat, double penghasilan) {
        this.idPenerima = String.format("P%03d", i);
        i++;
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.penghasilan = penghasilan;
    }

    public String getIdPenerima() {
        return idPenerima;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(double penghasilan) {
        this.penghasilan = penghasilan;
    }

    public void tampilData() {
        System.out.println("ID Penerima                 : " + idPenerima);
        System.out.println("NIK                         : " + nik);
        System.out.println("Nama                        : " + nama);
        System.out.println("Alamat                      : " + alamat);
        System.out.println("Penghasilan                 : Rp" + penghasilan);
    }
}
