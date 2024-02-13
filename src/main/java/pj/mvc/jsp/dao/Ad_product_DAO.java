package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.Ad_product_DTO;

public interface Ad_product_DAO {

	// 상품 등록
	public int pdInsert(Ad_product_DTO dto);
	
	// 상품 개수
	public int pdCnt();
	
	// 상품 목록
	public List<Ad_product_DTO> pdList(int start, int end);
	
	// 상품 상세페이지
	public Ad_product_DTO pdListDetail(int pd_num);
	
	// 상품 수정
	public int pdUdate(Ad_product_DTO dto);
	
	// 상품 삭제
	public int pdDelete(int pd_num);
}
