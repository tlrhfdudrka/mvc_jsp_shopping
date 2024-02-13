package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Us_product_Service {

	// 상품 목록
	public void usListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
		
	// 상품 상세페이지
	public void usListDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
}
