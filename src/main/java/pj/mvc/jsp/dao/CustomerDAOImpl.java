package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.apache.catalina.webresources.AbstractSingleArchiveResourceSet;

import pj.mvc.jsp.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	DataSource dataSource = null;
	
	//싱글톤 객체 생성
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	
	public static CustomerDAOImpl getInstance() {
		if(instance==null) {
			instance = new CustomerDAOImpl();
		}
		return instance;
	}
	
	//디폴트 생성자
	//커넥션 풀
	private CustomerDAOImpl() {
		try {
			
			Context context = new InitialContext();
				dataSource = (DataSource)context.lookup("java:comp/env/jdbc/jsp_pj_team1");
				
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	 // ID 중복확인 처리
	@Override
	public int useridCheck(String strUserid) {
		return 0;
		
	}

	 
	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		 System.out.println("CustomerDAOImpl - insertCustomer");
		 
		 int insertCnt = 0;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 
		 try {
			 conn = dataSource.getConnection();
			 String sql = "INSERT INTO pj_user_tbl (user_id, user_pwd, user_name, user_hp, user_email, user_address) "
			 		+ "VALUES (?, ?, ?, ?, ?, ?) ";
			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1,dto.getUser_id());
			 pstmt.setString(2,dto.getUser_pwd());
			 pstmt.setString(3,dto.getUser_name());
			 pstmt.setString(4,dto.getUser_hp());
			 pstmt.setString(5,dto.getUser_email());
			 pstmt.setString(6,dto.getUser_address());
			
			 
			 insertCnt = pstmt.executeUpdate();
			 
			 System.out.println("insertCnt : " + insertCnt);
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(pstmt != null)pstmt.close();
				 if(conn != null)conn.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
		 }
		return insertCnt;
	}
	
	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idpasswordChk(String strId, String strPassword) {
		System.out.println("CustomerDAOImpl - idpasswordChk()");
		
		int selectCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("CustomerDAOImpl - idpasswordChk() try1");
			conn = dataSource.getConnection();
			System.out.println("CustomerDAOImpl - idpasswordChk() try2");
			String sql = "SELECT * FROM pj_user_tbl  "
					+ "WHERE user_id = ? AND user_pwd = ? ";
			System.out.println("CustomerDAOImpl - idpasswordChk() try3");		
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			pstmt.setString(2,strPassword);
			rs = pstmt.executeQuery();
			System.out.println("CustomerDAOImpl - idpasswordChk() try4");
			if(rs.next()) {
				selectCnt = 1;
			}
			
			System.out.println("selectCnt : " + selectCnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return selectCnt;
	}

	// 회원탈퇴 처리
	@Override
	public int deleteCustomer(String strId) {
		System.out.println("CustomerDAOImpl - deleteCustomer()");
		
		int deleteCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM pj_user_tbl "
					+ "WHERE user_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			
			deleteCnt = pstmt.executeUpdate();
			
			System.out.println("deleteCnt:"+ deleteCnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
	            if(conn != null) conn.close();
	            if(pstmt != null) pstmt.close();
	         } catch(SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return deleteCnt;
	   }

	// 회원정보 상세페이지
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		System.out.println("CustomerDAOImpl - getCustomerDetail()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 1. CustomerDTO 바구니 생성
		 CustomerDTO dto = new CustomerDTO();
		 
		try {
			conn = dataSource.getConnection();
			 // 2. strId(로그인 화면에서 입력받은 세션ID)와 일치하는 데이터가 존재하는지 확인
			String sql = "SELECT * FROM pj_user_tbl "
					+ "WHERE user_id = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			
			rs = pstmt.executeQuery();
			
			 // 3. ResultSet에 id와 일치하는 한사람의 회원정보가 존재하면
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_hp(rs.getString("user_hp"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_address(rs.getString("user_address"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
	            if(conn != null) conn.close();
	            if(pstmt != null) pstmt.close();
	         } catch(SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return dto;
	   }

	 // 회원정보 수정 처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		 System.out.println("CustomerDAOImpl - updateCustomer");
		   int updateCnt = 0;
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		      
	      try {
	         conn = dataSource.getConnection();
	         String sql = "UPDATE pj_user_tbl  "
	         		+ "SET user_pwd=? , user_name=? ,user_hp=? ,user_email=? ,user_address=?  "
	         		+ "WHERE user_id=? ";
	               
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, dto.getUser_pwd());
	         pstmt.setString(2, dto.getUser_name());
	         pstmt.setString(3, dto.getUser_hp());
	         pstmt.setString(4, dto.getUser_email());
	         pstmt.setString(5, dto.getUser_address());
	         pstmt.setString(6, dto.getUser_id());
	         
	         updateCnt = pstmt.executeUpdate();
	         
	         System.out.println("updateCnt : " + updateCnt);
	         
	      } catch(SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch(SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return updateCnt;
	   }

}
