package pj.mvc.jsp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	 
	// ID 중복확인 처리
	@Override
	public void idConfirmAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
	}

	// 회원가입 처리
	@Override
	public void signInAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// 3단계. 화면에서 입력받은 값을 가져와서  DTO의 setter로 값 전달
		// DTO 생성
		CustomerDTO dto = new CustomerDTO();
		
		//dto set으로 값을 불러오기
		dto.setUser_id(req.getParameter("user_id"));
		dto.setUser_pwd(req.getParameter("user_pwd"));
		dto.setUser_name(req.getParameter("user_name"));
		dto.setUser_hp(req.getParameter("user_hp"));
		dto.setUser_email(req.getParameter("user_email"));
		dto.setUser_address(req.getParameter("user_address"));
		dto.setIs_admin(req.getParameter("is_admin")); // 관리자 권한 설정
		//dto.setIs_admin(false);  // 기본적으로 관리자가 아님을 설정
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		CustomerDAO dao = CustomerDAOImpl.getInstance();
				
		// 5단계. 회원가입 처리
		int insertCnt = dao.insertCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("insertCnt", insertCnt);
		
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public void loginAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		 System.out.println("서비스 - loginAction()");
		 
		// 3단계. 화면에서 입력받은 값을 가져온다.
		 String strId = req.getParameter("user_id");
         String strPassword = req.getParameter("user_pwd");
         
         // 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
         CustomerDAO dao = CustomerDAOImpl.getInstance();
         
         // 5단계. 로그인 처리
         int selectCnt = dao.idpasswordChk(strId, strPassword);
         
         // 로그인 성공시 세션ID를 설정
         if(selectCnt == 1) {
             HttpSession session = req.getSession();
             session.setAttribute("sessionID", strId);
         
         }
         
         // 6단계. jsp로 처리결과 전달
         req.setAttribute("selectCnt", selectCnt);
         
	}

	// 회원정보 인증처리 및 탈퇴 처리
	@Override
	public void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = (String)req.getSession().getAttribute("sessionID");
		String strPassword = req.getParameter("user_pwd");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		 CustomerDAO dao = CustomerDAOImpl.getInstance();
		 
		// 5단계. 회원인증 처리
		int selectCnt = dao.idpasswordChk(strId, strPassword);
		
		//회원인증 성공시
		int deleteCnt = 0;
		if(selectCnt == 1) {
			//회원탈퇴처리
			deleteCnt = dao.deleteCustomer(strId);
			//세션삭제
			req.getSession().invalidate();
		}
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("deleteCnt", deleteCnt);
		
	}

	// 회원정보 인증처리 및 상세페이지
	@Override
	public void modifyDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - modifyDetailAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = (String)req.getSession().getAttribute("sessionID");
		String strPassword = req.getParameter("user_pwd");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		 CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		 // 회원정보 인증처리 및 상세페이지
		// 5-1단계. 회원인증 처리
		int selectCnt = dao.idpasswordChk(strId, strPassword);
		
		CustomerDTO dto = null;
		if(selectCnt == 1) {
			// 5-2단계. 회원상세페이지
			dto = dao.getCustomerDetail(strId);
			
		}
		
		// 6단계. jsp로 처리결과 전달 
		req.setAttribute("dto", dto);
		req.setAttribute("user_pwd", strPassword);
		req.setAttribute("selectCnt", selectCnt);
	}

	 // 회원정보 수정처리
	@Override
	public void modifyCustomerAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		 System.out.println("서비스-modifyCustomerAction()");
		 
		// 3단계. 화면에서 입력받은 값을 가져온다.
		 CustomerDTO dto = new CustomerDTO();
		
		 dto.setUser_id((String)req.getSession().getAttribute("sessionID"));
		 dto.setUser_pwd(req.getParameter("user_pwd"));
		 dto.setUser_name(req.getParameter("user_name"));
		 dto.setUser_hp(req.getParameter("user_hp"));
		 dto.setUser_email(req.getParameter("user_email"));
		 dto.setUser_address(req.getParameter("user_address"));
		 
		 // 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		 CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		 // 5단계. 회원수정 처리
		int updateCnt = dao.updateCustomer(dto);
		 
		// 6단계. jsp로 처리결과 전달 
		req.setAttribute("updateCnt", updateCnt);
	}

}


