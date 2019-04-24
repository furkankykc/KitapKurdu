/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.YayinEviDAO;
import Entity.YayinEvi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="yayinEviController")
@SessionScoped
public class YayinEviController implements Serializable {
    private List<YayinEvi> yayinEviList;
    private YayinEviDAO yayinEviDao;
    private YayinEvi yayinEvi;
     public YayinEviController() {
        this.yayinEviList = new ArrayList<YayinEvi>();
        this.yayinEviDao = new YayinEviDAO();
    }
    public List<YayinEvi> getaList() {
        this.yayinEviList = getaDao().list();
        return yayinEviList;
    }
public YayinEviDAO getaDao() {
        if (this.yayinEviDao == null)
            this.yayinEviDao = new YayinEviDAO();
        return yayinEviDao;
    }
   public YayinEvi getYayinEvi() {
        if(this.yayinEvi == null)
            this.yayinEvi = new YayinEvi();
        return yayinEvi;
    }
    public void setYayinEvi(YayinEvi yayinEvi) {
        this.yayinEvi = yayinEvi;
    }
    
    
    public String create(){
        this.getaDao().create(this.yayinEvi);
        clearForm();
        return "yayinEvi";
    }
    
    public String delete(){
        this.getaDao().delete(this.yayinEvi.getId());
        clearForm();
        return "yayinEvi";
    }
    
    public String delete(YayinEvi yayinEvi){
      /*  this.getaDao().delete(yayinEvi.getId());
        clearForm();
        return "yayinEvi";*/       
      this.yayinEvi = yayinEvi;
        return "confirm_delete";
        
    }
    
    public String updateForm(YayinEvi yayinEvi){
        this.yayinEvi = yayinEvi;
        
        return "yayinEvi";
    }
    public void clearForm(){
        this.yayinEvi = new YayinEvi();
        
    }
    public String update(){
        this.yayinEviDao.update(this.yayinEvi);
        this.clearForm();
        return "yayinEvi";
    }
    
    public String deleteConfirm(YayinEvi yayinEvi){
        this.yayinEvi = yayinEvi;
        return "confirm_delete";
        
    }
    
    
}
