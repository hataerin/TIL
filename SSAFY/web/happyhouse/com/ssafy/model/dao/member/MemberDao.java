package com.ssafy.model.dao.member;

import java.util.Map;

import com.ssafy.model.dto.member.MemberDto;

public interface MemberDao {
	// 로그인
	public MemberDto signIn(Map<String, String> signInInfo) throws Exception;
	
	
//	// 회원 정보 조회
//	public MemberDto myPage(String memberId) throws Exception;
//	
//	
	// 회원 가입
	public void signUp(Map<String, String> signUpInfo) throws Exception;

	// 회원 정보 수정
	public void update(MemberDto memberDto) throws Exception;
	
	// 회원 탈퇴
	public void memberdelete(String memberId) throws Exception;
}
