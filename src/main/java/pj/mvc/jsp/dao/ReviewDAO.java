package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.ReviewCommentDTO;
import pj.mvc.jsp.dto.ReviewDTO;

public interface ReviewDAO {
	
	// 리뷰 게시글 목록
	public List<ReviewDTO> reviewList(int start, int end);

	
	// 리뷰 개시글 갯수 구하기
	public int boardCnt();
	
	// 조회수 증가
	public void plusReadCnt(int num);
	
	// 리뷰 게시글 상세페이지
	public ReviewDTO getBoardDetail(int num);
	
	// 리뷰 게시글 수정 삭제시 비밀번호 인증
	public int password_chk(int num, int password);
	
	// 리뷰 게시글 수정처리
	public int updateReview(ReviewDTO dto);
	
	// 리뷰 게시글 삭제 처리
	public int deletReview(int num);
	
	// 리뷰 게시글 작성 처리
	public int writeReview(ReviewDTO dto);
	
	///////////어드민/////////////
	// 댓글작성 처리
	public int commentInsert(ReviewCommentDTO dto);
	
	// 댓글목록 처리
	public List<ReviewCommentDTO> commentList(int board_num);
	
}
