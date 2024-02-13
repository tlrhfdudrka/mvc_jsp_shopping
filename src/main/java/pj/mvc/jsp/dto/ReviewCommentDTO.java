package pj.mvc.jsp.dto;

import java.sql.Date;

public class ReviewCommentDTO {

	private int review_cmt_num; 	//PK, 댓글 일련번호
	private String user_id; 		//회원아이디중 <is_admin:N> (fk)
	private int review_num; 		//리뷰글번호 (fk)
	private String review_cmt_content; 	//글내용
	private Date review_date; 		//등록일
	
	public ReviewCommentDTO() {
		super();
	}

	public int getReview_cmt_num() {
		return review_cmt_num;
	}

	public void setReview_cmt_num(int review_cmt_num) {
		this.review_cmt_num = review_cmt_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getReview_cmt_content() {
		return review_cmt_content;
	}

	public void setReview_cmt_content(String review_cmt_content) {
		this.review_cmt_content = review_cmt_content;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	@Override
	public String toString() {
		return "ReviewCommentDTO [review_cmt_num=" + review_cmt_num + ", user_id=" + user_id + ", review_num="
				+ review_num + ", review_cmt_content=" + review_cmt_content + ", review_date=" + review_date + "]";
	}
	
	
	
}
/*
CREATE TABLE pj_reviewCmt_tbl(  
   review_cmt_num       NUMBER ,                                            --댓글 번호 (pk)
   user_id              VARCHAR2(50) REFERENCES pj_user_tbl(user_id),       --회원아이디중 <is_admin:N> (fk)
   review_num           NUMBER(7)    REFERENCES pj_review_tbl(review_num),  -- 리뷰글번호 (fk)
   review_cmt_content   CLOB         NOT NULL,                              -- 글내용
   review_date          DATE         DEFAULT sysdate                        -- 등록일
);
*/