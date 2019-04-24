/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author furkankykc
 */
public class Kullanici {
    int id;
    String kullaniciAdi;
    String sifre;
    String adi;
    int type;

    public Kullanici( int id, String kullaniciAdi, String sifre, String adi,int type) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.adi = adi;
        this.id = id;
        this.type = type;
    }

    public Kullanici(String kullaniciAdi, String sifre, String adi,int type) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.adi = adi;
        this.type = type;
    }

    public Kullanici(String kullaniciAdi, String sifre,int type) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.type = type;
    }

    public Kullanici() {
    }
    

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    @Override
    public String toString() {
        return "Kullanici{" + "kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre + ", id=" + id + ", type=" + type + '}';
    }
    
}
