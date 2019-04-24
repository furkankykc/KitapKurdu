/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author KursadArslan
 */


public class Depo {
    private int id;
    private String adi;
    private String adres;
    private int kapasite;

    public Depo(int id, String adi, String adres, int kapasite) {
        
        this.id = id;
        this.adi = adi;
        this.adres = adres;
        this.kapasite = kapasite;
    }

    public Depo(String adi, String adres, int kapasite) {
        this.adi = adi;
        this.adres = adres;
        this.kapasite = kapasite;
    }

    public Depo() {
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    @Override
    public String toString() {
        return "Depo{" + "id=" + id + ", adi=" + adi + ", adres=" + adres + ", kapasite=" + kapasite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Depo other = (Depo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
