package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "scott";
			String dbPassword ="tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public String getDate() {
		String query = "select now()";
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(1);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ""; //DB ����
	}
	

	public int getNext() {
		String query = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt(1)+1;
				
			}
			return 1; //���������� ù��° �Խù��� ����������
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // ����������
	}
	
	public int write(String bbsTitle, String userID ,String bbsContent) {
		String query = "INSERT INTO BBS VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5,bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate(); //���������� ù��° �Խù��� ����������
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // ����������
	}
	
	public ArrayList<Bbs> getlist(int pageNumber){
		String query = "SELECT FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,getNext() - (pageNumber-1)*10 );
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
			}
			return ; //���������� ù��° �Խù��� ����������
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // ����������
	}
}
