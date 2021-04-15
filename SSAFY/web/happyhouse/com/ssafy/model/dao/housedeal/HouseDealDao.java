package com.ssafy.model.dao.housedeal;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.model.dto.housedeal.HouseDealDto;
import com.ssafy.model.dto.paging.PageDto;

public interface HouseDealDao {
//	public void registHouseDeal(HouseDealDto productDto) throws SQLException;

//	public List<HouseDealDto> listHouseDeal(String key, String word) throws SQLException;

	public List<HouseDealDto> listHouseDeal(PageDto pageDto, String key, String word) throws SQLException;
	
	public HouseDealDto getHouseDeal(int no) throws SQLException;

	int selectHouseCount() throws SQLException;
	
	List<String> listFavor(String memberId) throws SQLException;
	
	int selectFavorCount(String memberId) throws SQLException;
	
	void deleteFavor(String memberId, String dong) throws SQLException;

	void insertFavor(String memberId, String dong) throws SQLException;
	
//	public void modifyHouseDeal(HouseDealDto productDto) throws SQLException;
	
//	public void deleteHouseDeal(int itemnum) throws SQLException;
}
