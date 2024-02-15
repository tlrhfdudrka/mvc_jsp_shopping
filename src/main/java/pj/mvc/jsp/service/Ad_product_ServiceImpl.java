package pj.mvc.jsp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pj.mvc.jsp.page.ad_Paging;
import pj.mvc.jsp.dao.Ad_product_DAO;
import pj.mvc.jsp.dao.Ad_product_DAOImpl;
import pj.mvc.jsp.dto.Ad_product_DTO;

public class Ad_product_ServiceImpl implements Ad_product_Service {

	// 상품 등록
	@Override
	public void pdInsertAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdInsertAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다
		// dto 생성 후 setter로 값 담는다.
		Ad_product_DTO dto = new Ad_product_DTO();
		
		dto.setPd_name(req.getParameter("pd_name"));
		
		String fileName1 = (String) req.getAttribute("pd_img1");
	    String fileName2 = (String) req.getAttribute("pd_img2");
	    String fileName3 = (String) req.getAttribute("pd_detail_img");

	    
	    System.out.println(req.getAttribute("pd_img1"));
		System.out.println(req.getAttribute("pd_img2"));
		System.out.println(req.getAttribute("pd_detail_img"));
		
		
	    String p_img1 = "/mvc_jsp_shopping/resources/upload/" + fileName1;
	    String p_img2 = "/mvc_jsp_shopping/resources/upload/" + fileName2;
	    String p_detail_img = "/mvc_jsp_shopping/resources/upload/" + fileName3;

	    dto.setPd_img1(p_img1);
	    dto.setPd_img2(p_img2);
	    dto.setPd_detail_img(p_detail_img);
		dto.setPd_price(Integer.parseInt(req.getParameter("pd_price")));
		dto.setPd_stuck(Integer.parseInt(req.getParameter("pd_stuck")));
		
		String p_category = req.getParameter("category_num");
		int category = 0;
		
		if ("Outer".equals(p_category)) {
			
		    category = 1;
		    
		} else if ("Top".equals(p_category)) {
			
		    category = 2;
		    
		} else if ("Bottom".equals(p_category)) {
			
		    category = 3;
		}
		
		dto.setCategory_num(category);
		dto.setPd_content(req.getParameter("pd_content"));
		
		System.out.println(req.getParameter("pd_name"));
		System.out.println(p_img1);
		System.out.println(p_img2);
		System.out.println(p_detail_img);
		System.out.println(Integer.parseInt(req.getParameter("pd_price")));
		System.out.println(Integer.parseInt(req.getParameter("pd_stuck")));
		System.out.println(category);
		System.out.println(req.getParameter("pd_content"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Ad_product_DAO dao = Ad_product_DAOImpl.getInstance();
		
		// 5단계. 상품정보 insert
		int insertCnt = dao.pdInsert(dto);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("insertCnt", insertCnt);
	}

	// 상품 목록
	@Override
	public void pdListAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdListAction");
		
		// 3단계. get방식에서 입력받은 값을 가져온다
		String pageNum = req.getParameter("pageNum");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Ad_product_DAO dao = Ad_product_DAOImpl.getInstance();
		
		// 5-1단계. 상품 개수
		int total = dao.pdCnt();
		System.out.println("total : " + total);
		
		// 5-2단계. 상품 목록
		ad_Paging paging = new ad_Paging(pageNum);
		paging.setTotalCount(total);
		
		// 페이지당 몇행부터 몇행까지 가지고 올지
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<Ad_product_DTO> list = dao.pdList(start, end);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
	}

	// 상품 상세페이지
	@Override
	public void pdListDetailAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdListDetailAction");

		System.out.println(req.getParameter("pd_num"));
		System.out.println(req.getParameter("pageNum"));
		
		// 3단계. get방식에서 입력받은 값(ad_product_list.jsp에서 수정버튼 클릭시 넘어가는 url에서 넘긴 값)을 가져온다
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));  // WHERE절에 태우기 위함
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); // 해당페이지의 목록으로 가기 위해 pageNum을 가져온것
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Ad_product_DAOImpl dao = Ad_product_DAOImpl.getInstance();
				
		// 5단계. 상품 상세 페이지
		Ad_product_DTO dto = dao.pdListDetail(pd_num);
		System.out.println("dto : " + dto);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("pd_num", pd_num);
		req.setAttribute("dto", dto);
	}

	// 상품 수정
	@Override
	public void pdUdateAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		System.out.println("Ad_product_ServiceImp - pdUdateAction");
		
		// 3단계. 화면에서 입력받은 값, hidden값을 가져온다.
		String hiddenPageNum = req.getParameter("hiddenPageNum");
		int hiddenPdNum = Integer.parseInt(req.getParameter("hiddenPdNum"));
		
		String hiddenPdImg1 = req.getParameter("hiddenPdImg1");
		String hiddenPdImg2 = req.getParameter("hiddenPdImg2");
		String hiddenPdImgDe = req.getParameter("hiddenPdImgDe"); // 기존값
		
		String uploadPdImg1 = (String)req.getAttribute("pd_img1");
	    String uploadPdImg2 = (String)req.getAttribute("pd_img2");
	    String uploadPdImgDe = (String)req.getAttribute("pd_detail_img"); // 신규값
		  
		System.out.println("hiddenPdImg1 : " + hiddenPdImg1);
		System.out.println("hiddenPdImg2 : " + hiddenPdImg2);
		System.out.println("hiddenPdImgDe : " + hiddenPdImgDe);
		
		System.out.println("uploadPdImg1 : " + uploadPdImg1);
		System.out.println("uploadPdImg2 : " + uploadPdImg2);
		System.out.println("uploadPdImgDe : " + uploadPdImgDe);
		  
		// dto 생성후 setter로 값을 담는다.
		Ad_product_DTO dto = new Ad_product_DTO();
		  
		dto.setPd_num(hiddenPdNum);
		
		dto.setPd_name(req.getParameter("pd_name"));
		dto.setPd_price(Integer.parseInt(req.getParameter("pd_price")));
		dto.setPd_stuck(Integer.parseInt(req.getParameter("pd_stuck")));
		
		String p_category = req.getParameter("category_num");
		int category = 0;
		
		if ("Outer".equals(p_category)) {
			
		    category = 1;
		    
		} else if ("Top".equals(p_category)) {
			
		    category = 2;
		    
		} else if ("Bottom".equals(p_category)) {
			
		    category = 3;
		}
		
		dto.setCategory_num(category);
		dto.setPd_content(req.getParameter("pd_content"));
		  
		String strPdImg1 = "";
		String strPdImg2 = "";
		String strPdImgDe = "";
		  
		// 이미지를 수정 안했을 때
		if(uploadPdImg1 == null) {
			  
		   strPdImg1 = hiddenPdImg1;
		}
		  
		// 이미지를 수정 했을 때
		else {
			  
		   strPdImg1 = "/mvc_jsp_shopping/resources/upload/" + uploadPdImg1;
		}
		
		// 이미지를 수정 안했을 때
		if(uploadPdImg2 == null) {
			  
		   strPdImg2 = hiddenPdImg2;
		}
		  
		// 이미지를 수정 했을 때
		else {
			  
		   strPdImg2 = "/mvc_jsp_shopping/resources/upload/" + uploadPdImg2;
		}
		
		// 이미지를 수정 안했을 때
		if(uploadPdImgDe == null) {
			  
		   strPdImgDe = hiddenPdImgDe;
		}
		  
		// 이미지를 수정 했을 때
		else {
			  
			strPdImgDe = "/mvc_jsp_shopping/resources/upload/" + uploadPdImgDe;
		}
		  
		System.out.println("이미지 : " + strPdImg1);
		System.out.println("이미지 : " + strPdImg2);
		System.out.println("이미지 : " + strPdImgDe);
		
		dto.setPd_img1(strPdImg1);
	    dto.setPd_img2(strPdImg2);
	    dto.setPd_detail_img(strPdImgDe);
	  
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Ad_product_DAO dao = Ad_product_DAOImpl.getInstance();
	  
	  	// 5단계. 상품정보 insert
	  	int updateCnt = dao.pdUdate(dto);
	  
	  	// 6단계. jsp로 처리결과 전달
		req.setAttribute("updateCnt", updateCnt);
		req.setAttribute("hiddenPageNum", hiddenPageNum); 
		req.setAttribute("hiddenPdNum", hiddenPdNum);
	}

	// 상품 삭제
	@Override
	public void pdDeleteAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdDeleteAction");
		
		// 3단계. get방식에서 입력 받은 값을 가져온다.
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		Ad_product_DAO dao = Ad_product_DAOImpl.getInstance();
		
		// 5단계. 상품정보 delete
		 int deleteCnt = dao.pdDelete(pd_num);
		
		// 6단계. jsp로 처리결과 전달
		 req.setAttribute("deleteCnt", deleteCnt);
	}
}
