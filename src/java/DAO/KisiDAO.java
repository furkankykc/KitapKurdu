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
import Entity.Kisi;
import Entity.Depo;
import Entity.Grup;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class KisiDAO {
    
    	private Kisi kisi = null;
	private ArrayList<Kisi> kisiList = null;
	private DepoDAO depoDao = new DepoDAO();
        private GrupDAO gDao = new GrupDAO();
	public Kisi get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kisi where id="+id);
			rs.next();
			this.kisi = new Kisi(rs.getInt("id"),rs.getString("adi"),rs.getInt("tc"),depoDao.get(rs.getInt("depo_id")),gDao.getKisiGrup(rs.getInt("id")));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kisi;
	}
	
	public ArrayList<Kisi> list()  {
		this.kisiList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kisi");
			while ( rs.next() ) {
				this.kisiList.add(new Kisi(rs.getInt("id"),rs.getString("adi"),rs.getInt("tc"),depoDao.get(rs.getInt("depo_id")),gDao.getKisiGrup(rs.getInt("id"))));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kisiList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kisi where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Kisi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update kisi set adi='"+a.getAdi() +"', tc='"+a.getTc() +"', depo_id='"+a.getDepo().getId()+"' where id="+a.getId());
                        st.executeUpdate("delete from kisi_grup where kisi_id="+a.getId());
                        for(Grup g : a.getGrup()){
                            Statement st2 = con.createStatement();
                           st2.executeUpdate("insert into kisi_grup(kisi_id,grup_id) values(+"+a.getId()+",'"+g.getId()+"')");
                           
                        }
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Kisi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into kisi (adi,tc,depo_id) values ('"+a.getAdi()+"','"+a.getTc()+"','"+a.getDepo().getId()+"')",Statement.RETURN_GENERATED_KEYS);
                        
                        int kid= 0;
                        ResultSet rs = st.getGeneratedKeys();
                        if(rs.next()){
                            kid= rs.getInt(1);
                            
                        }
                        for(Grup g : a.getGrup()){
                            Statement st2 = con.createStatement();
                           st2.executeUpdate("insert into kisi_grup(kisi_id,grup_id) values(+"+kid+",'"+g.getId()+"')");
                           
                        }
                        
                        
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
