package com.ssafy.model.service.housedeal;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.model.dao.housedeal.HouseDealDao;
import com.ssafy.model.dao.housedeal.HouseDealDaoImpl;
import com.ssafy.model.dto.housedeal.HouseDealDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.model.dto.paging.PageResultDto;

public class HouseDealServiceImpl implements HouseDealService {
	private static HouseDealService houseDealService;
	private static HouseDealDao houseDealDao;
	
	private HouseDealServiceImpl() {
		houseDealDao = HouseDealDaoImpl.getHouseDealDao();
	}
	
	public static HouseDealService getHouseDealService() {
		if(houseDealService == null) houseDealService = new HouseDealServiceImpl();
		return houseDealService;
	}

//	@Override
//	public Map<String, Object> listHouseDeal(String key, String word) throws Exception {
//		key = key == null ? "" : key;
//		word = word == null ? "" : word;
//		int count = houseDealDao.selectHouseCount();
//		List<HouseDealDto> list = houseDealDao.listHouseDeal(key, word);
//		
//		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
//		Map<String, Object> result = new HashMap<>();
//		result.put("list", list);
//		result.put("pageResult", prd);
//		return result;
//	}

	@Override
	public Map<String, Object> listHouseDeal(PageDto pageDto, String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		int count = houseDealDao.selectHouseCount();
		List<HouseDealDto> list = houseDealDao.listHouseDeal(pageDto, key, word);
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		prd.calculator();
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}

	@Override
	public HouseDealDto getHouseDeal(int no) throws Exception {
		return houseDealDao.getHouseDeal(no);
	}

	@Override
	public List<String> listFavor(String memberId) throws Exception {
		return houseDealDao.listFavor(memberId);
	}

	@Override
	public void deleteFavor(String memberId, String dong) throws SQLException {
		houseDealDao.deleteFavor(memberId, dong);
	}

	@Override
	public void insertFavor(String memberId, String dong) throws SQLException {
		houseDealDao.insertFavor(memberId, dong);
	}
	
	@Override
	public int selectFavorCount(String memberId) throws Exception {
		return 0;
	}
}
