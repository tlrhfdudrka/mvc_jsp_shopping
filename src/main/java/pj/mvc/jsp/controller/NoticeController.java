package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.NoticeServiceImpl;

@WebServlet("*.nt")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeController() {
        super();
    }
    
    // 1단계. 웹브라우저가 전송한 HTTP 요청을 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void action(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		// ---------------------- [ 관리자 Controller ] ----------------------
		// 2. 클라이언트 요청 분석
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = "";
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		
		// 첫페이지
		if(url.equals("/*.nt") || url.equals("/ad_noticeList.nt")) {
			System.out.println("<<< url ==> /ad_noticeList.nt >>>");
			
			service.noticeListAction(request, response);
			viewPage = "admin/csCenter/board/notice/ad_noticeList.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		// 상세페이지
		else if(url.equals("/ad_notice_detailAction.nt")) {
			System.out.println("<<< url ==> /ad_notice_detailAction.nt");
			
			service.noticeDetailAction(request, response);
			viewPage = "admin/csCenter/board/notice/ad_notice_detailAction.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
		}
		
		/*
		// 게시글 수정 삭제시 - 비밀번호 인증처리
		else if(url.equals("/notice_pwd_chkAciton.nt")) {
			System.out.println("<<< url ==> /notice_pwd_chkAciton.nt");
			
			int result = service.notice_pwd_chkAciton(request, response);
			
			if(result != 0) { // 인증성공시
				viewPage ="admin/csCenter/board/notice/ad_notice_edit.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
			else {	// 인증실패시 비밀번호 불일치로 그 페이지에 머물되 num과 error메세지를 넘긴다
				System.out.println("<<< 비밀번호 불일치 >>>");
				int num = Integer.parseInt(request.getParameter("hidden_num"));
				viewPage = request.getContextPath() + "/ad_notice_detailAction.nt?num=" + num + "&message=error";
				response.sendRedirect(viewPage);
			}
			
		}*/
		
		// 게시글 수정 화면
		else if(url.equals("/ad_notice_edit.nt")) {
			System.out.println("<<< url ==> /ad_notice_edit.nt >>>");
			
			service.noticeDetailAction(request, response);
			viewPage ="admin/csCenter/board/notice/ad_notice_edit.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		// 게시글 수정 처리
		else if(url.equals("/notice_updateAction.nt")) {
			System.out.println("<<< url ==> /notice_updateAction.nt >>>");
			
			service.noticeUpdateAction(request, response);
			viewPage = request.getContextPath() + "/ad_noticeList.nt";
			
			response.sendRedirect(viewPage); //noticeList.bc 여기로 다시 돌아가라. forward랑 같이 사용불가
		}
		
		// 게시글 삭제 처리
		else if(url.equals("/notice_deleteAction.nt")) {
			System.out.println("<<< url ==> /notice_deleteAction.nt >>> ");
			
			service.noticeDeleteAction(request, response);
			viewPage = request.getContextPath() + "/ad_noticeList.nt";
			response.sendRedirect(viewPage); //noticeList.bc 여기로 다시 돌아가라. forward랑 같이 사용불가
		}
		
		// 게시글 작성 화면
		else if(url.equals("/ad_notice_insert.nt")) {
			System.out.println("<<< url ==> /ad_notice_insert.nt >>>");
			
			viewPage ="admin/csCenter/board/notice/ad_notice_insert.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		// 게시글 작성 처리
		else if(url.equals("/notice_insertAction.nt")) {
			System.out.println("<<< url ==> /notice_insertAction.nt >>>");
			
			service.noticeInsertAction(request, response);
			
			viewPage = request.getContextPath() + "/ad_noticeList.nt";
			response.sendRedirect(viewPage);
		}
		
		// ---------------------- [ 회원 Controller ] ----------------------
		
		// 첫페이지
		if(url.equals("/noticeList.nt")) {
			System.out.println("<<< url ==> /noticeList.nt >>>");
			
			service.noticeListAction(request, response);
			viewPage = "customer/board/notice/noticeList.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		// 상세페이지
		else if(url.equals("/notice_detailAction.nt")) {
			System.out.println("<<< url ==> /notice_detailAction.nt");
			
			service.noticeDetailAction(request, response);
			viewPage = "customer/board/notice/notice_detailAction.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
		}
	}
}
