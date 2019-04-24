/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DepoDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Depo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="depoController")
@SessionScoped
public class DepoController implements Serializable {

    private List<Depo> depoList;
    private DepoDAO depoDao;
    private Depo depo;

    public DepoController() {
        this.depoList = new ArrayList<Depo>();
        this.depoDao = new DepoDAO();
    }

    public List<Depo> getaList() {
        this.depoList = getaDao().list();
        return depoList;
    }

    public DepoDAO getaDao() {
        if (this.depoDao == null)
            this.depoDao = new DepoDAO();
        return depoDao;
    }

    public Depo getDepo() {
        if(this.depo == null)
            this.depo = new Depo();
        return depo;
    }

    public void setDepo(Depo depo) {
        this.depo = depo;
    }
    
    public String create(){
        this.getaDao().create(this.depo);
        clearForm();
        return "depo";
    }
    
    public String delete(){
        this.getaDao().delete(this.depo.getId());
        clearForm();
        return "depo";
    }
    public String delete(Depo depo){
        this.getaDao().delete(depo.getId());
        clearForm();
        return "depo";
    }
    
    public void updateForm(Depo depo){
        this.depo = depo;
    }
    public void clearForm(){
        this.depo = new Depo();
        
    }
    public String update(){
        this.depoDao.update(this.depo);
        this.clearForm();
        return "depo";
    }
    
    public String deleteConfirm(Depo depo){
        this.depo = depo;
        return "confirm_delete";
        
    }
 

}
