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
public class Dosya {
    private int id;
    private String adi;
    private String dosyaYolu;

    public Dosya(int id, String adi, String dosyaYolu) {
        this.id = id;
        this.adi = adi;
        this.dosyaYolu = dosyaYolu;
    }

    public Dosya(String adi, String dosyaYolu) {
        this.adi = adi;
        this.dosyaYolu = dosyaYolu;
    }

    public Dosya() {
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

    public String getDosyaYolu() {
        return dosyaYolu;
    }

    public void setDosyaYolu(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }

    @Override
    public String toString() {
        return "Dosya{" + "id=" + id + ", adi=" + adi + ", dosyaYolu=" + dosyaYolu + '}';
    }
    
}
