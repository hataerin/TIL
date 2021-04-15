package com.ssafy.model.service.member;

import java.util.Map;

import com.ssafy.model.dao.member.MemberDao;
import com.ssafy.model.dao.member.MemberDaoImpl;
import com.ssafy.model.dto.member.MemberDto;

public class MemberServiceImpl implements MemberService {
	private static MemberService memberService;
	private static MemberDao memberDao;

	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}

	public static MemberService getMemberService() {
		if (memberService == null)
			memberService = new MemberServiceImpl();

		return memberService;
	}

	@Override
	public MemberDto signIn(Map<String, String> signInInfo) throws Exception {
		return memberDao.signIn(signInInfo);
	}

//	@Override
//	public MemberDto myPage(String memberId) throws Exception {
//		return memberDao.myPage(memberId);
//	}

	@Override
	public void signUp(Map<String, String> signUpInfo) throws Exception {
		memberDao.signUp(signUpInfo);
	}

	@Override
	public void update(MemberDto memberDto) throws Exception {
		memberDao.update(memberDto);
	}

	@Override
	public void memberdelete(String memberId) throws Exception {
		memberDao.memberdelete(memberId);
	}


}
