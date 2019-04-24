
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.Tur;
import Utility.ConnectionManager;

/**
 *
 * @author KursadArslan
 */
public class TurDAO {
    
    	private Tur tur = null;
	private ArrayList<Tur> turList = null;
	
	public Tur get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
                        
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tur where id="+id);
			rs.next();
			this.tur = new Tur(rs.getInt("id"),rs.getString("adi"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.tur;
	}
	
	public ArrayList<Tur> list()  {
		this.turList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tur");
			while ( rs.next() ) {
				this.turList.add(new Tur(rs.getInt("id"),rs.getString("adi")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
                    System.out.println(ex.getMessage());		
		}
		return this.turList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from tur where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Tur a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update tur set adi='"+a.getAdi()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Tur a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into tur (adi) values ('"+a.getAdi()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

	
}
   
