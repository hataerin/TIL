/*
 *   파일 업로드 프로그램 작성
 *   1. 업로드 라이브러리 다운로드
 *      : mvnrepository.com 사이트 접속후 cos 검색
 *      : 2002 11 월 버전 다운로드
 *      : WEB-INF/lib 폴더에 붙여넣기
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload/test02")
public class Test02 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test02.jsp").forward(request, response);
	}
	
	// 파일 서버에 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 직접 작성하기 - 파라미터값 확인하기 */
		String msg1 = request.getParameter("msg1");
		String msg2 = request.getParameter("msg2");
		System.out.println("msg1 : " + msg1);
		System.out.println("msg2 : " + msg2);
		
		/* 직접 작성하기 - cos.jar 라이브러리 사용하기 */
		MultipartRequest mRequest = new MultipartRequest(
				request, // 파싱 될 수 있도록 요청 객체 넘기기
				"c:/SSAFY/upload", // 사용자가 전송한 파일을 저장할 서버의 디렉토리
				1024 * 1024 * 10, // 전송되는 요청데이터의 전체 크기
				"utf-8", // 요청 스트림의 인코딩
				new DefaultFileRenamePolicy()
		);
		
		
		response.sendRedirect("test02");
	}
}






