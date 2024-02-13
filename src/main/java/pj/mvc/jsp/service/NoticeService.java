package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoticeService {

	// 게시글 목록
	public void noticeListAction(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException;
	
	// 게시글 상세페이지
	public void noticeDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	/*
	// 게시글 수정 삭제시 비밀번호 인증
	public int notice_pwd_chkAciton(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	*/
	
	// 게시글 수정처리
	public void noticeUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 게시글 삭제처리
	public void noticeDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 게시글 작성 처리
	public void noticeInsertAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
}
