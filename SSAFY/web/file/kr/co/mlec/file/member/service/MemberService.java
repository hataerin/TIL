package kr.co.mlec.file.member.service;

import kr.co.mlec.file.repository.dto.MemberDto;

public interface MemberService {
	void join(MemberDto member) throws Exception;
}
