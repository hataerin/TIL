package com.ssafy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.model.service.hospital.HospitalService;
import com.ssafy.model.service.hospital.HospitalServiceImpl;


@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		
		if ("signIn".equals(act)) {
			request.getRequestDispatcher("/view/member/signIn.jsp").forward(request, response);
		} else if ("logout".equals(act)) {
			logout(request, response);
		} else if ("myPage".equals(act)) {
			myPage(request, response);
		} else if ("signUp".equals(act)) {
			request.getRequestDispatcher("/view/member/signUp.jsp").forward(request, response);
		} else if ("intro".equals(act)) {
			request.getRequestDispatcher("/view/intro/intro.jsp").forward(request, response);
		} else if ("notice".equals(act)) {
			board(request, response);
		} else if ("houseDealList".equals(act)) {
			houseDealList(request, response);
		} else if ("sitemap".equals(act)) {
			request.getRequestDispatcher("/view/sitemap/sitemap.jsp").forward(request, response);
		} else if ("hospital".equals(act)) {
			hospital(request, response);
		} else if ("clinic".equals(act)) {
			request.getRequestDispatcher("/clinic").forward(request, response);
		} else if ("favor".equals(act)) {
			favor(request, response);
		}
	}
	

	private void favor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("memberinfo") == null) {
			request.getRequestDispatcher("/member.do?act=mvSignIn").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/view/house/houseDeal.jsp?act=favor").forward(request, response);
	}

	private void houseDealList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("memberinfo") == null) {
			request.getRequestDispatcher("/member.do?act=mvSignIn").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/view/house/houseDeal.jsp").forward(request, response);

	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(request.getSession().getAttribute("memberinfo") == null) {
			request.getRequestDispatcher("/member.do?act=mvSignIn").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/member.do?act=favor").forward(request, response);
	}
	
	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("memberinfo") == null) {
			request.getRequestDispatcher("/member.do?act=mvSignIn").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/member.do?act=myPage").forward(request, response);
	}


	private void board(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("memberinfo") == null) {
			request.getRequestDispatcher("/member.do?act=mvSignIn").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/view/board/board.jsp").forward(request, response);
	}

	private void hospital(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch (NumberFormatException nfe) {}
		
		try {
			HospitalService hospitalService = HospitalServiceImpl.getHospitalService();
			Map<String, Object> result = hospitalService.listHospital(pageDto);
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/hospital/hospital.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
