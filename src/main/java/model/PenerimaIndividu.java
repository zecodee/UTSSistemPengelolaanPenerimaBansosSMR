/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */
public class PenerimaIndividu extends Penerima {
    private String pekerjaan;
    private String statusRumah;

    public PenerimaIndividu(String nik, String nama, String alamat, 
            double penghasilan, String pekerjaan, String statusRumah) {

        super(nik, nama, alamat, penghasilan);
        this.pekerjaan = pekerjaan;
        this.statusRumah = statusRumah;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getStatusRumah() {
        return statusRumah;
    }

    public void setStatusRumah(String statusRumah) {
        this.statusRumah = statusRumah;
    }

    public void tampilDataIndividu() {
        tampilData();
        System.out.println("Tipe                        : Individu");        
        System.out.println("Pekerjaan                   : " + pekerjaan);
        System.out.println("Status Rumah                : " + statusRumah);
    }
}
