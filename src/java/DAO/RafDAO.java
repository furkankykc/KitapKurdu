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
import Entity.Raf;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class RafDAO {
    
    	private Raf raf = null;
	private ArrayList<Raf> rafList = null;
	private DepoDAO dDao = new DepoDAO();
	public Raf get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from raf where id="+id);
			rs.next();
                            this.raf = new Raf(rs.getInt("id"),rs.getInt("numara"),dDao.get(rs.getInt("depo_id")));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.raf;
	}
	
	public ArrayList<Raf> list()  {
		this.rafList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from raf");
			while ( rs.next() ) {
				this.rafList.add(new Raf(rs.getInt("id"),rs.getInt("numara"),dDao.get(rs.getInt("depo_id"))));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.rafList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from raf where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Raf a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update raf set numara='"+a.getNumara() +"', depo_id='"+a.getDepo().getId()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Raf a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into raf (numara,depo_id) values ('"+a.getNumara()+"','"+a.getDepo().getId()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
