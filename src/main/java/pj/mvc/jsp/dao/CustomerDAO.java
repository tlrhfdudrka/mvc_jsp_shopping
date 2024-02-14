package pj.mvc.jsp.dao;

import pj.mvc.jsp.dto.CustomerDTO;

public interface CustomerDAO {

	//ID중복확인 처리
	public int useridCheck(String strUserid);
	
	//회원가입 처리
	public int insertCustomer(CustomerDTO dto);
	
	//로그인 처리 / 회원정보 인증(수정,탈퇴)
	public int idpasswordChk(String strId,String strPassword);
	
	//회원정보 인증처리 및 탈퇴 처리
	public int deleteCustomer(String strId);
	
	//회원정보 인증처리 및 상세페이지
	public CustomerDTO getCustomerDetail(String strId);
	
	//회원정보 수정 처리
	public int updateCustomer(CustomerDTO dto);
	

}
