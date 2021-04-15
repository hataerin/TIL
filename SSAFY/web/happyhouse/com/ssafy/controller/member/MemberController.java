package com.ssafy.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.member.MemberDto;
import com.ssafy.model.service.member.MemberService;
import com.ssafy.model.service.member.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = MemberServiceImpl.getMemberService();
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
		if ("mvSignIn".equals(act)) {
			request.getRequestDispatcher("/view/member/signIn.jsp").forward(request, response);
		} else if ("signIn".equals(act)) {
			signIn(request, response);
		} else if ("myPage".equals(act)) {
			myPage(request, response);
		} else if ("signUp".equals(act)) {
			signUp(request, response);
		} else if ("update".equals(act)) {
			update(request, response);
		} else if ("memberdelete".equals(act)) {
			memberdelete(request, response);
		}

	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/index.jsp";
		MemberDto memberDto = null;

		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		Map<String, String> signInInfo = new HashMap<>();
		signInInfo.put("memberId", memberId);
		signInInfo.put("memberPwd", memberPwd);
		try {
			memberDto = memberService.signIn(signInInfo);
			if (memberDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberinfo", memberDto);
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			memberDto = null;
			path = "/view/member/signIp.jsp";
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/view/member/mypage.jsp";

		HttpSession session = request.getSession();

		request.getRequestDispatcher(path).forward(request, response);

	}

	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberEmail = request.getParameter("memberEmail");
		String memberTell = request.getParameter("memberTell");
		Map<String, String> signUpInfo = new HashMap<>();
		signUpInfo.put("memberName", memberName);
		signUpInfo.put("memberId", memberId);
		signUpInfo.put("memberPwd", memberPwd);
		signUpInfo.put("memberEmail", memberEmail);
		signUpInfo.put("memberTell", memberTell);

		try {
			memberService.signUp(signUpInfo);
		} catch (Exception e) {
			path = "/view/member/signUp.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDto memberDto = new MemberDto();

		String path = "/index.jsp";
		String meberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberEmail = request.getParameter("memberEmail");
		String memberTell = request.getParameter("memberTell");
		memberDto.setMembertell(memberTell);
		memberDto.setMemberpwd(memberPwd);
		memberDto.setMembername(meberName);
		memberDto.setMemberid(memberId);
		memberDto.setMemberemail(memberEmail);

		try {
			memberService.update(memberDto);
			HttpSession session = request.getSession();
			session.setAttribute("memberinfo", memberDto);
			path = "/view/member/mypage.jsp";
		} catch (Exception e) {
			memberDto = null;
			path = "/index.jsp";
			e.printStackTrace();
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	private void memberdelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String path = "/index.jsp";
		String memberId = request.getParameter("memberId");

		try {
			memberService.memberdelete(memberId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(root + path);
	}
}
