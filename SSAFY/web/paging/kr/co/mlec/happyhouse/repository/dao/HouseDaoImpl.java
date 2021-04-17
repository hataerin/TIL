package kr.co.mlec.happyhouse.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;
import kr.co.mlec.happyhouse.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	
	@Override
	public List<HouseDto> selectHouse() throws SQLException {
	    List<HouseDto> list = new ArrayList<>();
	    try (
	            Connection conn = DBUtil.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(
	                        "SELECT "
	                      + "    a.*, "
	                      + "    (SELECT lng FROM houseinfo WHERE aptName = a.aptName LIMIT 1) lng, "
	                      + "    (SELECT lat FROM houseinfo WHERE aptName = a.aptName LIMIT 1) lat "
	                      + "FROM "
	                      + "    housedeal a "
	                      + "ORDER BY "
	                      + "    a.NO "
	                      + " LIMIT 10 "
	            );
	    ) {
	            ResultSet rs = pstmt.executeQuery();
	            while(rs.next()) {
	                HouseDto house = new HouseDto();
	                house.setNo(rs.getInt("no"));
	                house.setDong(rs.getString("dong"));
	                house.setAptName(rs.getString("aptName"));
	                house.setDealAmount(rs.getString("dealAmount"));
	                house.setBuildYear(rs.getString("buildYear"));
	                house.setDealYear(rs.getString("dealYear"));
	                house.setDealMonth(rs.getString("dealMonth"));
	                house.setDealDay(rs.getString("dealDay"));
	                house.setArea(rs.getString("area"));
	                house.setFloor(rs.getString("floor"));
	                house.setJibun(rs.getString("jibun"));
	                
	                
	                
	                house.setLat(rs.getString("lat"));
	                house.setLng(rs.getString("lng"));
	                list.add(house);
	            }
	            return list;
	    }
	}

	@Override
	public List<HouseDto> selectHouse(PageDto pageDto) throws SQLException {
		List<HouseDto> list = new ArrayList<>();
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT "
						  + "	a.*, "
						  + "	(SELECT lng FROM houseinfo WHERE aptName = a.aptName LIMIT 1) lng, "
						  + "	(SELECT lat FROM houseinfo WHERE aptName = a.aptName LIMIT 1) lat "
						  + "FROM "
						  + "	housedeal a "
						  + "ORDER BY "
						  + "	a.NO "
						  + " LIMIT ?, ? "
				);
		) {
			int index = 1;
			pstmt.setInt(index++, pageDto.getBegin());
			pstmt.setInt(index++, pageDto.getListSize());
			
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					HouseDto house = new HouseDto();
					house.setNo(rs.getInt("no"));
					house.setDong(rs.getString("dong"));
					house.setAptName(rs.getString("aptName"));
					house.setDealAmount(rs.getString("dealAmount"));
					house.setBuildYear(rs.getString("buildYear"));
					house.setDealYear(rs.getString("dealYear"));
					house.setDealMonth(rs.getString("dealMonth"));
					house.setDealDay(rs.getString("dealDay"));
					house.setArea(rs.getString("area"));
					house.setFloor(rs.getString("floor"));
					house.setJibun(rs.getString("jibun"));
					house.setLat(rs.getString("lat"));
					house.setLng(rs.getString("lng"));
					list.add(house);
				}
				return list;
		}
	}

	@Override
	public int selectHouseCount() throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT count(*) "
						  + "	FROM housedeal a"
				);
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}
}
