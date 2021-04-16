package kr.co.mlec.file.member.service;

import java.util.List;

import kr.co.mlec.file.repository.dao.MemberDao;
import kr.co.mlec.file.repository.dao.MemberDaoImpl;
import kr.co.mlec.file.repository.dto.FileDto;
import kr.co.mlec.file.repository.dto.MemberDto;
import kr.co.mlec.file.repository.dto.MemberFileDto;
import kr.co.mlec.file.repository.dto.MemberLangDto;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public void join(MemberDto member) throws Exception {
		/* 직접 작성하기 - 회원정보 처리하기 */
		// 회원등록 - 회원테이블

		// 회원언어등록 - 회원언어테이블
		
		// 회원파일 - 파일테이블
		
	}
}
