/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DosyaDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import Entity.Dosya;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="dosyaController")
@SessionScoped
public class DosyaController implements Serializable {

    private List<Dosya> dosyaList;
    private DosyaDAO dosyaDao;
    private Dosya dosya;
    private Part file;
 
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
    
    public String getFileName(Part part)
    {
        for(String cd:part.getHeader("content-disposition").split(";"))
            if(cd.trim().startsWith("filename")){
                String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
                return filename;
            }
        return "";
                
    }
    
       public void upload()
    {
        try (InputStream input = file.getInputStream()) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
            String yol = "/resources/dosya";
            String webContentRoot = ec.getRealPath(yol);
            Path a = new File(webContentRoot, file.getSubmittedFileName()).toPath();
            Files.copy(input,a );
            this.dosya = new Dosya(file.getSubmittedFileName(),a.toAbsolutePath().toString());
            this.getaDao().create(this.dosya);
        }
        catch(Exception ex)
        {
            System.err.print(ex);
        }
    }
    public DosyaController() {
        this.dosyaList = new ArrayList<Dosya>();
        this.dosyaDao = new DosyaDAO();
    }

    public List<Dosya> getaList() {
        this.dosyaList = getaDao().list();
        return dosyaList;
    }

    public DosyaDAO getaDao() {
        if (this.dosyaDao == null)
            this.dosyaDao = new DosyaDAO();
        return dosyaDao;
    }

    public Dosya getDosya() {
        if(this.dosya == null)
            this.dosya = new Dosya();
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }
    
    public String create(){
        this.getaDao().create(this.dosya);
        clearForm();
        return "dosya";
    }
    
    public String delete(){
        this.getaDao().delete(this.dosya.getId());
        clearForm();
        return "dosya";
    }
    public String delete(Dosya dosya){
        this.getaDao().delete(dosya.getId());
        clearForm();
        return "dosya";
    }
    public String updateForm(Dosya dosya){
        this.dosya = dosya;
        
        return "dosya";
    }
    public void clearForm(){
        this.dosya = new Dosya();
        
    }
    public String update(){
        this.dosyaDao.update(this.dosya);
        this.clearForm();
        return "dosya";
    }
    
    public String deleteConfirm(Dosya dosya){
        this.dosya = dosya;
        return "confirm_delete";
        
    }
 

}
