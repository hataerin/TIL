/*
 * commons-fileupload 사용 업로드 모듈화
 */
package kr.co.mlec.file.upload;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.file.member.service.MemberService;
import kr.co.mlec.file.member.service.MemberServiceImpl;
import kr.co.mlec.file.repository.dto.FileDto;
import kr.co.mlec.file.repository.dto.MemberDto;
import kr.co.mlec.file.repository.dto.MemberLangDto;
import kr.co.mlec.file.util.CommonsMultipartRequest;

@WebServlet("/upload/test11")
public class Test11 extends HttpServlet {

	private MemberService service;
	public Test11() {
		service = new MemberServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test11.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* 직접 작성하기 - 모듈화 */
			
			
			/* 직접 작성하기 - 회원 정보 파라미터 처리하기 및 디비 저장 */
			
			
			response.sendRedirect("test11");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}