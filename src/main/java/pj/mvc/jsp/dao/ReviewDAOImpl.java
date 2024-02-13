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

import pj.mvc.jsp.dto.ReviewCommentDTO;
import pj.mvc.jsp.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO {

	// 커넥션 풀 객체를 보관
	private DataSource dataSource;
	
	// 싱글톤 객체 생성
	private static ReviewDAOImpl instance = new ReviewDAOImpl();
	
	public static ReviewDAOImpl getInstance() {
		if(instance == null) {
			instance = new ReviewDAOImpl ();
		}
		return instance;
	}
	
	// 커넥션풀 연결
	private ReviewDAOImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_team1"); //jsp_pj_team1 프로젝트명
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	// 리뷰 게시글 목록
	@Override
	public List<ReviewDTO> reviewList(int start, int end) {
		System.out.println("ReviewDAOImpl - reviewList");
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<ReviewDTO> list = new ArrayList<ReviewDTO>();
	    
	    
	      try {
		         conn = dataSource.getConnection();
		         
			      // 게시글 삭제, 댓글 갯수 미반영
			         String sql = "SELECT * "
			         		+ "  FROM ( "
			         		+ "      SELECT A.*, "
			         		+ "           rownum AS rn "
			         		+ "      FROM "
			         		+ "        ( "
			         		+ "        SELECT * FROM pj_review_tbl "
			         		+ "                WHERE show = 'y' "
			         		+ "            ORDER BY review_num DESC "
			         		+ "        ) A "
			         		+ "  ) "
			         		+ " WHERE rn BETWEEN ? AND ? ";
			         
		         
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, start);
		         pstmt.setInt(2, end);
		         
		         rs = pstmt.executeQuery();
		    
		         while(rs.next()) {
		               // 2. dto 생성
		               ReviewDTO dto = new ReviewDTO();
		               
		               // 3. dto에 1건의 rs 게시글 정보를 담는다.
		               dto.setReview_num(rs.getInt("review_num"));
		               dto.setReview_img(rs.getString("review_img"));
		               dto.setReview_title(rs.getString("review_title"));
		               dto.setReview_content(rs.getString("review_content"));
		               dto.setUser_id(rs.getString("user_id"));
		               dto.setReview_pwd(rs.getString("review_pwd"));
		               dto.setReview_readCnt(rs.getInt("review_readCnt"));
		               dto.setReview_date(rs.getDate("review_date"));
		               dto.setReview_comment_count(rs.getInt("review_comment_count"));
		               
		               // 4. list에 dto를 추가한다. 
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
		      
		      // 5. list 리턴
		      return list;
		   }

	// 리뷰 게시글 갯수 구하기
	@Override
	public int boardCnt() {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int total = 0;
		
	    try {
	         conn = dataSource.getConnection();
	         String sql = "SELECT COUNT(*) as cnt FROM pj_review_tbl ";
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
	public void plusReadCnt(int num) {
		System.out.println("ReviewDAOImpl - plusReadCnt");
		
		ReviewDTO dto = new ReviewDTO();
	}

	// 리뷰 게시글 상세페이지
	@Override
	public ReviewDTO getBoardDetail(int num) {
		System.out.println("ReviewDAOImpl - getBoardDetail");
		
		ReviewDTO dto = new ReviewDTO();
		
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;

	      
	      try {
	         conn = dataSource.getConnection();
	         String sql = " SELECT * FROM pj_review_tbl  "
	         		+ "WHERE review_num = ? ";

	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         rs = pstmt.executeQuery();
	         
	         // 2. setter에 rs 결과를 담는다.
	         
	         if(rs.next()) {
	        	   dto.setReview_num(rs.getInt("review_num"));
	               dto.setReview_title(rs.getString("review_title"));
	               dto.setReview_content(rs.getString("review_content"));
	               dto.setReview_img(rs.getString("review_img"));
	               dto.setUser_id(rs.getString("user_id"));
	               dto.setReview_pwd(rs.getString("review_pwd"));
	               dto.setReview_readCnt(rs.getInt("review_readCnt"));
	               dto.setReview_date(rs.getDate("review_date"));
	         }
	      
	         
	         rs = pstmt.executeQuery();
	    

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
	      
	      // 5. list 리턴
	      return dto;
	   }

	// 리뷰 게시글 수정 삭제시 비밀번호 인증
	@Override
	public int password_chk(int num, int password) {
		return 0;
	}

	// 리뷰 게시글 수정처리
	@Override
	public int updateReview(ReviewDTO dto) {
		System.out.println("ReviewDAOImpl - updateReview");
		
		int updateCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = " UPDATE pj_review_tbl "
					+ "SET review_title = ?, review_content= ?, review_img = ? "
					+ "WHERE review_num = ? ";	
			
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, dto.getPassword());
			pstmt.setString(1, dto.getReview_title());
			pstmt.setString(2, dto.getReview_content());
			pstmt.setString(3, dto.getReview_img());
			pstmt.setInt(4,  dto.getReview_num());
			
			updateCnt = pstmt.executeUpdate();
			System.out.println("updateCnt :" + updateCnt);
			
			
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

	// 리뷰 게시글 삭제 처리
	@Override
	public int deletReview(int num) {
		System.out.println("ReviewDAOImpl - deletReview");
		
		int deleteCnt = 0;
		Connection conn = null;  // 오라클 연결
		PreparedStatement pstmt = null; // SQL 문장
		ResultSet rs = null; // SQL 실행결과(SELECT)
		
		try {
			
			conn = dataSource.getConnection(); //DB 연결
			String sql = "UPDATE pj_review_tbl "
					+      " SET show = 'n' "
					+    " WHERE review_num = ? ";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, num);
			
			deleteCnt = pstmt.executeUpdate(); //실행하라
			
			System.out.println("deleteCnt : " + deleteCnt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
	         try {
	             if(pstmt != null) pstmt.close();
	             if(conn != null) conn.close();
	             if(rs != null) rs.close();
	          } catch(SQLException e) {
	             e.printStackTrace();
	          }
	       }

		return deleteCnt;
	}

	// 리뷰 게시글 작성 처리
	@Override
	public int writeReview(ReviewDTO dto) {
		System.out.println("ReviewDAOImpl - writeReview");
		
		int insertCnt = 0;
		Connection conn = null;  // 오라클 연결
		PreparedStatement pstmt = null; // SQL 문장
		
		try {
			
			conn = dataSource.getConnection();
			String sql = " INSERT INTO pj_review_tbl (review_num, review_title, review_content, review_img, review_date) "
					+ "VALUES ((SELECT NVL(MAX(review_num)+1, 1) FROM pj_review_tbl), ?, ?, ?, sysdate) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getReview_title());
			pstmt.setString(2, dto.getReview_content());
			pstmt.setString(3, dto.getReview_img());
			
			insertCnt = pstmt.executeUpdate(); // 실행하라
			
			System.out.println("insertCnt : " + insertCnt);
			
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

	// 댓글작성 처리
		@Override
		public int commentInsert(ReviewCommentDTO dto) {
			System.out.println("ReviewDAOImpl - commentInsert");
			
			int insertCnt = 0;
			Connection conn = null;  // 오라클 연결
			PreparedStatement pstmt = null; // SQL 문장
			
			try {
				
				conn = dataSource.getConnection();
				String sql = " INSERT INTO pj_reviewCmt_tbl (review_cmt_num, review_num, review_cmt_content, review_date) "
						+ "VALUES ((SELECT NVL(MAX(review_cmt_num)+1, 1) FROM pj_reviewCmt_tbl), ?, ?, sysdate) ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getReview_num());
				pstmt.setString(2, dto.getReview_cmt_content());
				
				insertCnt = pstmt.executeUpdate(); // 실행하라
				
				System.out.println("insertCnt : " + insertCnt);
				
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
		
		// 댓글목록 처리
		@Override
		public List<ReviewCommentDTO> commentList(int board_num) {
			System.out.println("ReviewDAOImpl - commentList");
			
			  Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      List<ReviewCommentDTO> list = new ArrayList<ReviewCommentDTO>();
		      
		      try {
		         conn = dataSource.getConnection();
		         String sql = "SELECT * FROM pj_reviewCmt_tbl "
		         		+ "WHERE review_num = ? "
		         		+ "ORDER BY review_cmt_num DESC ";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, board_num);
		         
		         rs = pstmt.executeQuery();
		    
		         while(rs.next()) {
		               // 2. dto 생성
		        	   ReviewCommentDTO dto = new ReviewCommentDTO();
		               
		               // 3. dto에 1건의 rs 게시글 정보를 담는다.
		               dto.setReview_cmt_num(rs.getInt("review_cmt_num"));
		               dto.setReview_num(rs.getInt("review_num"));
		               dto.setUser_id(rs.getString("user_id"));
		               dto.setReview_cmt_content(rs.getString("review_cmt_content"));
		               dto.setReview_date(rs.getDate("review_date"));
		               
		               // 4. list에 dto를 추가한다. 
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
		      
		      // 5. list 리턴
		      return list;
		   }	
		
	
}
