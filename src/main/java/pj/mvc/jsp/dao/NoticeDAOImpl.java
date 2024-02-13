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

import pj.mvc.jsp.dto.NoticeDTO;

public class NoticeDAOImpl implements NoticeDAO {
	
	// 커넥션 풀 객체를 보관
	private DataSource dataSource;
	
	// 싱글톤 객체 생성
	private static NoticeDAOImpl instance = new NoticeDAOImpl();
	
	public static NoticeDAOImpl getInstance() {
		if(instance == null) {
			instance = new NoticeDAOImpl();
		}
		return instance;
	}
	
	// 커넥션풀 연결
	//커넥션 풀(DBCP : DataBase Connection Pool 방식) - context.xml에 작성
	private NoticeDAOImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_team1");
			// context.xml에 name이 "jdbc/jsp_pj_ict02" 이걸 찾아서(lookup) 가져다 쓰겠다는것
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 목록
	@Override
	public List<NoticeDTO> noticeList(int start, int end) {
		System.out.println("NoticeDAOImpl - noticeList");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * "
					+ "  FROM ( "
					+ "        SELECT A.*, "
					+ "              rownum AS rn "
					+ "          FROM "
					+ "            ( "
					+ "              SELECT * FROM pj_notice_tbl "
					+ "              WHERE show = 'y' "
					+ "              ORDER BY notice_num DESC "
					+ "            ) A "
					+ "        ) "
					+ " WHERE rn BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);			
			
			rs = pstmt.executeQuery();
			
			// 반복문
			while(rs.next()) {
				// 2. dto 생성
				NoticeDTO dto = new NoticeDTO();
				
				// 3. dto에 1건의 rs 게시글 정보를 담는다.
				dto.setNotice_num(rs.getInt("notice_num"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setNotice_pwd(rs.getString("notice_pwd"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_content(rs.getString("notice_content"));
				dto.setNotice_readCnt(rs.getInt("notice_readCnt"));
				dto.setNotice_date(rs.getDate("notice_date"));
				
				// 4. list에 dto 추가
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// 게시글 갯수 구하기
	@Override
	public int noticeCnt() {
		System.out.println("NoticeDAOImple - noticeCnt");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		
		try {
			conn = dataSource.getConnection(); 
			// ************************ cnt 컬럼 확인하기
			String sql = "SELECT COUNT(*) as cnt"
					+ "  FROM pj_notice_tbl";
			
			pstmt = conn.prepareStatement(sql); 
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("cnt");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}

	// 조회수 증가
	@Override
	public void plusReadCnt(int notice_num) {
		System.out.println("NoticeDAOImpl - plusReadCnt");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE pj_notice_tbl "
					+ " SET notice_readCnt = notice_readCnt + 1 "
					+ " WHERE notice_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 게시글 상세 페이지
	@Override
	public NoticeDTO getNoticeDetail(int notice_num) {
		System.out.println("NoticeDAOImpl - getNoticeDetail");
		
		// 1. dto 생성
		NoticeDTO dto = new NoticeDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection(); 
			String sql = "SELECT * FROM pj_notice_tbl "
					+ "WHERE notice_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
					
			// 2. dto에 setter로 rs 결과를 담는다.
			if(rs.next()) {	
				dto.setNotice_num(rs.getInt("notice_num"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setNotice_pwd(rs.getString("notice_pwd"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_content(rs.getString("notice_content"));
				dto.setNotice_readCnt(rs.getInt("notice_readCnt"));
				dto.setNotice_date(rs.getDate("notice_date"));
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	// 게시글 수정 삭제시 비밀번호 인증
	@Override
	public int notice_pwd_chkAciton(int notice_num, String notice_pwd) {
		System.out.println("NoticeDAOImpl - notice_pwd_chkAciton");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection(); 
			String sql = "SELECT COUNT(*) AS cnt FROM pj_notice_tbl "
					+ "WHERE notice_num = ? "
					+ "  AND notice_pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			pstmt.setString(2, notice_pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			System.out.println("result : " + result);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 게시글 수정처리
	@Override
	public int updateNotice(NoticeDTO dto) {
		System.out.println("NoticeDAOImple - updateNotice");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		
		try {
			conn = dataSource.getConnection(); 
			String sql = "UPDATE pj_notice_tbl "
					+ "   SET notice_title = ?, "
					+ "       notice_content = ? "
					+ " WHERE notice_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_content());
			pstmt.setInt(3, dto.getNotice_num());
			
			updateCnt = pstmt.executeUpdate(); // 실행하라라는 의미
			System.out.println("updateCnt : " + updateCnt); // 성공:1 실패:0
			
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

	// 게시글 삭제처리
	@Override
	public int deleteNotice(int notice_num) {
		System.out.println("NoticeDAOImpl - deleteNotice");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int deleteCnt = 0;
		
		try {
			conn = dataSource.getConnection(); 
			
			String sql = "UPDATE pj_notice_tbl "
					   + " SET show = 'n' "
					   + " WHERE notice_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
			deleteCnt = pstmt.executeUpdate(); // 실행하라라는 의미
			System.out.println("deleteCnt : " + deleteCnt); // 성공:1 실패:0
			
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
		
		return deleteCnt;
	}

	// 게시글 작성처리
	@Override
	public int writeNotice(NoticeDTO dto) {
		System.out.println("NoticeDAOImpl - writeBoard");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertCnt = 0;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO pj_notice_tbl (notice_num, user_id, notice_title, notice_content, notice_readCnt, notice_date) "
					+ "VALUES ((SELECT NVL(MAX(notice_num)+1, 1) FROM pj_notice_tbl), ?, ?, ?, 1, sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getNotice_title());
			pstmt.setString(3, dto.getNotice_content());
			
			insertCnt = pstmt.executeUpdate(); // 실행하라라는 의미
			System.out.println("insertCnt : " + insertCnt); // 성공:1 실패:0
			
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
		return insertCnt;
	}

}
