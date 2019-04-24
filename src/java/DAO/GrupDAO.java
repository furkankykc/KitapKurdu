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
import Entity.Grup;
import Entity.Kisi;
import Utility.ConnectionManager;
import java.util.List;

/**
 *
 * @author KursadArslan
 */
public class GrupDAO {
    
    	private Grup grup = null;
	private ArrayList<Grup> grupList = null;
	
	public Grup get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from grup where id="+id);
			rs.next();
			this.grup = new Grup(rs.getInt("id"),rs.getString("adi"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.grup;
	}
	
	public ArrayList<Grup> list()  {
		this.grupList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from grup");
			while ( rs.next() ) {
				this.grupList.add(new Grup(rs.getInt("id"),rs.getString("adi")));
				System.out.println("-----------------");
			}
                        con.close();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.grupList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from grup where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Grup a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update grup set adi='"+a.getAdi()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Grup a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into grup (adi) values ('"+a.getAdi()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	public  List<Grup> getKisiGrup(int k){
            this.grupList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kisi_grup where kisi_id="+k);
			while ( rs.next() ) {
				this.grupList.add(this.get(rs.getInt("grup_id")));
				System.out.println("-----------------");
			}
                        con.close();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.grupList;
	}
        
}
   
