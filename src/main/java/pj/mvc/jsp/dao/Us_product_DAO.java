package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.Us_product_DTO;

public interface Us_product_DAO {

	public int usCnt(int category_num);
	public List<Us_product_DTO> usListAction();
	public Us_product_DTO udDetailList(int pd_num);
}
