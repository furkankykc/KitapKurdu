/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GrupDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Grup;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="grupController")
@SessionScoped
public class GrupController implements Serializable {

    private List<Grup> grupList;
    private GrupDAO grupDao;
    private Grup grup;

    public GrupController() {
        this.grupList = new ArrayList<Grup>();
        this.grupDao = new GrupDAO();
    }

    public List<Grup> getaList() {
        this.grupList = getaDao().list();
        return grupList;
    }

    public GrupDAO getaDao() {
        if (this.grupDao == null)
            this.grupDao = new GrupDAO();
        return grupDao;
    }

    public Grup getGrup() {
        if(this.grup == null)
            this.grup = new Grup();
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }
    
    public String create(){
        this.getaDao().create(this.grup);
        clearForm();
        return "grup";
    }
    
    public String delete(){
        this.getaDao().delete(this.grup.getId());
        clearForm();
        return "grup";
    }
    public String delete(Grup grup){
        this.getaDao().delete(grup.getId());
        clearForm();
        return "grup";
    }
    
    public String updateForm(Grup grup){
        this.grup = grup;
        
        return "grup";
    }
    public void clearForm(){
        this.grup = new Grup();
        
    }
    public String update(){
        this.grupDao.update(this.grup);
        this.clearForm();
        return "grup";
    }
    
    public String deleteConfirm(Grup grup){
        this.grup = grup;
        return "confirm_delete";
        
    }
 

}
