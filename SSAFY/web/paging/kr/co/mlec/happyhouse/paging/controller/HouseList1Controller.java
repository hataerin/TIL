package kr.co.mlec.happyhouse.paging.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.happyhouse.paging.service.HouseServiceImpl;
import kr.co.mlec.happyhouse.paging.service.HouseService;
import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;

@WebServlet("/house/list1")
public class HouseList1Controller extends HttpServlet {
	
	private HouseService service;
	public HouseList1Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch (NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listPageHouse2(pageDto);
			request.setAttribute("list", result.get("list"));
			
			// 마지막 페이지 구하기
			int count = (Integer)result.get("count");
			int lastPage = (int)Math.ceil(count / 10d);
			
			request.setAttribute("pageNo", pageDto.getPageNo());// 요청한 페이지 번호
			request.setAttribute("count", count);// 게시물 전체 개수
			request.setAttribute("lastPage", lastPage);// 하단에 출력될 마지막 페이지 번호
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/house/list1.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	public static void main(String[] args) {
		for(int cnt = 1; cnt <= 30; cnt++) {
//			System.out.println(cnt % 10 == 0 ? cnt / 10 : cnt / 10 + 1);
			System.out.println((int)Math.ceil(cnt / 10d));
		}
	}
}










