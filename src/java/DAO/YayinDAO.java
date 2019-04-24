/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.Yayin;
import Utility.ConnectionManager;
import java.sql.PreparedStatement;

/**
 *
 * @author KursadArslan
 */
public class YayinDAO {
    
    	private Yayin yayin = null;
	private ArrayList<Yayin> yayinList = null;
        private YazarDAO yaDao=new YazarDAO();
        private KategoriDAO kDao = new KategoriDAO();
        private YayinEviDAO yeDao =new YayinEviDAO();
        private KolonDAO kolonDao = new KolonDAO();
        private TurDAO tDao = new TurDAO();
        private DosyaDAO dDao = new DosyaDAO();
	
	public Yayin get(int id) {
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from yayin where id=?";
		try {
                        
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			this.yayin = new Yayin(rs.getInt("id")
                                ,rs.getString("adi")
                                ,yaDao.get(rs.getInt("yazar_id"))
                                ,rs.getInt("sayfa_sayisi")
                                ,kDao.get(rs.getInt("kategori_id"))
                                ,tDao.get(rs.getInt("tur_id"))
                                ,yeDao.get(rs.getInt("yayin_evi_id"))
                                ,kolonDao.get(rs.getInt("kolon_id"))
                                ,rs.getInt("adet")
                                ,dDao.get(rs.getInt("kapak_id")));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yayin;
	}
	
	public ArrayList<Yayin> list()  {
		this.yayinList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yayin");
			while ( rs.next() ) {
				this.yayinList.add(new Yayin(
                                        rs.getInt("id")
                                        ,rs.getString("adi")
                                        ,yaDao.get(rs.getInt("yazar_id"))
                                        ,rs.getInt("sayfa_sayisi")
                                        ,kDao.get(rs.getInt("kategori_id"))
                                        ,tDao.get(rs.getInt("tur_id"))
                                        ,yeDao.get(rs.getInt("yayin_evi_id"))
                                        ,kolonDao.get(rs.getInt("kolon_id"))
                                        ,rs.getInt("adet")
                                        ,dDao.get(rs.getInt("kapak_id"))
                                        ));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yayinList;
	}
        public int count(){
            int count=0;
            Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(id) as a_count from yayin");
			rs.next();
                        count=rs.getInt("a_count");
                        
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
            return count;
        }
        public ArrayList<Yayin> list(int page,int pageSize)  {
		this.yayinList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
                int start = (page-1)*pageSize;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yayin order by id asc limit "+start+","+pageSize);
			while ( rs.next() ) {
				this.yayinList.add(new Yayin(
                                        rs.getInt("id")
                                        ,rs.getString("adi")
                                        ,yaDao.get(rs.getInt("yazar_id"))
                                        ,rs.getInt("sayfa_sayisi")
                                        ,kDao.get(rs.getInt("kategori_id"))
                                        ,tDao.get(rs.getInt("tur_id"))
                                        ,yeDao.get(rs.getInt("yayin_evi_id"))
                                        ,kolonDao.get(rs.getInt("kolon_id"))
                                        ,rs.getInt("adet")
                                        ,dDao.get(rs.getInt("kapak_id"))
                                        ));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yayinList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from yayin where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Yayin a) {
		Connection con = ConnectionManager.getConnection();
		int dosya_id = dDao.create(a.getDosya());
                a.getDosya().setId(dosya_id);
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update yayin set adi='"+a.getAdi()+"', sayfa_sayisi="+a.getSayfaSayisi()+", kategori_id="+a.getKategori().getId()+", tur_id="+a.getTur().getId()+",yayin_evi_id="+a.getYayinEvi().getId()+", kolon_id="+a.getKolon().getId()+", adet="+a.getAdet()+", kapak_id="+a.getDosya().getId()+" where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Yayin a) {
		Connection con = ConnectionManager.getConnection();
                int dosya_id = dDao.create(a.getDosya());
                a.getDosya().setId(dosya_id);
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into yayin (adi,sayfa_sayisi,kategori_id,tur_id,yayin_evi_id,kolon_id,adet,yazar_id,kapak_id) values ('"+a.getAdi()+"','"+a.getSayfaSayisi()+"','"+a.getKategori().getId()+"','"+a.getTur().getId()+"','"+a.getYayinEvi().getId()+"','"+a.getKolon().getId()+"','"+a.getAdet()+"','"+a.getYazar().getId()+"','"+a.getDosya().getId()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
