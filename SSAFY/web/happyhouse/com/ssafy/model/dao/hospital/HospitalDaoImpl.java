package com.ssafy.model.dao.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.util.DBUtil;


public class HospitalDaoImpl implements HospitalDao {
	
	private static HospitalDao hospitalDao;
	
	private HospitalDaoImpl() {}
	
	public static HospitalDao getHospitalDao() {
		if(hospitalDao == null) hospitalDao = new HospitalDaoImpl();
		return hospitalDao;
	}
	
	@Override
	public List<HospitalDto> listHospital() throws SQLException {
		List<HospitalDto> list = new ArrayList<HospitalDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, date, sido, gugun_name, hospital, address, applytype, repnumber\n");
			sql.append("from hospital \n");

			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while(rs.next()) {
				HospitalDto hospitalDto = new HospitalDto();
				hospitalDto.setNo(rs.getString("no"));
				hospitalDto.setDate(rs.getString("date"));
				hospitalDto.setSido(rs.getString("sido"));
				hospitalDto.setGugunName(rs.getString("gugun_name"));
				hospitalDto.setHospital(rs.getString("hospital"));
				hospitalDto.setAddress(rs.getString("address"));
				hospitalDto.setApplytype(rs.getString("applytype"));
				hospitalDto.setRepnumber(rs.getString("repnumber"));
				
				list.add(hospitalDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public int selectHospitalCount() throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT count(*) "
						  + "	FROM hospital"
				);
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}

	@Override
	public List<HospitalDto> listHospital(PageDto pageDto) throws SQLException {
		List<HospitalDto> list = new ArrayList<>();
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT "
						  + "	* "
						  + "FROM "
						  + "	hospital "
						  + "ORDER BY "
						  + "	no "
						  + " LIMIT ?, ? "
				);
		) {
			int index = 1;
			pstmt.setInt(index++, pageDto.getBegin());
			pstmt.setInt(index++, pageDto.getListSize());
			
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					HospitalDto hospitalDto = new HospitalDto();
					hospitalDto.setNo(rs.getString("no"));
					hospitalDto.setDate(rs.getString("date"));
					hospitalDto.setSido(rs.getString("sido"));
					hospitalDto.setGugunName(rs.getString("gugun_name"));
					hospitalDto.setHospital(rs.getString("hospital"));
					hospitalDto.setAddress(rs.getString("address"));
					hospitalDto.setApplytype(rs.getString("applytype"));
					hospitalDto.setRepnumber(rs.getString("repnumber"));
					list.add(hospitalDto);
				}
				return list;
		}
	}

}
