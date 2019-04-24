/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author KursadArslan
 */
public class Yazar {
 
    private int id;
    private String adi;
    private String dogumYeri;
    private Date dogumTarihi;
    private String biyografi;

    public Yazar(int id, String adi, String dogumYeri, Date dogumTarihi, String biyografi) {
        this.id = id;
        this.adi = adi;
        this.dogumYeri = dogumYeri;
        this.dogumTarihi = dogumTarihi;
        this.biyografi = biyografi;
    }

    public Yazar(String adi, String dogumYeri, Date dogumTarihi, String biyografi) {
        this.adi = adi;
        this.dogumYeri = dogumYeri;
        this.dogumTarihi = dogumTarihi;
        this.biyografi = biyografi;
    }

    public Yazar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getBiyografi() {
        return biyografi;
    }

    public void setBiyografi(String biyografi) {
        this.biyografi = biyografi;
    }

    @Override
    public String toString() {
        return "Yazar{" + "id=" + id + ", adi=" + adi + ", dogumYeri=" + dogumYeri + ", dogumTarihi=" + dogumTarihi + ", biyografi=" + biyografi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Yazar other = (Yazar) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
