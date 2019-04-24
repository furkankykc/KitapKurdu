/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.YazarDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Yazar;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="yazarController")
@SessionScoped
public class YazarController implements Serializable {

    private List<Yazar> yazarList;
    private YazarDAO yazarDao;
    private Yazar yazar;

    public YazarController() {
        this.yazarList = new ArrayList<Yazar>();
        this.yazarDao = new YazarDAO();
    }

    public List<Yazar> getaList() {
        this.yazarList = getaDao().list();
        return yazarList;
    }

    public YazarDAO getaDao() {
        if (this.yazarDao == null)
            this.yazarDao = new YazarDAO();
        return yazarDao;
    }

    public Yazar getYazar() {
        if(this.yazar == null)
            this.yazar = new Yazar();
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
    }
    
    public String create(){
        this.getaDao().create(this.yazar);
        clearForm();
        return "yazar";
    }
    
    public String delete(){
        this.getaDao().delete(this.yazar.getId());
        clearForm();
        return "yazar";
    }
    
    public String delete(Yazar yazar){
        this.getaDao().delete(yazar.getId());
        clearForm();
        return "yazar";
    }
    
    public String updateForm(Yazar yazar){
        this.yazar = yazar;
        
        return "yazar";
    }
    public void clearForm(){
        this.yazar = new Yazar();
        
    }
    public String update(){
        this.yazarDao.update(this.yazar);
        this.clearForm();
        return "yazar";
    }
    
    public String deleteConfirm(Yazar yazar){
        this.yazar = yazar;
        return "confirm_delete";
        
    }
 

}
