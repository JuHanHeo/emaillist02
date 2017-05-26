package com.jx372.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.emaillist.vo.emailListVo;

public class EmailListDao {
	private Connection getConnection() throws SQLException{

		Connection conn = null;


		//1. 드라이버 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. Connection 하기
			String url ="jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}

	public boolean insert(emailListVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn=getConnection();

			String sql = "insert into emaillist values(null,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());

			int count = pstmt.executeUpdate();
			return (count==1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<emailListVo> getList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<emailListVo> list = new ArrayList<emailListVo>();
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "select no, last_name, first_name, email from emaillist";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int no = rs.getInt(1);	
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String email = rs.getString(4);
				
				emailListVo vo = new emailListVo();
				vo.setNo(no);
				vo.setLastName(lastName);
				vo.setFirstName(firstName);
				vo.setEmail(email);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	
}
