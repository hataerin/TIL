package kr.co.mlec.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;

public interface HouseDao {

	List<HouseDto> selectHouse() throws SQLException;
	int selectHouseCount() throws SQLException;
	List<HouseDto> selectHouse(PageDto pageDto) throws SQLException;

}
