/*
 *   여러파일 업로드 하기
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload/test03")
public class Test03 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test03.jsp").forward(request, response);
	}
	
	// 파일 여러개 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest mRequest = new MultipartRequest(
				request,  
				"파일이 저장될 서버의 경로",
				1024 * 1024 * 100, 
				"utf-8",  
				new DefaultFileRenamePolicy() 
		);
		
		/* 직접 작성하기 - 여러개의 파일 처리하기 */
		
		
		response.sendRedirect("test03");
	}
}






