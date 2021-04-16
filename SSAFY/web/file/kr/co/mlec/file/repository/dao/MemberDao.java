package kr.co.mlec.file.repository.dao;

import java.sql.SQLException;

import kr.co.mlec.file.repository.dto.MemberDto;
import kr.co.mlec.file.repository.dto.MemberFileDto;
import kr.co.mlec.file.repository.dto.MemberLangDto;

public interface MemberDao {
	void insertMember(MemberDto memberDto) throws SQLException;
	void insertMemberLang(MemberLangDto memberLangDto) throws SQLException;
	void insertMemberFile(MemberFileDto memberLangDto) throws SQLException;
}
