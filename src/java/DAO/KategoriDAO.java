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
import Entity.Kategori;
import Utility.ConnectionManager;
import java.sql.PreparedStatement;

/**
 *
 * @author KursadArslan
 */
public class KategoriDAO {
    
    	private Kategori kategori = null;
	private ArrayList<Kategori> kategoriList = null;
	
	public Kategori get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select * from kategori where id="+id);
                        rs.next();
			this.kategori=new Kategori (rs.getInt("id"),rs.getString("adi"));
			
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kategori;
	}
	
	public ArrayList<Kategori> list()  {
		this.kategoriList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
                    Statement st=con.createStatement();
	            ResultSet rs=st.executeQuery("select * from kategori");
	
			while ( rs.next() ) {
				this.kategoriList.add(new Kategori(rs.getInt("id"),rs.getString("adi")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kategoriList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
                    Statement st= con.createStatement();
	            st.executeUpdate("delete from kategori where id="+id);
                       
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	public void delete(String adi) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kategori where adi="+adi);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	public void update(Kategori a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                    Statement st = con.createStatement();
			st.executeUpdate("update kategori set adi='"+a.getAdi()+"' where id="+a.getId());
                     // st.executeUpdate("update kategori set adi ="+a.getAdi());
                         
                        
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Kategori a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into kategori (adi) values ('"+a.getAdi()+"')");
                    //st.executeUpdate("insert into kategori (adi) values "+a.getAdi());
			
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
