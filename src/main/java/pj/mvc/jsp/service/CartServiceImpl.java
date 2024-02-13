package pj.mvc.jsp.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.CartDAO;
import pj.mvc.jsp.dao.CartDAOImpl;
import pj.mvc.jsp.dto.CartDTO;

public class CartServiceImpl implements CartService{

	// 장바구니 목록
	@Override
	public void cartPdListAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdListAction(req, res) >>");
		
		String s_user_id = "user01"; // 세션값 가져오기 
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		List<CartDTO> list = dao.cartList(s_user_id);
		int totalPrice = dao.cartTotalPrice(s_user_id);
		int selectpdPrice = dao.cartSelectpdPrice(s_user_id);
		
		req.setAttribute("list", list);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("selectpdPrice", selectpdPrice);
		
	}

	// 장바구니 상품 삭제
	@Override
	public void cartPdDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdDeleteAction(req, res) >>");
		
		int hidden_cart_num =  Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		dao.cartPdDelete(hidden_cart_num);
		
	}

	// 장바구니 상품 수정(수량)
	@Override
	public void cartPdUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdUpdateAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		int cart_cnt = Integer.parseInt(req.getParameter("cart_cnt"));
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		dao.cartUpdate(hidden_cart_num, cart_cnt);
		
	}

	// 장바구니 상품 체크박스 선택시 
	@Override
	public void cartPdCheckedAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdCheckedAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		dao.cartPdchecked(hidden_cart_num);
		
	}

	//장바구니 상품 체크박스 비선택시
	@Override
	public void cartPdNotCheckedAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdNotCheckedAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		dao.cartPdNotcheked(hidden_cart_num);
	}

	// 장바구니 상품 추가시 중복확인(bottom)
	@Override
	public void cart_pdchk_bottom(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_bottom(req, res) >>");
		
		String s_user_id = "user01"; // 세션값 가져오기 
		int pd_num = 2; // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		int selectCnt = dao.cart_pdchk(s_user_id, pd_num);
		
		req.setAttribute("selectCnt", selectCnt);
		req.setAttribute("pd_num", pd_num);
		
	}
	
	// 장바구니 상품 추가시 중복확인(outer)
	@Override
	public void cart_pdchk_outer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_outer(req, res) >>");
		
		String s_user_id = "user01"; // 세션값 가져오기 
		int pd_num = 2; // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		int selectCnt = dao.cart_pdchk(s_user_id, pd_num);
		
		req.setAttribute("selectCnt", selectCnt);
		req.setAttribute("pd_num", pd_num);
	}

	// 장바구니 상품 추가시 중복확인(top)
	@Override
	public void cart_pdchk_top(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_top(req, res) >>");
		
		String s_user_id = "user01"; // 세션값 가져오기 
		int pd_num = 2; // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		int selectCnt = dao.cart_pdchk(s_user_id, pd_num);
		
		req.setAttribute("selectCnt", selectCnt);
		req.setAttribute("pd_num", pd_num);
	}
	
	//  장바구니에 상품 추가 처리페이지
	@Override
	public void cartPdAddAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdAddAction(req, res) >>");
		
		String s_user_id = "user01"; // 세션값 가져오기
		int pd_num = 2; // getparameter로  상품상세페이지에서 받은 값 가져올 것 
//		int cart_cnt = Integer.parseInt(req.getParameter("cart_cnt"));
		
		CartDTO dto = new CartDTO();
		dto.setUser_id(s_user_id);
		dto.setPd_num(pd_num);
//		dto.setCart_cnt(cart_cnt);
		
		CartDAO dao = CartDAOImpl.getInstance();
		
		int insertCnt = dao.cartPdAdd(dto);
		
		req.setAttribute("insertCnt", insertCnt);
		
	}

	
	
}
