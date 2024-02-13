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

import pj.mvc.jsp.dto.Ad_product_DTO;

public class Ad_product_DAOImpl implements Ad_product_DAO {

	private DataSource dataSource = null;
	
	static Ad_product_DAOImpl instance = new Ad_product_DAOImpl();
	
	private Ad_product_DAOImpl() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/jsp_pj_team1");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

	public static Ad_product_DAOImpl getInstance() {
		
		if(instance == null) {
			
			instance = new Ad_product_DAOImpl();
		}
		
		return instance;
	}
	
	@Override
	public int pdInsert(Ad_product_DTO dto) {
		
		System.out.println("Ad_product_DAOImpl - pdInsert");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertCnt = 0;
		
		try {
			
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO pj_product_tbl (pd_num, category_num, pd_name, pd_price, pd_stuck, pd_content, pd_img1, pd_img2, pd_detail_img, pd_register) "
					+ "VALUES ((SELECT NVL(MAX(pd_num)+1, 1) FROM pj_product_tbl), ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getCategory_num());
			pstmt.setString(2, dto.getPd_name());
			pstmt.setInt(3, dto.getPd_price());
			pstmt.setInt(4, dto.getPd_stuck());
			pstmt.setString(5, dto.getPd_content());
			pstmt.setString(6, dto.getPd_img1());
			pstmt.setString(7, dto.getPd_img2());
			pstmt.setString(8, dto.getPd_detail_img());

			insertCnt = pstmt.executeUpdate();
			System.out.println("insertCnt : " + insertCnt);
			
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
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return insertCnt;
	}

	@Override
	public int pdCnt() {
		
		System.out.println("Ad_product_DAOImpl - pdCnt");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		int total = 0;

		try {
			
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) AS cnt FROM pj_product_tbl";
			
			pstmt = conn.prepareStatement(sql);
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

	@Override
	public List<Ad_product_DTO> pdList(int start, int end) {
		
		System.out.println("Ad_product_DAOImpl - productList");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		List<Ad_product_DTO> list = new ArrayList<Ad_product_DTO>();
		
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
				+ "       ) "
				+ " WHERE rn BETWEEN ? AND ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Ad_product_DTO dto = new Ad_product_DTO();
				
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

	@Override
	public Ad_product_DTO pdListDetail(int pd_num) {
		
		System.out.println("Ad_product_DAOImpl - pdListDetail");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		Ad_product_DTO dto = null;
		
		String sql = "SELECT * FROM pj_product_tbl "
					+ "WHERE pd_num=?";
		
		try {
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new Ad_product_DTO();
				
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

	@Override
	public int pdUdate(Ad_product_DTO dto) {
		
		System.out.println("Ad_product_DAOImpl - pdUdate");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		
		try {
			
			conn = dataSource.getConnection();
			
			String sql = "UPDATE pj_product_tbl "
						+ "SET category_num=?, pd_name=?, pd_price=?, pd_stuck=?, pd_content=?, pd_img1=?, pd_img2=?, pd_detail_img=? "
						+ "where pd_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCategory_num());
			pstmt.setString(2, dto.getPd_name());
			pstmt.setInt(3, dto.getPd_price());
			pstmt.setInt(4, dto.getPd_stuck());
			pstmt.setString(5, dto.getPd_content());
			pstmt.setString(6, dto.getPd_img1());
			pstmt.setString(7, dto.getPd_img2());
			pstmt.setString(8, dto.getPd_detail_img());
			pstmt.setInt(9, dto.getPd_num());
			
			updateCnt = pstmt.executeUpdate();
			System.out.println("updateCnt : " + updateCnt);
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) {
						
					pstmt.close();
				}
				
				if(conn != null) {
			
					conn.close();
					
				}
				
			} catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return updateCnt;
	}

	@Override
	public int pdDelete(int pd_num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deleteCnt = 0;
		
		try {
			
			conn = dataSource.getConnection();
			
			String sql = "UPDATE pj_product_tbl "
						+ "SET show='n' "
						+ "WHERE pd_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			
			deleteCnt = pstmt.executeUpdate();
			System.out.println("deleteCnt : " + deleteCnt);
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) {
						
					pstmt.close();
				}
				
				if(conn != null) {
			
					conn.close();
					
				}
				
			} catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return deleteCnt;
	}
}
