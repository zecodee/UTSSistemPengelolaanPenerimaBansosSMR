/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */
public class Bantuan {
    private final String idBantuan;
    private String namaBantuan;
    private double nominal;
    private int kuota;
    private static int i = 1;
    
    public Bantuan(String namaBantuan, double nominal, int kuota) {
        this.idBantuan = String.format("B%03d", i);
        i++;
        this.namaBantuan = namaBantuan;
        this.nominal = nominal;
        this.kuota = kuota;
    }
    
    public String getIdBantuan() {
        return idBantuan;
    }

    public String getNamaBantuan() {
        return namaBantuan;
    }

    public double getNominal() {
        return nominal;
    }

    public int getKuota() {
        return kuota;
    }
    
    public void setNamaBantuan(String namaBantuan) {
        this.namaBantuan = namaBantuan;
    }
    
    public void setNominal(double nominal) {
        if (nominal > 0) {
            this.nominal = nominal;
        }
    }

    public void setKuota(int kuota) {
        if (kuota >= 0) {
            this.kuota = kuota;
        }
    }
    
    public void kurangiKuota() {
        if (kuota > 0) {
            kuota--;
        }
    }
    
    public void tampilData() {
        System.out.println("ID Bantuan      : " + idBantuan);
        System.out.println("Nama Bantuan    : " + namaBantuan);
        System.out.println("Nominal         : Rp. " + nominal);
        System.out.println("Kuota           : " + kuota);
    }
}
