package com.ssafy.model.dao.clinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.clinic.ClinicDto;
import com.ssafy.model.dto.clinic.PageDto;
import com.ssafy.util.DBUtil;

public class ClinicDaoImpl implements ClinicDao{

	

	@Override
	public int selectClinicCount() throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    	"SELECT count(*) "
						    + 	"FROM clinic a "
				);
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}

	@Override
	public List<ClinicDto> selectClinic(PageDto pageDto) throws SQLException {
		List<ClinicDto> list = new ArrayList<>();
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT "
						  + "	a.* "
						  + "FROM "
						  + "	clinic a "
						  + "ORDER BY "
						  + "	a.no "
						  + " LIMIT ?, ? "
				);
		) {
			
			int index = 1;
			pstmt.setInt(index++, pageDto.getBegin());
			pstmt.setInt(index++, pageDto.getListSize());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ClinicDto clinic = new ClinicDto();
					clinic.setNo(rs.getString("no"));
					clinic.setDate(rs.getString("date"));
					clinic.setSamplecollection(rs.getString("samplecollection"));
					clinic.setSido(rs.getString("sido"));
					clinic.setGugunName(rs.getString("gugun_name"));
					clinic.setHospital(rs.getString("hospital"));
					clinic.setAddress(rs.getString("address"));
					clinic.setWeekdaytime(rs.getString("weekdaytime"));
					clinic.setSaturdaytime(rs.getString("saturdaytime"));
					clinic.setHolidaytime(rs.getString("holidaytime"));
					clinic.setRepnumber(rs.getString("repnumber"));
					list.add(clinic);
				}
				return list;
		}
	}
}
