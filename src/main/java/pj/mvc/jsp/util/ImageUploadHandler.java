package pj.mvc.jsp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ImageUploadHandler {

   private String uploadPath;      // 이미지 경로
   
   public void setUploadPath(String uploadPath) {
      this.uploadPath = uploadPath;
   }
   
   public void imageUpload(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
      
      File uploadDir = new File(uploadPath);
      
      // 업로드할 경우에 폴더가 없는 경우 폴더 생성
      if(!uploadDir.exists()) {
         uploadDir.mkdir();
      }
      
      try {
         uploadDir.setWritable(true);   
         uploadDir.setReadable(true);   
         uploadDir.setExecutable(true); 

         String fileName = "";
         for(Part part : req.getParts()) {  
            System.out.println(part.getHeader("content-disposition"));
            
            fileName = getFileName(part);  
            if(fileName != null && !"".contentEquals(fileName)) {   //!"".contentEquals(fileName) fileName이 공백이 아닌경우
               part.write(uploadPath + File.separator + fileName);   // fileName을 정상적으로 가져왔을때
               
               System.out.println("fileName : " + fileName);
               req.setAttribute("fileName", fileName);   // Service에서 getAttribute();로 받기위함
            }
         }
         
      } catch(FileNotFoundException e) {
         e.printStackTrace();
      }
      
      res.setContentType("text/html; charset=UTF-8");
      res.getWriter().println("=== 업로드 완료 ===");
      
      
   }

   // 선택한 이미지(예 : 트롬세탁기.jpg) 리턴
   private String getFileName(Part part) {
      
      for(String content : part.getHeader("content-disposition").split(";")) { 
         if(content.trim().startsWith("filename")) {  
            System.out.println("content : " + content);
            
            return content.substring(content.indexOf("=") + 2, content.length() - 1);
         }
      } 
      return null;   // filename 없는 경우(폼필드가 데이터인 경우)
   }
}