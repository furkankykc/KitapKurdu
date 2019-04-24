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
import Entity.YayinEvi;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class YayinEviDAO {
    
    	private YayinEvi yayin_evi = null;
	private ArrayList<YayinEvi> yayin_eviList = null;
	
	public YayinEvi get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yayin_evi where id="+id);
			rs.next();
			this.yayin_evi = new YayinEvi(rs.getInt("id"),rs.getString("adi"),rs.getString("adres"),rs.getString("aciklama"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yayin_evi;
	}
	
	public ArrayList<YayinEvi> list()  {
		this.yayin_eviList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yayin_evi");
			while ( rs.next() ) {
				this.yayin_eviList.add(new YayinEvi(rs.getInt("id"),rs.getString("adi"),rs.getString("adres"),rs.getString("aciklama")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yayin_eviList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from yayin_evi where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(YayinEvi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update yayin_evi set adi='"+a.getAdi() +"', adres='"+a.getAdres()+"', aciklama = '"+a.getAciklama()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(YayinEvi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into yayin_evi (adi,adres,aciklama) values ('"+a.getAdi()+"','"+a.getAdres()+"','"+a.getAciklama()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
