package pj.mvc.jsp.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pj.mvc.jsp.service.CustomerServiceImpl;



@WebServlet("*.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerController() {
        super();
        
    }

    // 1단계. 웹브라우저가 전송한 HTTP 요청을 받음
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		action(req,res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	public void action(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
		
		 // 2. 클라이언트 요청 분석
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		String viewPage = "";
		CustomerServiceImpl service = new CustomerServiceImpl();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String url = uri.substring(contextPath.length());
		
		// 첫페이지
		if(url.equals("/*.do") || url.equals("/index.do")) {
			 System.out.println("<<< url ==> /index.do >>>");
			 
			 viewPage = "/common/index.jsp";
		} 
		
		
		 // -- [ 회원가입 ] -- 
		else if(url.equals("/join.do")) {
		 	System.out.println("<<< url ==> /join.do >>>");
		  
		 	viewPage = "customer/join/join.jsp"; 
		}
		 
		// 아이디 중복확인
		
		   
		
		// 회원가입 처리
	    else if(url.equals("/joinAction.do")) {
	       System.out.println("<<< url ==> /joinAction.do >>>");
	       
	       service.signInAction(req, res);
	       viewPage = "customer/join/joinAction.jsp";
	    }
	
		// -- [ 로그인 ] --
	      // 로그인 화면
	    else if(url.equals("/login.do")) {
	         System.out.println("<<< url ==> /login.do >>>");
	         
	         viewPage = "customer/login/login.jsp";
	      }
		
	      // 로그인 처리
	      else if(url.equals("/loginAction.do")) {
	         System.out.println("<<< url ==> /loginAction.do >>>");
	         
	         service.loginAction(req, res);
	         viewPage = "customer/login/loginAction.jsp";
	      }
		
		 // 로그아웃
	    else if(url.equals("/logout.do")) {
	         System.out.println("<<< url ==> /logout.do >>>");
	         
	         // 세션 삭제
	         req.getSession().invalidate(); 
	         viewPage = "common/index.jsp";
	      }
		
		//--[회원탈퇴]--
		//회원탈퇴 인증화면
	    else if(url.equals("/deleteCustomer.do")) {
	         System.out.println("<<< url ==> /deleteCustomer.do >>>");
	         
	         viewPage = "customer/join/deleteCustomer.jsp";
	      }
		
		//회원탈퇴 처리
	    else if(url.equals("/deleteCustomerAction.do")) {
	         System.out.println("<<< url ==> /deleteCustomerAction.do >>>");
	         
	         service.deleteCustomerAction(req, res);
	         viewPage = "customer/join/deleteCustomerAction.jsp";
	      }
		
		// -- [ 회원수정 ] --
	    // 회원수정 - 인증화면
	    else if(url.equals("/modifyCustomer.do")) {
	         System.out.println("<<< url ==> /modifyCustomer.do >>>");
	         
	         viewPage = "customer/join/modifyCustomer.jsp";
	      }
		
		// 회원수정 상세페이지
	    else if(url.equals("/modifyDetailAction.do")) {
	         System.out.println("<<< url ==> /modifyDetailAction.do >>>");
	         
	         service.modifyDetailAction(req, res);
	         viewPage = "customer/join/modifyDetailAction.jsp";
	      }
		// 회원수정 처리페이지
	    else if(url.equals("/modifyCustomerAction.do")) {
	         System.out.println("<<< url ==> /modifyCustomerAction.do >>>");
	         
	         service.modifyCustomerAction(req, res);
	         viewPage = "customer/join/modifyCustomerAction.jsp";
	      }
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
		     
	
	
	}


}
