package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ad_product_Service {

	// 상품 등록
	public void pdInsertAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 상품 목록
	public void pdListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 상품 상세페이지
	public void pdListDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 상품 수정
	public void pdUdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 상품 삭제
	public void pdDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;

}
