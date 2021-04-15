package com.ssafy.controller.hospital;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.service.hospital.HospitalService;
import com.ssafy.model.service.hospital.HospitalServiceImpl;

@WebServlet("/hospital")
public class HospitalController extends HttpServlet {
	private HospitalService hospitalService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		hospitalService = HospitalServiceImpl.getHospitalService();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");

		if("hospital".equals(act)) {
//			try {
//				List<HospitalDto> result = hospitalService.listHospital();
//				request.setAttribute("result", result);
//				
//				RequestDispatcher rd = request.getRequestDispatcher("/hospital/hospital.jsp");
//				rd.forward(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new ServletException(e);
//			}
		}
	}
}