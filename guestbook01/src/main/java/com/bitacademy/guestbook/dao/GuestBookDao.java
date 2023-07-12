package com.bitacademy.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bitacademy.guestbook.vo.GuestBookVo;

public class GuestBookDao {

	public boolean insert(GuestBookVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement auto_pstmt = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class Loading (Library Loading)
			Class.forName("org.mariadb.jdbc.Driver");	//이것은 변하지 않는다. driver마다 정해져있음.
			
			//2. Connection
			String url = "jdbc:mariadb://192.168.0.153:3306/webdb?charset=utf8";		//이것도 드라이버마다 정해져 있음.
			// mac에서는 옵션을 더 줘야할 수도 있다. 
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3. Statement Ready
			String auto_sql = "Alter table guestbook AUTO_INCREMENT = 0";
			String sql = "insert into guestbook values (null,?,password(?),?,curdate())";
			
			auto_pstmt = conn.prepareStatement(auto_sql);
			pstmt = conn.prepareStatement(sql);
			
			//4. Binding
			pstmt.setString(1,vo.getName());	
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getText());
			
			//5. Execute binding pstmt
			int auto_count = auto_pstmt.executeUpdate();
			int count = pstmt.executeUpdate();
			
			
			//6. 결과 처리 
			//if(count==1) result=true;
			result = count ==1 && auto_count ==1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed Driver Loading");
		}catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			//7. 자원 정리 
			try {
				if(conn!=null)	conn.close();
				if(auto_pstmt!=null)	auto_pstmt.close();
				if(pstmt!=null)	pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<GuestBookVo> findAll() {
		// TODO Auto-generated method stub
		List<GuestBookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver Class Loading (Library Loading)
			Class.forName("org.mariadb.jdbc.Driver");	//이것은 변하지 않는다. driver마다 정해져있음.
			
			//2. Connection
			String url = "jdbc:mariadb://192.168.0.153:3306/webdb?charset=utf8";		//이것도 드라이버마다 정해져 있음.
			// mac에서는 옵션을 더 줘야할 수도 있다. 
			conn = DriverManager.getConnection(url,"webdb","webdb");		//id, password
			
			//3. Statement 생성 
			String sql = "select no, name, text, post_date from guestbook order by no desc";
			stmt = conn.prepareStatement(sql);
			
			//4. SQL 실행  주의 : ';'를 쓰면 안됨.
			 rs = stmt.executeQuery();	//select는 이게 다르다.
			
			// binding 할게 없음 . 
			 
			//5. 결과 처리 
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String text = rs.getString(3);
				String post_date = rs.getString(4);
				
				GuestBookVo vo = new GuestBookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setText(text);
				vo.setPost_date(post_date);
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed Driver Loading");
		}catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			//6. 자원 정리 
			try {
				if(rs!=null)	rs.close();
				if(conn!=null)	conn.close();
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean delete(Long no) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class Loading (Library Loading)
			Class.forName("org.mariadb.jdbc.Driver");	//이것은 변하지 않는다. driver마다 정해져있음.
			
			//2. Connection
			String url = "jdbc:mariadb://192.168.0.153:3306/webdb?charset=utf8";		//이것도 드라이버마다 정해져 있음.
			// mac에서는 옵션을 더 줘야할 수도 있다. 
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3. Statement Ready
			String sql = "delete from guestbook where no=?";
			pstmt = conn.prepareStatement(sql);
			
			//4. Binding
			pstmt.setLong(1, no);
			
			//5. Execute binding pstmt
			int count = pstmt.executeUpdate();
			
			
			//6. 결과 처리 
			//if(count==1) result=true;
			result = count ==1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed Driver Loading");
		}catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			//7. 자원 정리 
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(Long no, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class Loading (Library Loading)
			Class.forName("org.mariadb.jdbc.Driver");	//이것은 변하지 않는다. driver마다 정해져있음.
			
			//2. Connection
			String url = "jdbc:mariadb://192.168.0.153:3306/webdb?charset=utf8";		//이것도 드라이버마다 정해져 있음.
			// mac에서는 옵션을 더 줘야할 수도 있다. 
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3. Statement Ready
			String sql = "delete from guestbook where no=? and password = password(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.setString(2, password);
			int count = pstmt.executeUpdate();
			
			
			int arr_count =0;
			String[] sql_arr = {
					"SET @count=0",
					"UPDATE guestbook SET no=@count:=@count+1"
			};
			for(String sql_index : sql_arr) {
				pstmt = conn.prepareStatement(sql_index);
				arr_count = pstmt.executeUpdate();
			}
			
			
			result = count ==1 && arr_count ==1;
		} catch (ClassNotFoundException e) {
			System.out.println("Failed Driver Loading");
		}catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			//7. 자원 정리 
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
