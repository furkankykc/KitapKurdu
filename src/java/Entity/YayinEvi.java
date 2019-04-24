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
public class YayinEvi {
    private int id;
    private String adi;
    private String adres;
    private String aciklama;

    public YayinEvi(int id, String adi, String adresi, String aciklama) {
        this.id = id;
        this.adi = adi;
        this.adres = adresi;
        this.aciklama = aciklama;
    }

    public YayinEvi(String adi, String adres, String aciklama) {
        this.adi = adi;
        this.adres = adres;
        this.aciklama = aciklama;
    }

    public YayinEvi() {
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

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final YayinEvi other = (YayinEvi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "YayinEvi{" + "id=" + id + ", adi=" + adi + ", adresi=" + adres + ", aciklama=" + aciklama + '}';
    }
    
    
    
}
