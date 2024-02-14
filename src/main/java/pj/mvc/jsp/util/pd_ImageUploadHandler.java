package pj.mvc.jsp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// 전체 이미지 경로에서 파일명을 잘라와서 setAttribute로 전달
public class pd_ImageUploadHandler {

	private String uploadPath; // 이미지 경로 : D:\\dev\\workspace\\jsp_pj_ict02\\src\\main\\webapp\\resources\\upload
	
	public void setUploadPath(String uploadPath) {
		
		this.uploadPath = uploadPath;
	}
	
	public void imageUpload(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
		// import java.io.File;
		File uploadDir = new File(uploadPath);
		
		// 업로드할 때 폴더가 없는 경우 폴더 생성
		if(!uploadDir.exists()) {
			
			uploadDir.mkdir();
		}
		
		 try {

		        uploadDir.setWritable(true); // 업로드한 파일을
		        uploadDir.setReadable(true); // 읽고
		        uploadDir.setExecutable(true); // 실행

		        String[] imageVariables = {"pd_img1", "pd_img2", "pd_detail_img"};

		        for (String variable : imageVariables) {
		            Part part = req.getPart(variable);

		            if (part != null) {
		                System.out.println(part.getHeader("content-disposition")); // 전체 경로

		                String fileName = getFileName(part);

		                if (fileName != null && !"".contentEquals(fileName)) {
		                    part.write(uploadPath + File.separator + fileName);

		                    System.out.println("fileName : " + fileName);

		                    req.setAttribute(variable, fileName); // 각 변수에 대한 값을 service로 넘김
		                }
		            }
		        }

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		
		res.setContentType("text/html; charset=UTF-8");
		res.getWriter().println("=== 업로드 완료 ===");
	}

	private String getFileName(Part part) { 
		
		for(String content : part.getHeader("content-disposition").split(";")) { // form-data; name="컬럼명"; filename="이미지 파일명.확장자"
			
			/*
			 * 전체 경로 form-data; name="pdImg"; filename="아이폰12.png"
			 * 
			 * 1. 전체 경로에서 ; 을 기준으로 분리 >>> form-data;, name="pdImg";, filename="아이폰12.png"
			 * 2. content 내용 중 filename을 포함하면 >>> filename="아이폰12.png"
			 * 	2-1. =을 기준으로 앞에 두글자, 뒤에 한글자 제거 >>> 아이폰12.png
			 */
			
			if(content.trim().startsWith("filename")) { // content 내용 중 filename을 포함하면
				
				System.out.println("content : " + content); // content 읽고 (content : filename="이미지 파일명.확장자")
				
				// filename="이미지 파일명.확장자" : begin(= 을 기준으로 =" 제거),end(" 제거) >  이미지 파일명.확장자
				return content.substring(content.indexOf("=") + 2, content.length() - 1); // 리턴 (이미지 파일명.확장자)
			}
		}
		
		return null; // filename 없는 경우 (폼필드가 데이터인 경우)
	}
}
