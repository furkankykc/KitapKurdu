/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KullaniciDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import Entity.Kullanici;
import Utility.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
/**
 *
 * @author KursadArslan
 */
@ManagedBean(name="kullaniciController")
@SessionScoped
public class KullaniciController implements Serializable {

    private List<Kullanici> kullaniciList;
    private KullaniciDAO kullaniciDao;
    private Kullanici kullanici;
    private String passConroll;
    private String message;

    public KullaniciController() {
        this.kullaniciList = new ArrayList<Kullanici>();
        this.kullaniciDao = new KullaniciDAO();
    }

    public List<Kullanici> getaList() {
        this.kullaniciList = getaDao().list();
        return kullaniciList;
    }

    public KullaniciDAO getaDao() {
        if (this.kullaniciDao == null)
            this.kullaniciDao = new KullaniciDAO();
        return kullaniciDao;
    }

    public Kullanici getKullanici() {
        if(this.kullanici == null)
            this.kullanici = new Kullanici();
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    public String create(){
        this.getaDao().create(this.kullanici);
        clearForm();
        return "kullanici";
    }
    
    public String delete(){
        this.getaDao().delete(this.kullanici.getId());
        clearForm();
        return "kullanici";
    }
    
    public String delete(Kullanici kullanici){
        this.getaDao().delete(kullanici.getId());
        clearForm();
        return "kullanici";
    }
    
    public String updateForm(Kullanici kullanici){
        this.kullanici = kullanici;
        
        return "kullanici";
    }
    public void clearForm(){
        this.kullanici = new Kullanici();
        
    }
    public String update(){
        this.kullaniciDao.update(this.kullanici);
        this.clearForm();
        return "kullanici";
    }
    
    public String deleteConfirm(Kullanici kullanici){
        this.kullanici = kullanici;
        return "confirm_delete";
        
    }

    public String getPassConroll() {
        return passConroll;
    }

    public String getMessage() {
        return message;
    }

    public void setPassConroll(String passConroll) {
        this.passConroll = passConroll;
    }
    public Boolean getType(){
 
        return SessionUtils.isAdmin();
    }
    public Boolean isLoggedin(){
 
        return SessionUtils.isLoggedin();
    }
    public String getUserId(){
         HttpSession session = SessionUtils.getSession();
         
         return session.getAttribute("userid").toString();
    }
    public String panel(){
        return "admin/index.xhtml";
    }
    public String site(){
        return "/index.xhtml";
    }
    public String login(){
        Kullanici kullanici = this.getaDao().get(this.kullanici.getKullaniciAdi());
        message ="";
        if(kullanici!=null){
            if(kullanici.getSifre().compareTo(this.kullanici.getSifre())==0){ 
                      Utility.SessionUtils.setUserId(kullanici);
                      return "/index.xhtml";
                      //giris yaptınız
            }
            else{
                
                message = "Şifrelen yanlış";
                //sifre yanlis
               return "";
            }
        }else{
            
                message = "Kullanıcı adın veya şifren yanlış";
            //kullanici adi sifre yanlis
        }
        
       return "";
    }
    public String logout(){
           HttpSession session = SessionUtils.getSession();
		session.invalidate();
                this.kullanici=null;
		return "/KitapKurdu/faces/index.xhtml";
        
    }
    public String register(){
        Kullanici kullanici = this.getaDao().get(this.kullanici.getKullaniciAdi());
        message = "";
         if(this.kullanici.getKullaniciAdi().compareTo("")!=0){
            
                if(this.kullanici.getSifre().compareTo(this.passConroll)==0 ){
                    if(kullanici==null){
                    if(this.kullanici.getSifre().compareTo("")!=0){

                            this.getaDao().create(this.kullanici);

                             return "login";

                    }else{
                            message = "Şifre kısmı boş olamaz";
                        }
                }else{
                  
                message = "Bu kullanıcı adı daha önceden alınmış";
                    // sifreler tutmuyor
                }
            }else{
  message = "Şifrelerin birbiriyle aynı değil";
                //bu kullanici adi daha önce alınmıs
            }
        }else{
            message = "Kullanici adi boş olamaz";
                }
        return "";
    }
    
}
