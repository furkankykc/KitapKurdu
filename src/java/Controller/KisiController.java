/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KisiDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Kisi;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="kisiController")
@SessionScoped
public class KisiController implements Serializable {

    private List<Kisi> kisiList;
    private KisiDAO kisiDao;
    private Kisi kisi;

    public KisiController() {
        this.kisiList = new ArrayList<Kisi>();
        this.kisiDao = new KisiDAO();
    }

    public List<Kisi> getaList() {
        this.kisiList = getaDao().list();
        return kisiList;
    }

    public KisiDAO getaDao() {
        if (this.kisiDao == null)
            this.kisiDao = new KisiDAO();
        return kisiDao;
    }

    public Kisi getKisi() {
        if(this.kisi == null)
            this.kisi = new Kisi();
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    
    public String create(){
        this.getaDao().create(this.kisi);
        clearForm();
        return "kisi";
    }
    
    public String delete(){
        this.getaDao().delete(this.kisi.getId());
        clearForm();
        return "kisi";
    }
    
    public String delete(Kisi kisi){
        this.getaDao().delete(kisi.getId());
        clearForm();
        return "kisi";
    }
    
    public String updateForm(Kisi kisi){
        this.kisi = kisi;
        
        return "kisi";
    }
    public void clearForm(){
        this.kisi = new Kisi();
        
    }
    public String update(){
        this.kisiDao.update(this.kisi);
        this.clearForm();
        return "kisi";
    }
    
    public String deleteConfirm(Kisi kisi){
        this.kisi = kisi;
        return "confirm_delete";
        
    }
 

}
