/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;

/**
 *
 * @author KursadArslan
 */
public class Kisi {
    private int id;
    private String adi;
    private int tc;
    private Depo depo;
    private List<Grup> grup;

    public Kisi(int id, String adi, int tc,Depo depoId,List<Grup> grup) {
        this.id = id;
        this.adi = adi;
        this.tc = tc;
        this.depo = depoId;
        this.grup = grup;
    }

    public Kisi(String adi, int tc,Depo depoId) {
        this.adi = adi;
        this.tc = tc;
        this.depo = depoId;
    }

    public Kisi() {
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

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public Depo getDepo() {
        return depo;
    }

    public void setDepo(Depo depo) {
        this.depo = depo;
    }

    public List<Grup> getGrup() {
        return grup;
    }

    public void setGrup(List<Grup> grup) {
        this.grup = grup;
    }

 
    @Override
    public String toString() {
        return "Kisi{" + "id=" + id + ", adi=" + adi + ", tc=" + tc + ", depoId=" + depo.getId() + '}';
    }
    
    
}
