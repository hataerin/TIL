package com.ssafy.controller.housedeal;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import com.ssafy.model.dto.housedeal.HouseDealDto;
import com.ssafy.model.dto.member.MemberDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.model.service.housedeal.HouseDealService;
import com.ssafy.model.service.housedeal.HouseDealServiceImpl;


@WebServlet("/houseDeal")
public class HouseDealController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int BASIC_CODE = 100;
	private static final int BUILDING_NAME_CODE = 200;
	private static final int DONG_NAME_CODE = 300;
	
	private HouseDealService houseDealService;
	private PageDto pageDto;
	
	@Override
	public void init() throws ServletException {
		super.init();
		houseDealService = HouseDealServiceImpl.getHouseDealService();
		pageDto = new PageDto();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		System.out.println(act);
		if("houseDealList".equals(act)) { // houseDeal?act=houseDealList
			processRequest(request, response, BASIC_CODE);
		}else if("searchHouseDealName".equals(act)){ // houseDeal?act=searchHouseDealName
			processRequest(request, response, BUILDING_NAME_CODE);
		}else if("searchHouseDealDong".equals(act)){ // houseDeal?act=searchHouseDealDong
			processRequest(request, response, DONG_NAME_CODE);
		}else if("favorInsert".equals(act)){
			// insert
			insertFavor(request, response);
		}else if("favorDelete".equals(act)){
			// delete
			deleteFavor(request, response);
		}
	}
	
	private void insertFavor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(((MemberDto)session.getAttribute("memberinfo")).getMemberid());
		String dongName = (String)request.getParameter("dongName");
		try {
			houseDealService.insertFavor(((MemberDto)session.getAttribute("memberinfo")).getMemberid(), (String)request.getParameter("dongName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String pageNo = Integer.toString(pageDto.getPageNo());
	    String root = request.getContextPath();
	    String path = "/houseDeal?act=searchHouseDealDong&pageNo="+ pageNo +"&dongName=" + URLEncoder.encode(dongName);
		response.sendRedirect(root + path);
	}
	
	private void deleteFavor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String deleteDongName = (String)request.getParameter("deleteDongName");
		System.out.println(deleteDongName);
		try {
			houseDealService.deleteFavor(((MemberDto)session.getAttribute("memberinfo")).getMemberid(), deleteDongName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String dongName = (String)request.getParameter("dongName");
        String pageNo = Integer.toString(pageDto.getPageNo());
        String root = request.getContextPath();
        String path = "/houseDeal?act=searchHouseDealDong&pageNo="+ pageNo +"&dongName=" + URLEncoder.encode(dongName);
		response.sendRedirect(root + path);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response, int processCode) throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			try {
				pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}catch(NumberFormatException nfe) {}
			
			Map<String, Object> map = houseDealService.listHouseDeal(pageDto, "", "");
			HttpSession session = request.getSession(); 
			
			switch(processCode) {
				case BASIC_CODE: break;
				case BUILDING_NAME_CODE:
					String buildingName = request.getParameter("buildingName");
//					System.out.println(buildingName);
					if(buildingName != null && buildingName != "")
						map = getBnFilteredList(pageDto, buildingName);
					request.setAttribute("buildingName", buildingName);
					break;
				case DONG_NAME_CODE:
					String dongName = request.getParameter("dongName");
//					System.out.println(dongName);
					if(dongName != null && dongName != "")
						map = getDongFilteredList(pageDto, dongName);
					request.setAttribute("dongName", dongName);
			}
			List<String> fList = listFavor(((MemberDto)session.getAttribute("memberinfo")).getMemberid());
			map.put("favorList", fList);
			request.setAttribute("result", map);
			path = "/view/house/houseDeal.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "상품 목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private List<String> listFavor(String memberId) throws Exception {
		return houseDealService.listFavor(memberId);
	}

	private Map<String, Object> getBnFilteredList(PageDto pageDto, String buildingName) throws Exception{
		String key = "AptName";
		Map<String, Object> map = houseDealService.listHouseDeal(pageDto, key, buildingName);
		return map;
	}

//	private List<HouseDealDto> getBnFilteredList(List<HouseDealDto> list, String filter){
//		List<HouseDealDto> filteredList = new ArrayList<>();
//		for(HouseDealDto hd : list) {
//			if(hd.getAptname().contains(filter))
//				filteredList.add(hd);
//		}
//		return filteredList;
//	}
	
	private Map<String, Object> getDongFilteredList(PageDto pageDto, String dongName) throws Exception{
		String key = "dong";
		Map<String, Object> map = houseDealService.listHouseDeal(pageDto, key, dongName);
		return map;
	}
	
//	private List<HouseDealDto> getDongFilteredList(List<HouseDealDto> list, String filter){
//		List<HouseDealDto> filteredList = new ArrayList<>();
//		for(HouseDealDto hd : list) {
//			if(hd.getDong().contains(filter))
//				filteredList.add(hd);
//		}
//		return filteredList;
//	}
	
//	private Map<String, Object> getHouseDeals(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String key = request.getParameter("key");
//		String word = request.getParameter("word");
//		Map<String, Object> map = houseDealService.listHouseDeal(pageDto, key, dongName);
//		return map;
//	}
}