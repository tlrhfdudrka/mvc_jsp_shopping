package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.CartService;
import pj.mvc.jsp.service.CartServiceImpl;

@WebServlet("*.ct")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public CartController() {
        super();
    }

    // 1단계. 웹브라우저가 전송한 HTTP 요청을 받음
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		action(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	public void action(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 2단계. 클라이언트 요청 분석
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		
		String viewPage = "";  // 보여질 페이지의 경로를 담을 변수 선언
		
		CartService service = new CartServiceImpl();
		
		// 우리가 필요한 url만 가져오기 위한 편집 과정
		String uri = req.getRequestURI(); // URI : contextPath(/플젝명)부터 끝까지의 url
		String contextPath = req.getContextPath();  // ContextPath : /플젝명
		String url = uri.substring(contextPath.length());
		
		// 본격 클라이언트 요청 분석 시작
		// 장바구니 목록 페이지
		if(url.equals("/*.ct") || url.equals("/cartList.ct")) {
			System.out.println("<< 컨트롤러 url - /cartList.ct >>");
			
			service.cartPdListAction(req, res);
			
			viewPage = "customer/cart/cartList.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
		
		// 장바구니 상품 삭제
		else if(url.equals("/cart_pdDeleteAction.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_pdDeleteAction.ct >>");
			
			service.cartPdDeleteAction(req, res);
			
			viewPage = req.getContextPath() +  "/cartList.ct";
			res.sendRedirect(viewPage);
			
		}
		
		// 장바구니 상품 수량 수정
		else if(url.equals("/cart_pdUdateAction.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_pdUdateAction.ct >>");
			
			service.cartPdUpdateAction(req, res);
			
			viewPage = req.getContextPath() +  "/cartList.ct";
			res.sendRedirect(viewPage);
			
		}
		
		// 장바구니 상품 체크박스 선택시 
		else if(url.equals("/cart_checkedAction.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_checkedAction.ct >>");
			
			service.cartPdCheckedAction(req, res);
			
			viewPage = req.getContextPath() +  "/cartList.ct";
			res.sendRedirect(viewPage);
			
		}
		
		// 장바구니 상품 체크박스 비선택시
		else if(url.equals("/cart_notCheckedAction.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_notCheckedAction.ct >>");
			
			service.cartPdNotCheckedAction(req, res);
			
			viewPage = req.getContextPath() +  "/cartList.ct";
			res.sendRedirect(viewPage);
			
		}
		
		// 장바구니 상품 추가시 중복확인(bottom)
		else if(url.equals("/cart_pdchk_bottom.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_pdchk_bottom.ct >>");
			
			service.cart_pdchk_bottom(req, res);
			viewPage = "customer/cart/cart_pdchkAction_bottom.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
			
		}
		
		// 장바구니 상품 추가시 중복확인(outer)
		else if(url.equals("/cart_pdchk_outer.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_pdchk_outer.ct >>");
			
			service.cart_pdchk_outer(req, res);
			
			viewPage = "customer/cart/cart_pdchkAction_outer.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
			
		}
		
		// 장바구니 상품 추가시 중복확인(top)
		else if(url.equals("/cart_pdchk_top.ct")) {
			System.out.println("<< 컨트롤러 url - /cart_pdchk_top.ct >>");
			
			service.cart_pdchk_top(req, res);
			
			viewPage = "customer/cart/cart_pdchkAction_top.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
			
		}
		
		// 장바구니에 상품 추가 처리페이지
		else if(url.equals("/cartAddAction.ct")) { // cartAddAction.ct : 예진언니 상세페이지에서 이 주소로 넘겨야함, 상품번호(pk)도 갖고가야함 
			System.out.println("<< 컨트롤러 url : /*.ct || /cartAddAction.ct >>");
			
			service.cartPdAddAction(req, res);
			
			viewPage = "customer/cart/cartAddAction.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
	}

}
