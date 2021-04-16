package kr.co.mlec.file.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.mlec.file.repository.dto.MemberDto;
import kr.co.mlec.file.repository.dto.MemberFileDto;
import kr.co.mlec.file.repository.dto.MemberLangDto;
import kr.co.mlec.file.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	@Override
	public void insertMember(MemberDto member) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member (id, name, password, profileName, profilePath) ");
		sql.append("values (?, ?, ?, ?, ?)");
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			int index = 1;
			pstmt.setString(index++, member.getId());
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getProfileName());
			pstmt.setString(index++, member.getProfilePath());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public void insertMemberLang(MemberLangDto memberLang) throws SQLException {
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into member_lang (id, lang) values(?, ?)");
				) {
			int index = 1;
			pstmt.setString(index++, memberLang.getId());
			pstmt.setString(index++, memberLang.getLang());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public void insertMemberFile(MemberFileDto fildDto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member_file ( ");
		sql.append("	id, path, orgName, systemName, contentType, size ");
		sql.append(") values ( ");
		sql.append("	?, ?, ?, ?, ?, ? ");
		sql.append(") ");
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			int index = 1;
			pstmt.setString(index++, fildDto.getId());
			pstmt.setString(index++, fildDto.getPath());
			pstmt.setString(index++, fildDto.getOrgName());
			pstmt.setString(index++, fildDto.getSystemName());
			pstmt.setString(index++, fildDto.getContentType());
			pstmt.setLong(index++, fildDto.getSize());
			pstmt.executeUpdate();
		}
	}
}
