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

import pj.mvc.jsp.service.Us_product_Service;
import pj.mvc.jsp.service.Us_product_ServiceImpl;


@WebServlet("*.uspd")
public class Us_product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Us_product_Controller() {
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
		
		Us_product_Service service = new Us_product_ServiceImpl();
		
		// ========== Outer 상품 화면 ==========
		if(url.equals("/*.uspd") || url.equals("/product_Outer.uspd")) { 
			
			System.out.println("=== url : /product_Outer.uspd ==="); 
			
			service.usListAction(req, res);
				
			viewPage = "customer/product/us_product/product_Outer.jsp";
		}
		
		// ========== Top 상품 화면 ==========
		else if(url.equals("/product_Top.uspd")) { 
			
			System.out.println("=== url : /product_Top.uspd ==="); 
			
			service.usListAction(req, res);
				
			viewPage = "customer/product/us_product/product_Top.jsp";
		}
		
		// ========== Bottom 상품 화면 ==========
		else if(url.equals("/product_Bottom.uspd")) { 
			
			System.out.println("=== url : /product_Bottom.uspd ==="); 
			
			service.usListAction(req, res);
				
			viewPage = "customer/product/us_product/product_Bottom.jsp";
		}
		
		// ========== Outer 상품 상세화면 ==========
		else if(url.equals("/product_Outer_detail.uspd")) { 
			
			System.out.println("=== url : /product_Outer_detail.uspd ==="); 
			
			service.usListDetailAction(req, res);
				
			viewPage = "customer/product/us_product_detail/product_Outer_detail.jsp";
		}
		
		// ========== Top 상품 상세화면 ==========
		else if(url.equals("/product_Top_detail.uspd")) { 
			
			System.out.println("=== url : /product_Top_detail.uspd ==="); 
			
			service.usListDetailAction(req, res);
				
			viewPage = "customer/product/us_product_detail/product_Top_detail.jsp";
		}
		
		// ========== Bottom 상품 상세화면 ==========
		else if(url.equals("/product_Bottom_detail.uspd")) { 
			
			System.out.println("=== url : /product_Bottom_detail.uspd ==="); 
			
			service.usListDetailAction(req, res);
				
			viewPage = "customer/product/us_product_detail/product_Bottom_detail.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}
