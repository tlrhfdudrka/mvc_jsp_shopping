package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pj.mvc.jsp.dto.Us_product_DTO;

public class Us_product_DAOImpl implements Us_product_DAO {

	private DataSource dataSource = null;
	
	static Us_product_DAOImpl instance = new Us_product_DAOImpl();
	
	private Us_product_DAOImpl() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/jsp_pj_team1");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

	public static Us_product_DAOImpl getInstance() {
		
		if(instance == null) {
			
			instance = new Us_product_DAOImpl();
		}
		
		return instance;
	}
	
	@Override
	public int usCnt(int category_num) {
		
		System.out.println("Us_product_DAOImpl - usCnt");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		int total = 0;

		try {
			
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) AS cnt FROM pj_product_tbl "
						+ "WHERE category_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				total = rs.getInt("cnt");
			}
			
			System.out.println("total : " + total);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(conn != null) {
					
					conn.close();
				}
				
				if(pstmt != null) {
					
					pstmt.close();
				}
				
				if(rs != null) {
					
					rs.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	// 모든 상품 조회
	@Override
	public List<Us_product_DTO> usListAction() {
		
		System.out.println("Us_product_DAOImpl - usList");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		List<Us_product_DTO> list = new ArrayList<Us_product_DTO>();
		
		String sql = "SELECT * "
				+ "  FROM ("
				+ "        SELECT A.*, "
				+ "            rownum AS rn "
				+ "          FROM "
				+ "           ("
				+ "             SELECT * "
				+ "             FROM pj_product_tbl "
				+ "					where show='y' "
				+ "             ORDER BY pd_num DESC "
				+ "           ) A"
				+ "       ) ";
		
		try {
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Us_product_DTO dto = new Us_product_DTO();
				
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setCategory_num(rs.getInt("category_num"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_price(rs.getInt("pd_price"));
				dto.setPd_stuck(rs.getInt("pd_stuck"));
				dto.setPd_content(rs.getString("pd_content"));
				dto.setPd_img1(rs.getString("pd_img1"));
				dto.setPd_img2(rs.getString("pd_img2"));
				dto.setPd_detail_img(rs.getString("pd_detail_img"));
				dto.setPd_register(rs.getDate("pd_register"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(conn != null) {
					
					conn.close();
				}
				
				if(pstmt != null) {
					
					pstmt.close();
				}
				
				if(rs != null) {
					
					rs.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		  return list;
	}

	// 상품 상세 정보 가져오기
	@Override
	public Us_product_DTO udDetailList(int pd_num) {
		
		System.out.println("Us_product_DAOImpl - udDetailList");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		Us_product_DTO dto = null;
		
		String sql = "SELECT * FROM pj_product_tbl "
					+ "WHERE pd_num=?";
		
		try {
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new Us_product_DTO();
				
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setCategory_num(rs.getInt("category_num"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_price(rs.getInt("pd_price"));
				dto.setPd_stuck(rs.getInt("pd_stuck"));
				dto.setPd_content(rs.getString("pd_content"));
				dto.setPd_img1(rs.getString("pd_img1"));
				dto.setPd_img2(rs.getString("pd_img2"));
				dto.setPd_detail_img(rs.getString("pd_detail_img"));
				dto.setPd_register(rs.getDate("pd_register"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(conn != null) {
					
					conn.close();
				}
				
				if(pstmt != null) {
					
					pstmt.close();
				}
				
				if(rs != null) {
					
					rs.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		  return dto;
    }
}
