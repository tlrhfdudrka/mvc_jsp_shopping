package pj.mvc.jsp.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.page.us_Paging2;
import pj.mvc.jsp.dao.Us_product_DAO;
import pj.mvc.jsp.dao.Us_product_DAOImpl;
import pj.mvc.jsp.dto.Us_product_DTO;

public class Us_product_ServiceImpl implements Us_product_Service {

	// 상품 목록
	@Override
	public void usListAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Us_product_ServiceImpl - usListAction");
		
		String pageNum = req.getParameter("pageNum");
		int category_num = Integer.parseInt(req.getParameter("category_num")); 
		System.out.println(req.getParameter("category_num"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Us_product_DAO dao = Us_product_DAOImpl.getInstance();
	    
	    // 5-1단계. 상품 개수
	    int total = dao.usCnt(category_num);
	    System.out.println("total : " + total);
	    
	    us_Paging2 us_Paging2 = new us_Paging2(pageNum);
	    us_Paging2.setTotalCount(total);
	    
	    // 5-2단계. 상품 목록
	    List<Us_product_DTO> list = dao.usListAction();
	    
	    // 6단계. jsp로 처리결과 전달
	    req.setAttribute("paging2", us_Paging2);
	    req.setAttribute("list", list);
	}

	// 상품 상세페이지
	@Override
	public void usListDetailAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Us_product_ServiceImpl - usListDetailAction");
		
		// 3단계. get방식에서 입력받은 값(ad_product_list.jsp에서 수정버튼 클릭시 넘어가는 url에서 넘긴 값)을 가져온다
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));  // WHERE절에 태우기 위함
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); // 해당페이지의 목록으로 가기 위해 pageNum을 가져온것
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Us_product_DAO dao = Us_product_DAOImpl.getInstance();
				
		// 5단계. 상품 상세 페이지
		Us_product_DTO dto = dao.udDetailList(pd_num);
		System.out.println("dto : " + dto);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("pd_num", pd_num);
		req.setAttribute("dto", dto);
	}

}
