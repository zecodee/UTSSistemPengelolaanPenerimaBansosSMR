/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */
public class PenerimaKeluarga extends Penerima {
    private int anggotaKeluarga;
    private int jumlahTanggungan;
    
    public PenerimaKeluarga (String nik, String nama, String alamat, double penghasilan, int anggotaKeluarga, int jumlahTanggungan) {
        super (nik, nama, alamat, penghasilan);
        
        this.anggotaKeluarga = anggotaKeluarga;
        this.jumlahTanggungan = jumlahTanggungan;
    }
    
    public int getAnggotaKeluarga() {
        return anggotaKeluarga;
    }
    
    public void setAnggotaKeluarga (int anggotaKeluarga) {
        this.anggotaKeluarga = anggotaKeluarga;
    }

    public int getJumlahTanggungan() {
        return jumlahTanggungan;
    }
    
    public void setJumlahTanggungan (int jumlahTanggungan) {
        this.jumlahTanggungan = jumlahTanggungan;
    }    
    
    public void tampilDataKeluarga() {
        tampilData();
        System.out.println("Tipe                        : Keluarga");        
        System.out.println("Jumlah Anggota Keluarga     : " + anggotaKeluarga);
        System.out.println("Jumlah Tanggungan           : " + jumlahTanggungan);
    }
}
