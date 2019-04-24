/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KategoriDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Kategori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="kategoriController")
@SessionScoped
public class KategoriController implements Serializable {

    private List<Kategori> kategoriList;
    private KategoriDAO kategoriDao;
    private Kategori kategori;

    public KategoriController() {
        this.kategoriList = new ArrayList<Kategori>();
        this.kategoriDao = new KategoriDAO();
    }

    public List<Kategori> getaList() {
        this.kategoriList = getaDao().list();
        return kategoriList;
    }

    public KategoriDAO getaDao() {
        if (this.kategoriDao == null)
            this.kategoriDao = new KategoriDAO();
        return kategoriDao;
    }

    public Kategori getKategori() {
        if(this.kategori == null)
            this.kategori = new Kategori();
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
    
    public String create(){
        this.getaDao().create(this.kategori);
        clearForm();
        return "kategori";
    }
    
    public String delete(){
        this.getaDao().delete(this.kategori.getId());
        clearForm();
        return "kategori";
    }
    public String delete(Kategori kategori){
        this.getaDao().delete(kategori.getId());
        clearForm();
        return "kategori";
    }
    
    public String updateForm(Kategori kategori){
        this.kategori = kategori;
        
        return "kategori";
    }
    public void clearForm(){
        this.kategori = new Kategori();
        
    }
    public String update(){
        this.kategoriDao.update(this.kategori);
        this.clearForm();
        return "kategori";
    }
    
    public String deleteConfirm(Kategori kategori){
        this.kategori = kategori;
        return "confirm_delete";
        
    }
 

}
