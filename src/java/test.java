
import Controller.KullaniciController;
import DAO.DepoDAO;
import DAO.GrupDAO;
import DAO.KategoriDAO;
import DAO.KisiDAO;
import DAO.KolonDAO;
import DAO.KullaniciDAO;
import DAO.TurDAO;
import DAO.YayinDAO;
import DAO.YayinEviDAO;
import DAO.YazarDAO;
import Entity.Depo;
import Entity.Grup;
import Entity.Kategori;
import Entity.Kullanici;
import Entity.Kolon;
import Entity.Raf;
import Entity.Tur;
import Entity.Yayin;
import Entity.YayinEvi;
import Entity.Yazar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KursadArslan
 */
public class test {
    
    
    public static void main(String args[]){
     
       /* //YayinDAO yDAO = new YayinDAO();
       // YayinEviDAO yeDao = new YayinEviDAO();
       // TurDAO tDao = new TurDAO();
        KategoriDAO kDao = new  KategoriDAO();
        KullaniciDAO kdao = new KullaniciDAO();
        YazarDAO yazarDao = new YazarDAO();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        //yazarDao.create(new Yazar("furkan","ankara",new java.sql.Date(new java.util.Date().getTime()),"biyografi"));
        YayinDAO as = new YayinDAO();
        yazarDao.delete(3);
        as.create(new Yayin("asd", yazarDao.get(1), 123,new KategoriDAO().get(1), new TurDAO().get(1), new YayinEviDAO().get(1), new KolonDAO().get(1), 123));
   //     kdao.create(new Kullanici("root","1234","ADAMİN"));
        System.err.println(kdao.get("root"));
       // yeDao.create(new YayinEvi("yeni_yayinevi","malatya", "acıklama"));
        //tDao.create(new Tur("yeni_tür"));
        //kDao.create(new Kategori("yeni_bir_kategori"));
*/
       KullaniciDAO kdao = new KullaniciDAO();
        kdao.create(new Kullanici("root","1234","furkankykc",1));
       
    System.out.println();
}
    
}
                