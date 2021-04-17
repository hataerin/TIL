package kr.co.mlec.happyhouse.paging.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mlec.happyhouse.paging.service.HouseServiceImpl;
import kr.co.mlec.happyhouse.paging.service.HouseService;
import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;

@WebServlet("/house/list6")
public class HouseList6Controller extends HttpServlet {
	
	private HouseService service;
	public HouseList6Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch (NumberFormatException nfe) {}
		
		try {
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(service.listPageHouse3(pageDto)));
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










