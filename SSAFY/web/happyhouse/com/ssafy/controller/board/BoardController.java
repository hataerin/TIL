package com.ssafy.controller.board;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.board.BoardDto;
//import com.ssafy.model.MemberDto;
import com.ssafy.model.service.board.BoardService;
import com.ssafy.model.service.board.BoardServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
private BoardService boardService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		boardService = BoardServiceImpl.getBoardService();
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
		
//		if("login".equals(act)) {
////			response.sendRedirect(root + "/user/main.jsp");
//			login(request, response);		
//		}else if("logout".equals(act)) {
//			logout(request, response);
//		}else if("mvregistItem".equals(act)) {
//			response.sendRedirect(request.getContextPath() + "/product/registItem.jsp");
//		}
//		else if("registItem".equals(act)) {
//			registProduct(request, response);
//		}
//		else if("lastItem".equals(act)) {
//			response.sendRedirect(request.getContextPath() + "/product/lastItem.jsp");
//		}else if("itemList".equals(act)) {
//			listProduct(request, response);
//		}else if("deletItem".equals(act)) {
//			deleteProduct(request, response);
//		}
		
//		if("notice".equals(act)) {
//			response.sendRedirect(root + "/view/board/board.jsp");
//		}
//		else 
		if("updateBoard".equals(act)) {
			String id = request.getParameter("id");
			request.getRequestDispatcher("/view/board/updateBoard.jsp?id="+URLEncoder.encode(id, "UTF-8")).forward(request, response);
//			response.sendRedirect(root + "/view/board/updateBoard.jsp?id="+URLEncoder.encode(id, "UTF-8"));
		}
		else if("update".equals(act)) {
			updateBoard(request, response);
		}
		else if("createBoard".equals(act)) {
			request.getRequestDispatcher("/view/board/createBoard.jsp").forward(request, response);
		}
		else if("create".equals(act)) {
			createBoard(request, response);
		}
		else if("deleteBoard".equals(act)) {
			deleteBoard(request, response);
		}
		else {
			response.sendRedirect(root + "/view/board/board.jsp");
		}
	}
	
	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "/view/board/board.jsp";
		try {
			boardService.deleteBoard(Integer.parseInt(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void updateBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "/view/board/board.jsp";
		try {
			BoardDto dto = boardService.getBoard(Integer.parseInt(id));
			String title = request.getParameter("title");
	 		String content = request.getParameter("content");
	 		dto.setTitle(title);
	 		dto.setContent(content);
			boardService.modifyBoard(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void createBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
 		String content = request.getParameter("content");
 		String writer = "운영자";

		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setWriter(writer);

		String path = "/view/board/board.jsp";
		try {
			boardService.registBoard(boardDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
//	
//	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = "/main.jsp";
//		String key = request.getParameter("key");
//		String word = request.getParameter("word");
//		try {
//			List<ProductDto> list = productService.listProduct(key, word);
//			request.setAttribute("products", list);
//			path = "/product/itemList.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "상품 목록을 얻어오는 중 문제가 발생했습니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	
//	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		
//		response.sendRedirect(request.getContextPath() + "/main.jsp");
//	}
//	
//	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		String id = request.getParameter("userid");
//		String pass = request.getParameter("userpwd");
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		MemberDto memberDto = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
//			String sql = "select username, email \n";
//			sql += "from ssafy_member \n";
//			sql += "where userid = ? and userpwd = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pass);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				memberDto = new MemberDto();
//				memberDto.setUserName(rs.getString("username"));
//				memberDto.setEmail(rs.getString("email"));				
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null)
//					rs.close();
//				if(pstmt != null)
//					pstmt.close();
//				if(conn != null)
//					conn.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		String path = "/main.jsp";
//		if(memberDto != null) { // 성공
//			// session 설정
//			HttpSession session = request.getSession();
//			session.setAttribute("userinfo",  memberDto);
//		}else{ // 실패
//			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
//			path = "/main.jsp"; 
//		}
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//	}

}
