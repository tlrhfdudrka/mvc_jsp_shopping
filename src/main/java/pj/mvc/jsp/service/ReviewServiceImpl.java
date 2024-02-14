package pj.mvc.jsp.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pj.mvc.jsp.dao.ReviewDAO;
import pj.mvc.jsp.dao.ReviewDAOImpl;
import pj.mvc.jsp.dto.ReviewCommentDTO;
import pj.mvc.jsp.dto.ReviewDTO;
import pj.mvc.jsp.page.PagingNotice;


public class ReviewServiceImpl implements ReviewService {

	// 리뷰 게시글 목록
	@Override
	public void reviewListAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("서비스 - reviewListAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String pageNume = req.getParameter("pageNum");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5-1단계. 전체 게시글 갯수 카운트
		PagingNotice pagingNotice = new PagingNotice(pageNume);
		int total = dao.boardCnt();
		System.out.println("total : " + total);
		pagingNotice.setTotalCount(total);
		
		// 5-2단계. 게시글 목록 조회
		int start = pagingNotice.getStartRow();
		int end = pagingNotice.getEndRow();
		
		//System.out.println("start : " + start);
		//System.out.println("end : " + end);
		
		List<ReviewDTO> list = dao.reviewList(start, end);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("paging", pagingNotice);
		req.setAttribute("list", list);
		
	}

	// 리뷰 게시글 상세페이지
	@Override
	public void reviewDetailAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - reviewDetailAction");
		
		// 3단계. get방식으로 전달된 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("review_num"));
		System.out.println("num------------>" + num);
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5-1단계. 조회수 증가
		
		// 5-2단계. 게시글 상세페이지
		ReviewDTO dto = dao.getBoardDetail(num);
				
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("dto", dto);
		
		
		
		
	}

	// 리뷰 게시글 수정 삭제시 비밀번호 인증
	@Override
	public int password_chkAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - password_chkAction");
		
		// 3단계. 화면에서 입력받은 값, hidden을 가져온다.
		
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5-1단계. 게시글 수정 삭제시 비밀번호 인증
		
		
		// 5-2단계. 게시글 상세페이지 => 수정페이지에 뿌린다.

		// 6단계. jsp로 처리결과 전달
		
		return 0;
	}
	
	// 리뷰 게시글 수정처리 화면
	@Override
	public void ReviewUpdate(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewUpdate");
		
		// 3단계. 화면에서 입력받은 값, hidden을 가져온다.
	    int num = Integer.parseInt(req.getParameter("hidden_num"));
	    System.out.println("num---------->" + num);
	    //int pageNum = Integer.parseInt(req.getParameter("pageNum"));
				
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		ReviewDTO dto = dao.getBoardDetail(num);	
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("dto", dto);
		//req.setAttribute("pageNum", pageNum);
	}

	

	// 리뷰 게시글 수정처리
	@Override
	public void ReviewUpdateAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewUpdateAction");
		
		
		// 3단계. 화면에서 입력받은 값, hidden값을 가져온다.
		int hidden_num = Integer.parseInt(req.getParameter("hidden_num")); 
		String hidden_img = req.getParameter("hidden_img");
		String uploadPdImg = (String) req.getAttribute("fileName");
		
		System.out.println("hidden_num-----" + hidden_num);
		System.out.println("hidden_img-----" + hidden_img);
		System.out.println("UploadPdImg-----" + uploadPdImg);
		
		// dto 생성
		ReviewDTO dto = new ReviewDTO();
		dto.setReview_num(hidden_num);
		
		
		String strRwImg ="";
		// 이미지를 수정안했을 때
		if(uploadPdImg == null) {
			strRwImg = hidden_img;
		}
		// 이미지를 수정했을 때
		else {
			strRwImg = "/mvc_jsp_shopping/resources/upload/" + uploadPdImg;  
		}
		System.out.println("이미지 : " + strRwImg);
		
		dto.setReview_img(strRwImg);
		dto.setReview_title(req.getParameter("title"));
		dto.setReview_content(req.getParameter("content"));
		//dto.setReview_pwd(req.getParameter("review_pwd"));
		
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.updateReview(dto);
		
		// 6단계. jsp로 처리결과 전달
		//req.setAttribute("dto", dto);
	}

	// 리뷰 게시글 삭제 처리
	@Override
	public void ReviewDeleteAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		ReviewDTO dto = new ReviewDTO();
		int num = Integer.parseInt(req.getParameter("hidden_num")); 
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.deletReview(num);
		
	}

	
	// 리뷰 게시글 작성 처리
	@Override
	public void ReviewInsertAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewInsertAction");
		
	    // 세션에서 사용자 아이디 가져오기
	    HttpSession session = req.getSession();
	    String sessionID = (String) session.getAttribute("sessionID");
	    
	    System.out.println("user_id=============" + sessionID);
	    
		// 3단계. 화면에서 입력받은 값을 가져온다.
		ReviewDTO dto = new ReviewDTO();
		dto.setUser_id(sessionID);
		dto.setReview_title(req.getParameter("title"));
		dto.setReview_content(req.getParameter("content"));
		
		// 이미지 가져오기 pd_file
	    // ImageUploadHandler 클래스에서 setAttribute()로 넘겼으므로 getAttribute()로 처리
	    String p_img1 = "/mvc_jsp_shopping/resources/upload/" + req.getAttribute("fileName");   // 파일명만 가져오기. 이게 이제 db로 들어가는것
	    // 이미지핸들러에서 만든 req.getAttribute("fileName") 가져오고 앞 경로는 우리가 설정해줌
	    dto.setReview_img(p_img1);
		System.out.println("이미지 : " +p_img1);
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.writeReview(dto);
		
		// 6단계. jsp로 처리결과 전달
        //req.setAttribute("insertCnt", insertCnt);
		
	}

	//////////////어드민//////////////
	// 리뷰 댓글작성 처리
	@Override
	public void commentAddAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("서비스 - commentAddAction");
		
		// 3단게. 화면으로부터 입력받은 값을 받는다.
		System.out.println("board_num : " + req.getParameter("board_num"));
		System.out.println("writer : " + req.getParameter("writer"));
		System.out.println("content : " + req.getParameter("content"));
		
		// 댓글 DTO 생성, setter
		ReviewCommentDTO dto =new ReviewCommentDTO();
		dto.setReview_num(Integer.parseInt(req.getParameter("board_num")));
		//dto.setWriter(req.getParameter("writer"));
		dto.setReview_cmt_content(req.getParameter("content"));
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 작성처리 후 컨트롤러에서 list로 이동
		dao.commentInsert(dto);
		
	}

	// 리뷰 댓글목록 처리
	@Override
	public void commentListAction(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
	System.out.println("서비스 - commentListAction");
		
		// 3단계. jQuery에서 입력받은 값을 가져온다. 보드디테일액션 data: 'board_num=${dto.num}',
		int board_num =Integer.parseInt(req.getParameter("board_num"));
		System.out.println("댓글번호 : " + board_num);
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 댓글목록 가져오기
		List<ReviewCommentDTO> list = dao.commentList(board_num);
		
		// 6단계. jsp로 처리결과 전달
		req.setAttribute("list", list);
	}

}
