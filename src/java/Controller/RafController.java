/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RafDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Raf;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="rafController")
@SessionScoped
public class RafController implements Serializable {

    private List<Raf> rafList;
    private RafDAO rafDao;
    private Raf raf;

    public RafController() {
        this.rafList = new ArrayList<Raf>();
        this.rafDao = new RafDAO();
    }

    public List<Raf> getaList() {
        this.rafList = getaDao().list();
        return rafList;
    }

    public RafDAO getaDao() {
        if (this.rafDao == null)
            this.rafDao = new RafDAO();
        return rafDao;
    }

    public Raf getRaf() {
        if(this.raf == null)
            this.raf = new Raf();
        return raf;
    }

    public void setRaf(Raf raf) {
        this.raf = raf;
    }
    
    public String create(){
        this.getaDao().create(this.raf);
        clearForm();
        return "raf";
    }
    
    public String delete(){
        this.getaDao().delete(this.raf.getId());
        clearForm();
        return "raf";
    }
    
    public String delete(Raf raf){
        this.getaDao().delete(raf.getId());
        clearForm();
        return "raf";
    }
    
    public String updateForm(Raf raf){
        this.raf = raf;
        
        return "raf";
    }
    public void clearForm(){
        this.raf = new Raf();
        
    }
    public String update(){
        this.rafDao.update(this.raf);
        this.clearForm();
        return "raf";
    }
    
    public String deleteConfirm(Raf raf){
        this.raf = raf;
        return "confirm_delete";
        
    }
 

}
