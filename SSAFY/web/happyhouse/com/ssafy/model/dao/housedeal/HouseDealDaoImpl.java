package com.ssafy.model.dao.housedeal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ssafy.model.dto.housedeal.HouseDealDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao {
	
	private static HouseDealDao houseDealDao;
	
	private HouseDealDaoImpl() {}
	
	public static HouseDealDao getHouseDealDao() {
		if(houseDealDao == null) houseDealDao = new HouseDealDaoImpl();
		return houseDealDao;
	}

//	@Override
//	public List<HouseDealDto> listHouseDeal(String key, String word) throws SQLException {
//		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select no, dong, aptname, code, dealamount, buildyear, dealyear, dealmonth, dealday, area, floor, jibun, type, rentmoney\n");
//			sql.append("from housedeal \n");
//			// key : 컬럼 | word : 키워드
//			if(!word.isEmpty()) {
////				if("subject".equals(key)) {
////					sql.append("where subject like ? \n");
////				} else {
//					sql.append("where " + key + " like ? \n");
////				}
//			}
//			sql.append("order by no\n");
//			sql.append("limit ?, ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			
//			if(!word.isEmpty()) {
////				if("subject".equals(key))
//					pstmt.setString(1, "%" + word + "%");
////				else
////					pstmt.setString(1, word);
//			}
//
//			int index = 1;
//			pstmt.setInt(index++, pageDto.getBegin());
//			pstmt.setInt(index++, pageDto.getListSize());
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				HouseDealDto houseDealDto = new HouseDealDto();
//				houseDealDto.setNo(rs.getString("no"));
//				houseDealDto.setDong(rs.getString("dong"));
//				houseDealDto.setAptname(rs.getString("aptname"));
//				houseDealDto.setCode(rs.getString("code"));
//				houseDealDto.setDealamount(rs.getString("dealamount"));
//				houseDealDto.setBuildyear(rs.getString("buildyear"));
//				houseDealDto.setDealyear(rs.getString("dealyear"));
//				houseDealDto.setDealmonth(rs.getString("dealmonth"));
//				houseDealDto.setDealday(rs.getString("dealday"));
//				houseDealDto.setArea(rs.getString("area"));
//				houseDealDto.setFloor(rs.getString("floor"));
//				houseDealDto.setJibun(rs.getString("jibun"));
//				houseDealDto.setType(rs.getString("type"));
//				houseDealDto.setRentmoney(rs.getString("rentmoney"));
//				
//				list.add(houseDealDto);
//			}
//		} finally {
//			DBUtil.close(rs, pstmt, conn);
//		}
//		return list;
//	}

	@Override
	public List<HouseDealDto> listHouseDeal(PageDto pageDto, String key, String word) throws SQLException {
		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, dong, aptname, code, dealamount, buildyear, dealyear, dealmonth, dealday, area, floor, jibun, type, rentmoney\n");
			sql.append("from housedeal \n");
			// key : 컬럼 | word : 키워드
			if(!word.isEmpty()) {
//				if("subject".equals(key)) {
//					sql.append("where subject like ? \n");
//				} else {
					sql.append("where " + key + " like ? \n");
//				}
			}
			sql.append("order by no\n");
			sql.append("limit ?, ?");
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			if(!word.isEmpty()) {
//				if("subject".equals(key))
					pstmt.setString(index++, "%" + word + "%");
//				else
//					pstmt.setString(1, word);
			}
			
			pstmt.setInt(index++, pageDto.getBegin());
			pstmt.setInt(index++, pageDto.getListSize());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDealDto houseDealDto = new HouseDealDto();
				houseDealDto.setNo(rs.getString("no"));
				houseDealDto.setDong(rs.getString("dong"));
				houseDealDto.setAptname(rs.getString("aptname"));
				houseDealDto.setCode(rs.getString("code"));
				houseDealDto.setDealamount(rs.getString("dealamount"));
				houseDealDto.setBuildyear(rs.getString("buildyear"));
				houseDealDto.setDealyear(rs.getString("dealyear"));
				houseDealDto.setDealmonth(rs.getString("dealmonth"));
				houseDealDto.setDealday(rs.getString("dealday"));
				houseDealDto.setArea(rs.getString("area"));
				houseDealDto.setFloor(rs.getString("floor"));
				houseDealDto.setJibun(rs.getString("jibun"));
				houseDealDto.setType(rs.getString("type"));
				houseDealDto.setRentmoney(rs.getString("rentmoney"));
				
				list.add(houseDealDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public HouseDealDto getHouseDeal(int no) throws SQLException {
		HouseDealDto houseDealDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, dong, aptname, code, dealamount, buildyear, dealyear, dealmonth, dealday, area, floor, jibun, type, rentmoney \n");
			sql.append("from housedeal \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				houseDealDto = new HouseDealDto();
				houseDealDto.setNo(rs.getString("no"));
				houseDealDto.setDong(rs.getString("dong"));
				houseDealDto.setAptname(rs.getString("aptname"));
				houseDealDto.setCode(rs.getString("code"));
				houseDealDto.setDealamount(rs.getString("dealamount"));
				houseDealDto.setBuildyear(rs.getString("buildyear"));
				houseDealDto.setDealyear(rs.getString("dealyear"));
				houseDealDto.setDealmonth(rs.getString("dealmonth"));
				houseDealDto.setDealday(rs.getString("dealday"));
				houseDealDto.setArea(rs.getString("area"));
				houseDealDto.setFloor(rs.getString("floor"));
				houseDealDto.setJibun(rs.getString("jibun"));
				houseDealDto.setType(rs.getString("type"));
				houseDealDto.setRentmoney(rs.getString("rentmoney"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return houseDealDto;
	}


	@Override
	public int selectHouseCount() throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT count(*)"
					+ "FROM housedeal a"
				);
		){
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}

	@Override
	public List<String> listFavor(String memberId) throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"select dong \r\n" + 
						"from favor\r\n" + 
						"where memberid = ?;"
				)
		){
			List<String> list = new ArrayList<>();
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("dong"));
			}
			return list;
		}
	}

	@Override
	public void deleteFavor(String memberId, String dong) throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"delete \r\n" + 
						"from favor \r\n" + 
						"where memberid = ?"
						+ " and"
						+ " dong = ?;"
				)
		){
			pstmt.setString(1, memberId);
			pstmt.setString(2, dong);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void insertFavor(String memberId, String dong) throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"insert \r\n" + 
						"into favor \r\n" + 
						"(memberid, dong) " +
						"values(?, ?)"
				)
		){
			pstmt.setString(1, memberId);
			pstmt.setString(2, dong);
			pstmt.executeUpdate();
		}
	}

	@Override
	public int selectFavorCount(String memberId) throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT count(*)"
					+ "FROM favor"
					+ "where memberId = ?"
				);
		){
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}
	
}