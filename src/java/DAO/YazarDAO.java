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
import Entity.Yazar;
import Utility.ConnectionManager;
import java.sql.PreparedStatement;

/**
 *
 * @author KursadArslan
 */
public class YazarDAO {
    
    	private Yazar yazar = null;
	private ArrayList<Yazar> yazarList = null;
	
	public Yazar get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yazar where id="+id);
			rs.next();
			this.yazar = new Yazar(rs.getInt("id"),rs.getString("adi"),rs.getString("dogum_yeri"),rs.getDate("dogum_tarihi"),rs.getString("biyografi"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yazar;
	}
	
	public ArrayList<Yazar> list()  {
		this.yazarList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yazar");
			while ( rs.next() ) {
				this.yazarList.add(new Yazar(rs.getInt("id"),rs.getString("adi"),rs.getString("dogum_yeri"),rs.getDate("dogum_tarihi"),rs.getString("biyografi")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yazarList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from yazar where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Yazar a) {
		Connection con = ConnectionManager.getConnection();
		String sql = "update yazar set adi=? ,dogum_yeri=?, dogum_tarihi = ?, biyografi=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,a.getAdi());
                        ps.setString(2, a.getDogumYeri());
                        ps.setDate(3, new java.sql.Date(a.getDogumTarihi().getTime()));
                        ps.setString(4, a.getBiyografi());
                        ps.setInt(5, a.getId());
                        ps.executeUpdate();
        } catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Yazar a) {
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into yazar (adi,dogum_tarihi,dogum_yeri,biyografi) values(?,?,?,?)";
                
		try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,a.getAdi());
                        ps.setDate(2,new java.sql.Date(a.getDogumTarihi().getTime()));
                        ps.setString(3,a.getDogumYeri());
                        ps.setString(4,a.getBiyografi());
                        ps.executeUpdate();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
