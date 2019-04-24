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
public class Yayin {
    private int id;
    private String adi;
    private Yazar yazar;
    private int sayfaSayisi;
    private Kolon kolon;
    private int adet;
    private YayinEvi yayinEvi;
    private Tur tur;
    private Kategori kategori;
    private Dosya dosya;
    

    
    
    public Yayin(int id, String adi,Yazar yazar, int sayfaSayisi, Kategori kategori, Tur tur, YayinEvi yayinEvi, Kolon kolon, int adet,Dosya dosya) {
        this.id = id;
        this.adi = adi;
        this.yazar=yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.kategori = kategori;
        this.tur = tur;
        this.yayinEvi = yayinEvi;
        this.kolon = kolon;
        this.adet = adet;
        this.dosya = dosya;
    }
    public Yayin(String adi,Yazar yazar, int sayfaSayisi, Kategori kategori, Tur tur, YayinEvi yayinEvi, Kolon kolon, int adet,Dosya dosya) {
        this.adi = adi;
        this.yazar=yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.kategori = kategori;
        this.tur = tur;
        this.yayinEvi = yayinEvi;
        this.kolon = kolon;
        this.adet = adet;
        this.dosya = dosya;
    }
    
    

    public Yayin() {
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
    public Yazar getYazar(){
    return yazar;
    }
    public void setYazar(Yazar yazar){
    this.yazar=yazar;
    }
    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        if(sayfaSayisi<0)
        {
        } 
        else
               this.sayfaSayisi = sayfaSayisi;
    }

    public Kolon getKolon() {
        return kolon;
    }

    public void setKolon(Kolon kolon) {
        this.kolon = kolon;
    }


    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

  
    public YayinEvi getYayinEvi() {
        return yayinEvi;
    }

    public void setYayinEvi(YayinEvi yayinEvi) {
        this.yayinEvi = yayinEvi;
    }

    public Tur getTur() {
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Yayin other = (Yayin) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Dosya getDosya() {
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }
    
    

    @Override
    public String toString() {
        return "Yayin{" + "id=" + id + ", adi=" + adi +"yazarId="+yazar.getId()+ ", sayfaSayisi=" + sayfaSayisi + ", kategoriId=" + kategori.getId() + ", turId=" + tur.getId() + ", yayinEviId=" + yayinEvi.getId() + ", kolon=" + kolon.getId() + ", adet=" + adet +", kapak="+dosya.getAdi() +'}';
 
    }
   
    
    
}
