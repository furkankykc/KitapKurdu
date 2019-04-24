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
import Entity.Depo;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class DepoDAO {
    
    	private Depo depo = null;
	private ArrayList<Depo> depoList = null;
	
        
	public Depo get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from depo where id="+id);
			rs.next();
			this.depo = new Depo(rs.getInt("id")
                                ,rs.getString("adi")
                                ,rs.getString("adres")
                                ,rs.getInt("kapasite"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.depo;
	}
	
	public ArrayList<Depo> list()  {
		this.depoList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from depo");
			while ( rs.next() ) {
				this.depoList.add(new Depo(rs.getInt("id"),rs.getString("adi"),rs.getString("adres"),rs.getInt("kapasite")));
				System.out.println("-----------------");
			}
                        con.close();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
       
		return this.depoList;
        }
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from depo where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
        public void delete(String adi) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from depo where adi="+adi);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	public void update(Depo a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update depo set adi='"+a.getAdi() +"', adres='"+a.getAdres()+"', kapasite = '"+a.getKapasite()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Depo a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into depo (adi,adres,kapasite) values ('"+a.getAdi()+"','"+a.getAdres()+"','"+a.getKapasite()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
//to-do statementleri prepared statement yap  
        //layoutları düzelt
            // index sayfasını ayarla
	
}
   
