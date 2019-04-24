/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DosyaDAO;
import DAO.YayinDAO;
import Entity.Dosya;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Yayin;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
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
@ManagedBean(name="yayinController")
@SessionScoped
public class YayinController implements Serializable {

    private List<Yayin> yayinList;
    private YayinDAO yayinDao;
    private Yayin yayin;
    private Part file;
    private DosyaDAO dosyaDao;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public YayinController() {
        this.yayinList = new ArrayList<Yayin>();
        this.yayinDao = new YayinDAO();
    }

    public void next(){
        if(page<pageCount)
            this.page++;
    }
    public void previous(){
        if(page>1)
            this.page--;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getaDao().count()/(double)this.pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
 
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
    
   
    
       public void upload()
    {
        try (InputStream input = file.getInputStream()) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
            String yol = "/resources/dosya/kapak/";
            String webContentRoot = ec.getRealPath(yol);
                       Path a = new File(webContentRoot, file.getSubmittedFileName()).toPath();
            if(!Files.exists(a))
                Files.copy(input,a );
            
            this.yayin.setDosya(new Dosya(file.getSubmittedFileName(),a.toAbsolutePath().toString()));
        }
        catch(Exception ex)
        {
            System.err.print(ex);
        }
    }
    
    public List<Yayin> getaList() {
         this.yayinList = getaDao().list(page,pageSize);
        return yayinList;
    }

    public YayinDAO getaDao() {
        if (this.yayinDao == null)
            this.yayinDao = new YayinDAO();
        return yayinDao;
    }

    public Yayin getYayin() {
        if(this.yayin == null)
            this.yayin = new Yayin();
        return yayin;
    }

    public void setYayin(Yayin yayin) {
        this.yayin = yayin;
    }
    
    public String create(){
        
        this.upload();
        this.getaDao().create(this.yayin);
        clearForm();
        return "yayin";
    }
    
    public String delete(){
        this.getaDao().delete(this.yayin.getId());
        clearForm();
        return "yayin";
    }

    public String delete(Yayin yayin){
        this.getaDao().delete(yayin.getId());
        clearForm();
        return "yayin";
    }
    
    
    public String updateForm(Yayin yayin){
        this.yayin = yayin;
        return "yayin";
    }
    public void clearForm(){
        this.yayin = new Yayin();
        
    }
    public String update(){
        this.upload();
        this.yayinDao.update(this.yayin);
        this.clearForm();
        return "yayin";
    }
    
    public String deleteConfirm(Yayin yayin){
        this.yayin = yayin;
        return "confirm_delete";
        
    }
 

}
