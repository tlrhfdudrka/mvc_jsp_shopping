package pj.mvc.jsp.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.NoticeDAO;
import pj.mvc.jsp.dao.NoticeDAOImpl;
import pj.mvc.jsp.dto.NoticeDTO;
import pj.mvc.jsp.page.PagingNotice;

public class NoticeServiceImpl implements NoticeService {

	// 게시글 목록
	@Override
	public void noticeListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeListAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String pageNum = req.getParameter("pageNum");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		NoticeDAO dao = NoticeDAOImpl.getInstance();
		
		// 5-1단계. 전체 게시글 갯수 카운트
		PagingNotice pagingNotice = new PagingNotice(pageNum);
		int total = dao.noticeCnt();

		pagingNotice.setTotalCount(total);
		// 5-2단계. 게시글 목록 조회
		int start = pagingNotice.getStartRow();
		int end = pagingNotice.getEndRow();
		
		List<NoticeDTO> list = dao.noticeList(start, end);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("paging", pagingNotice);
		req.setAttribute("list", list);
	}

	// 게시글 상세페이지
	@Override
	public void noticeDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeDetailAction");
		// 여기만 수정함. null값으로 가져와짐
		//String noticeNumParam = req.getParameter("notice_num");
		//System.out.println("Received notice_num parameter: " + noticeNumParam);
		
		// 3단계. get방식으로 전달된 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("notice_num"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		NoticeDAO dao = NoticeDAOImpl.getInstance();
		
		// 5-1단계. 조회수 증가
		dao.plusReadCnt(num);
		
		// 5-2단계. 게시글 상세페이지
		NoticeDTO dto = dao.getNoticeDetail(num);
		
		// 5-2단계. 게시글 상세페이지
		req.setAttribute("dto", dto);
	}

	// 게시글 수정처리
	@Override
	public void noticeUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeUpdateAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_num(Integer.parseInt(req.getParameter("notice_num")));
		dto.setNotice_num(dto.getNotice_num());
		dto.setNotice_pwd(req.getParameter("notice_pwd"));
		dto.setNotice_title(req.getParameter("notice_title"));
		dto.setNotice_content(req.getParameter("notice_content"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		NoticeDAO dao = NoticeDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.updateNotice(dto);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("dto", dto);
	}

	// 게시글 삭제처리
	@Override
	public void noticeDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeDeleteAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("notice_num"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		NoticeDAO dao = NoticeDAOImpl.getInstance();
		
		// 5단계. 게시글 삭제 처리 후 컨트롤러에서 list로 이동
		dao.deleteNotice(num);
	}

	// 게시글 작성 처리
	@Override
	public void noticeInsertAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeInsertAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		NoticeDTO dto = new NoticeDTO();
		
		dto.setUser_id(req.getParameter("user_id"));
		dto.setNotice_title(req.getParameter("notice_title"));
		dto.setNotice_content(req.getParameter("notice_content"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		NoticeDAO dao = NoticeDAOImpl.getInstance();
		
		// 5단계. 게시글 작성처리 후 컨트롤러에서 list로 이동
		dao.writeNotice(dto);
	}

}
