/*
 * Apache Commons를 이용한 파일 업로드 처리하기 
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/upload/test06")
public class Test06 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test06.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadRoot = "/Users/mrson/SSAFY/upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String filePath = "/commons" + sdf.format(new Date());
		File file = new File(uploadRoot, filePath);
		if (file.exists() == false) file.mkdirs();
		
		try {
			/* 직접 작성하기 - Apache Commons 라이브러리 사용하기 */
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("test06");
	}
}