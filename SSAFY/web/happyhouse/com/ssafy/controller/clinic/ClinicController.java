package com.ssafy.controller.clinic;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.clinic.PageDto;
import com.ssafy.model.service.clinic.ClinicService;
import com.ssafy.model.service.clinic.ClinicServiceImpl;


@WebServlet("/clinic")
public class ClinicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClinicService service;

	public ClinicController() {
		service = new ClinicServiceImpl();
	}
	

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
		if ("clinic".equals(act)) {
			clinic(request, response);
		}
	}

	private void clinic(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		} catch (NumberFormatException nfe) {
		}

		try {
			Map<String, Object> result = service.listPageClinic(pageDto);
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/view/clinic/clinic.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
