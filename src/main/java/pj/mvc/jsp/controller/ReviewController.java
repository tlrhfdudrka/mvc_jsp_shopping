package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.ReviewServiceImpl;
import pj.mvc.jsp.util.ImageUploadHandler;

@WebServlet("*.rw")
@MultipartConfig(location="D:\\dev\\workspace\\mvc_jsp_shopping\\src\\main\\webapp\\resources\\upload", // 이미지추가
fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String IMG_UPLOAD_DIR = "D:\\dev\\workspace\\mvc_jsp_shopping\\src\\main\\webapp\\resources\\upload"; // 이미지추가
	
	public ReviewController() {
		super();
	}

	//두포스트는 두갯을 호출하고 두갯은 액션 호출
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
		
	// 2. 클라이언트 요청 분석
		
	// 한글 안깨지게 처리
	request.setCharacterEncoding("UTF-8");
	String viewPage =""; //선언
	
				
	ReviewServiceImpl service = new ReviewServiceImpl();
				
	String uri = request.getRequestURI();
	//System.out.println("uri : " + uri); // uri : /mvc_jsp_shopping/*.rw
	
	String contextPath = request.getContextPath();
	//System.out.println("contextPath(프로젝트명) : " + contextPath);  // contextPath(프로젝트명) : /mvc_jsp_shopping
	
	String url = uri.substring(contextPath.length());
	//System.out.println("url : " + url); // url : /*.rw
	
	ImageUploadHandler uploader = null; // 작성 이미지추가
	
	// 첫페이지
	if(url.equals("/*.rw") || url.equals("/board_reviewList.rw")) {
		System.out.println("<<<url ==> /board_reviewList.rw\" >>>");
		
		
		service.reviewListAction(request, response);
		viewPage = "customer/board/review/board_reviewList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
		
	// 상세페이지
	else if(url.equals("/board_review.rw")) {
		System.out.println("<<<url ==> ///board_review.rw >>>");
		
		service.reviewDetailAction(request, response);
		viewPage = "customer/board/review/board_review.jsp";
		
		//RequestDispatcher : 서블릿 또는 JSP 요청을 받은 후, 다른 컴포넌트로 요청을 위임하는 클래스이다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	
		// 리뷰 게시글 수정 화면
		else if(url.equals("/review_Edit.rw")) {	// 원래 "/review_Edit.rw"
			System.out.println("<<<url ==> ///review_Edit.rw >>>");	//"<<<url ==> ///review_Edit.rw >>>"
			
			service.ReviewUpdate(request, response);
			viewPage = "customer/board/review/board_reviewEdit.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
		}
		
		// 리뷰 게시글 수정 처리
		else if(url.equals("/board_reviewEdit.rw")) {
			System.out.println("<<<url ==> ///board_reviewEdit.rw >>>");
	
	    	  // 추가 : 서비스 호출전에 추가
	          String contentType = request.getContentType();
	          if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
	             uploader = new ImageUploadHandler();
	             uploader.setUploadPath(IMG_UPLOAD_DIR);   // img 경로 setUploadPath() => 상단 private static final String IMG_UPLOAD_DIR
	             uploader.imageUpload(request, response);
	          }
	          
			service.ReviewUpdateAction(request, response);
			viewPage = request.getContextPath() + "/board_reviewList.rw";
			
			response.sendRedirect(viewPage); 
	
		}
		
		// 리뷰 게시글 삭제 처리
		else if(url.equals("/review_deleteAction.rw")) {
			System.out.println("<<<url ==> ///review_deleteAction.rw >>>");
			
			service.ReviewDeleteAction(request, response);
			viewPage = request.getContextPath() + "/board_reviewList.rw";
			
			response.sendRedirect(viewPage); 
		}
		
		
		// 리뷰 게시글 작성 화면
		else if(url.equals("/review_insert.rw")) {
			System.out.println("<<<url ==> ///review_insert.rw >>>");
			
			viewPage = "customer/board/review/board_insert.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
		}
		
		// 리뷰 게시글 작성 처리 
		
		   else if(url.equals("/review_insertAction.rw")) {
		   System.out.println("<<<url ==> ///review_insertAction.rw >>>");
		   
	       // 추가 : 서비스 호출전에 추가 이미지추가
	       String contentType = request.getContentType();
	       if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
	          uploader = new ImageUploadHandler();
	          uploader.setUploadPath(IMG_UPLOAD_DIR);   // 이미지 경로 추가 setUploadPath() => 상단 private static final String IMG_UPLOAD_DIR
	          uploader.imageUpload(request, response);
	  		
	       }
		   
		   service.ReviewInsertAction(request, response); 
		   viewPage = request.getContextPath() + "/board_reviewList.rw";
		  
		   response.sendRedirect(viewPage); }
		 
//			
//		
//		//////////////////어드민/////////////////
//		// 댓글 작성 처리
//		else if(url.equals("/comment_insert.rw")) {
//			System.out.println("<<<url ==> //comment_insert.rw >>>");
//				
//			service.commentAddAction(request, response); //5.
//			
//		}
//		
//		// 댓글 목록 처리
//		else if(url.equals("/comment_list.rw")) {
//			System.out.println("<<<url ==> //comment_list.rw >>>");
//				
//			service.commentListAction(request, response); 
//			viewPage = "customer/admin/csCenter/comment_list.jsp"; //경로확인필요
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//			dispatcher.forward(request, response);
//		}
	}
		
}
