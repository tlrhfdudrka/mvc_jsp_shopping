package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartService {

	// 장바구니 목록 
	public void  cartPdListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 장바구니 상품 삭제
	public void  cartPdDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 장바구니 상품 수정(수량)
	public void  cartPdUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 장바구니 상품 체크박스 선택시 
	public void  cartPdCheckedAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	//장바구니 상품 체크박스 비선택시
	public void  cartPdNotCheckedAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 장바구니 상품 추가시 중복확인(bottom)
	public void cart_pdchk_bottom(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 장바구니 상품 추가시 중복확인(outer)
	public void cart_pdchk_outer(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
		
	// 장바구니 상품 추가시 중복확인(top)
	public void cart_pdchk_top(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;	
	
	//  장바구니에 상품 추가 처리페이지
	public void cartPdAddAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;

	
}
