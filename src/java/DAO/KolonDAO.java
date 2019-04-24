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
import Entity.Kolon;
import Entity.Raf;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class KolonDAO {
    
    	private Kolon kolon = null;
	private ArrayList<Kolon> kolonList = null;
        private RafDAO rDao = new RafDAO();
	
	public Kolon get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kolon where id="+id);
			rs.next();
                            this.kolon = new Kolon(rs.getInt("id"),rs.getInt("numara"),rDao.get(rs.getInt("raf_id")));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kolon;
	}
	
	public ArrayList<Kolon> list()  {
		this.kolonList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kolon");
			while ( rs.next() ) {
				this.kolonList.add(new Kolon(rs.getInt("id"),rs.getInt("numara"),rDao.get(rs.getInt("raf_id"))));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kolonList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kolon where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Kolon a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update kolon set numara='"+a.getNumara() +"', raf_id='"+a.getRaf().getId()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Kolon a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into kolon (numara,raf_id) values ('"+a.getNumara()+"','"+a.getRaf().getId()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
}
   
