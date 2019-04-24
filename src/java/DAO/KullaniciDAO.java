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
import Entity.Kullanici;
import Utility.ConnectionManager;
import java.sql.PreparedStatement;

/**
 *
 * @author KursadArslan
 */
public class KullaniciDAO {
    
    	private Kullanici kullanici = null;
	private ArrayList<Kullanici> kullaniciList = null;
	
        
	public Kullanici get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kullanici where id="+id);
			rs.next();
			this.kullanici = new Kullanici(rs.getInt("id")
                                ,rs.getString("kullanici_adi")
                                ,rs.getString("sifre")
                                ,rs.getString("adi")
                                ,rs.getInt("type")
                        );
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kullanici;
	}
	
        public Kullanici get(String kullaniciAdi) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kullanici where kullanici_adi='"+kullaniciAdi+"'");
			rs.next();
			this.kullanici = new Kullanici(rs.getInt("id")
                                ,rs.getString("kullanici_adi")
                                ,rs.getString("sifre")
                                ,rs.getString("adi")
                                ,rs.getInt("type")
                        );
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kullanici;
	}
	
	public ArrayList<Kullanici> list()  {
		this.kullaniciList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kullanici");
			while ( rs.next() ) {
				this.kullaniciList.add(
                                        new Kullanici(
                                                rs.getInt("id")
                                                ,rs.getString("kullanici_adi")
                                                ,rs.getString("sifre")
                                                ,rs.getString("adi")
                                                ,rs.getInt("type")
                                                    ));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
       
		return this.kullaniciList;
        }
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kullanici where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
        public void delete(String adi) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kullanici where kullanici_adi="+adi);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	public void update(Kullanici a) {
		Connection con = ConnectionManager.getConnection();
		String sql = "update kullanici set kullanici_adi=?, sifre=? , adi = ?, type=? where id=? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, a.getKullaniciAdi());
                        ps.setString(2, a.getSifre());
                        ps.setString(3, a.getAdi());
                        ps.setInt(4, a.getType());
                        ps.setInt(5, a.getId());
                        ps.executeUpdate();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Kullanici a) {
		Connection con = ConnectionManager.getConnection();
		
                String sql = "insert into kullanici (kullanici_adi,sifre,adi,type) values (?,?,?,?)";
		try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, a.getKullaniciAdi());
                        ps.setString(2, a.getSifre());
                        ps.setString(3, a.getAdi());
                        ps.setInt(4, a.getType());
			ps.executeUpdate();
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
