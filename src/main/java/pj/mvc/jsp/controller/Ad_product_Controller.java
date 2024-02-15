package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pj.mvc.jsp.util.pd_ImageUploadHandler;
import pj.mvc.jsp.service.Ad_product_ServiceImpl;


@WebServlet("*.pd")
@MultipartConfig(location="D:\\dev\\workspace\\mvc_jsp_shopping\\src\\main\\webapp\\resources\\upload",
	fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class Ad_product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String IMG_UPLOAD_DIR = "D:\\dev\\workspace\\mvc_jsp_shopping\\src\\main\\webapp\\resources\\upload";
       
    public Ad_product_Controller() {
        super();
    }

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
		
		req.setCharacterEncoding("UTF-8");
		String viewPage = "";
		
		String uri = req.getRequestURI(); 
		String contextPath = req.getContextPath(); 
		String url = uri.substring(contextPath.length()); 
		
		pd_ImageUploadHandler uploader = null;
		
		Ad_product_ServiceImpl service = new Ad_product_ServiceImpl();
		
		// ========== 상품 목록 화면 ==========
		if(url.equals("/*.pd") || url.equals("/product_list.pd")) { 
			
			System.out.println("=== url : /product_list.pd ==="); 
			
			service.pdListAction(req, res);
			
			viewPage = "admin/ad_product/product_list.jsp";
		}
		
		// ========== 상품 등록 화면 ==========
		else if(url.equals("/product_add.pd")) { 
			
			System.out.println("=== url : /product_add.pd ==="); 
			
			viewPage = "admin/ad_product/product_add.jsp";
		}
		
		// ========== 상품 등록 처리 ==========
		else if (url.equals("/product_addAction.pd")) {

            System.out.println("=== url : /product_addAction.pd ===");

            String contentType = req.getContentType();
			
            if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {

                uploader = new pd_ImageUploadHandler();

                uploader.setUploadPath(IMG_UPLOAD_DIR); // 이미지 경로 전달

                // 각 이미지 변수에 대한 업로드 처리
                for (int i = 1; i <= 3; i++) {
                	
                    Part part = req.getPart("pd_img" + i);
                    
                    if (part != null) {
                    	
                        uploader.imageUpload(req, res);
                    }
                }
            }
			
            service.pdInsertAction(req, res);

            viewPage = "admin/ad_product/product_addAction.jsp";
        }
		
		// 상품 상세페이지 화면
		else if(url.equals("/product_listDetail.pd")) { 
			
			System.out.println("=== url : /product_listDetail.pd ===");
			
			service.pdListDetailAction(req, res);
			
			viewPage = "admin/ad_product/product_listDetail.jsp";
		}
		
		// 상품 수정 처리
		else if(url.equals("/product_editAction.pd")) { 
			
			System.out.println("=== url : /product_editAction.pd ===");
			
			String contentType = req.getContentType();
			
            if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {

                uploader = new pd_ImageUploadHandler();

                uploader.setUploadPath(IMG_UPLOAD_DIR); // 이미지 경로 전달

                // 각 이미지 변수에 대한 업로드 처리
                for (int i = 1; i <= 3; i++) {
                	
                    Part part = req.getPart("pd_img" + i);
                    
                    if (part != null) {
                    	
                        uploader.imageUpload(req, res);
                    }
                }
            }
            
			service.pdUdateAction(req, res);
			
			viewPage = "admin/ad_product/product_editAction.jsp";
		}
		
		// 상품 삭제 처리
		else if(url.equals("/product_deleteAction.pd")) { 
			
			System.out.println("=== url : /product_deleteAction.pd ===");
			
			service.pdDeleteAction(req, res);
			
			viewPage = "admin/ad_product/product_deleteAction.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}
