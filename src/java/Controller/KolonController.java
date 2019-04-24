/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KolonDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Kolon;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="kolonController")
@SessionScoped
public class KolonController implements Serializable {

    private List<Kolon> kolonList;
    private KolonDAO kolonDao;
    private Kolon kolon;

    public KolonController() {
        this.kolonList = new ArrayList<Kolon>();
        this.kolonDao = new KolonDAO();
    }

    public List<Kolon> getaList() {
        this.kolonList = getaDao().list();
        return kolonList;
    }

    public KolonDAO getaDao() {
        if (this.kolonDao == null)
            this.kolonDao = new KolonDAO();
        return kolonDao;
    }

    public Kolon getKolon() {
        if(this.kolon == null)
            this.kolon = new Kolon();
        return kolon;
    }

    public void setKolon(Kolon kolon) {
        this.kolon = kolon;
    }
    
    public String create(){
        this.getaDao().create(this.kolon);
        clearForm();
        return "kolon";
    }
    
    public String delete(){
        this.getaDao().delete(this.kolon.getId());
        clearForm();
        return "kolon";
    }
    
    public String delete(Kolon kolon){
        this.getaDao().delete(kolon.getId());
        clearForm();
        return "kolon";
    }
    
    public String updateForm(Kolon kolon){
        this.kolon = kolon;
        
        return "kolon";
    }
    public void clearForm(){
        this.kolon = new Kolon();
        
    }
    public String update(){
        this.kolonDao.update(this.kolon);
        this.clearForm();
        return "kolon";
    }
    
    public String deleteConfirm(Kolon kolon){
        this.kolon = kolon;
        return "confirm_delete";
        
    }
 

}
