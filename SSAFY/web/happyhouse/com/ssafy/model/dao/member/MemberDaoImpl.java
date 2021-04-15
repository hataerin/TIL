package com.ssafy.model.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.ssafy.model.dto.member.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;

	public static MemberDao getMemberDao() {
		if (memberDao == null)
			memberDao = new MemberDaoImpl();
		return memberDao;
	}

	@Override
	public MemberDto signIn(Map<String, String> signInInfo) throws Exception {
		String memberId = signInInfo.get("memberId");
		String memberPwd = signInInfo.get("memberPwd");
		MemberDto memberDto = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select membername, memberid, memberpwd, memberemail, membertell \n");
			sql.append("from member \n");
			sql.append("where memberid = ? and memberpwd = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setMemberid(rs.getString("memberid"));
				memberDto.setMembername(rs.getString("membername"));
				memberDto.setMembertell(rs.getString("membertell"));
				memberDto.setMemberpwd(rs.getString("memberpwd"));
				memberDto.setMemberemail(rs.getString("memberemail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBUtil.close(rs);
		}
		return memberDto;
	}

//	@Override
//	public MemberDto myPage(String memberId) throws Exception {
//		MemberDto memberDto = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select membername, memberid, memberpwd, memberemail, membertell \n");
//			sql.append("from member \n");
//			sql.append("where memberid = ?");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, memberId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				memberDto = new MemberDto();
//				memberDto.setMemberid(rs.getString("memberid"));
//				memberDto.setMembername(rs.getString("membername"));
//				memberDto.setMembertell(rs.getString("membertell"));
//				memberDto.setMemberpwd(rs.getString("memberpwd"));
//				memberDto.setMemberemail(rs.getString("memberemail"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			memberDto = null;
//		} finally {
//			DBUtil.close(rs);
//		}
//
//		return memberDto;
//	}

	@Override
	public void signUp(Map<String, String> signUpInfo) throws Exception {
		String memberName = signUpInfo.get("memberName");
		String memberId = signUpInfo.get("memberId");
		String memberPwd = signUpInfo.get("memberPwd");
		String memberEmail = signUpInfo.get("memberEmail");
		String memberTell = signUpInfo.get("memberTell");

		StringBuilder sql = new StringBuilder();
		sql.append("insert into member (membername, memberid, memberpwd, memberemail, membertell) ");
		sql.append("values (?, ?, ?, ?, ?)");
		DBUtil.update(sql.toString(), memberName, memberId, memberPwd, memberEmail, memberTell);

	}

	@Override
	public void update(MemberDto memberDto) throws Exception {
		String memberName = memberDto.getMembername();
		String memberPwd = memberDto.getMemberpwd();
		String memberEmail = memberDto.getMemberemail();
		String memberTell = memberDto.getMembertell();
		String memberId = memberDto.getMemberid();
		
		StringBuilder sql = new StringBuilder();
		sql.append("update member set ");
		sql.append("membername = ?, memberpwd = ?, memberemail = ?, membertell = ? ");
		sql.append("where memberid = ?");
		DBUtil.update(sql.toString(), memberName, memberPwd, memberEmail, memberTell, memberId);
		
	}

	@Override
	public void memberdelete(String memberId) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from member ");
		sql.append("where ");
		sql.append("memberid = ? ");

		DBUtil.update(sql.toString(), memberId);

	}

}
