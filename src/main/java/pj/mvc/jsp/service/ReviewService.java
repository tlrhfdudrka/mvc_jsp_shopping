package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReviewService {

	// 리뷰 게시글 목록
	public void reviewListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 리뷰 게시글 상세페이지
	public void reviewDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 리뷰 게시글 수정처리 화면
	public void ReviewUpdate(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;	
	
	// 리뷰 게시글 수정처리
	public void ReviewUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 리뷰 게시글 삭제 처리
	public void ReviewDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 리뷰 게시글 작성 처리
	public void ReviewInsertAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
}
