/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TurDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Tur;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="turController")
@SessionScoped
public class TurController implements Serializable {

    private List<Tur> turList;
    private TurDAO turDao;
    private Tur tur;

    public TurController() {
        this.turList = new ArrayList<Tur>();
        this.turDao = new TurDAO();
    }

    public List<Tur> getaList() {
        this.turList = getaDao().list();
        return turList;
    }

    public TurDAO getaDao() {
        if (this.turDao == null)
            this.turDao = new TurDAO();
        return turDao;
    }

    public Tur getTur() {
        if(this.tur == null)
            this.tur = new Tur();
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }
    
    public String create(){
        this.getaDao().create(this.tur);
        clearForm();
        return "tur";
    }
    
    public String delete(){
        this.getaDao().delete(this.tur.getId());
        clearForm();
        return "tur";
    }
    public String delete(Tur tur){
        this.getaDao().delete(tur.getId());
        clearForm();
        return "tur";
    }
    
    public String updateForm(Tur tur){
        this.tur = tur;
        
        return "tur";
    }
    public void clearForm(){
        this.tur = new Tur();
        
    }
    public String update(){
        this.turDao.update(this.tur);
        this.clearForm();
        return "tur";
    }
    
    public String deleteConfirm(Tur tur){
        this.tur = tur;
        return "confirm_delete";
        
    }
 

}
