package kr.co.mlec.happyhouse.paging.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.happyhouse.repository.dao.HouseDao;
import kr.co.mlec.happyhouse.repository.dao.HouseDaoImpl;
import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;
import kr.co.mlec.happyhouse.repository.dto.PageResultDto;

public class HouseServiceImpl implements HouseService {
	private HouseDao dao;
	public HouseServiceImpl() {
		dao = new HouseDaoImpl();
	}
	
	@Override
	/**
	 * 페이징 없이 사용
	 */
	public List<HouseDto> listPageHouse1() throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse();
		return list;
	}
	@Override
	/**
	 * 페이징 사용 -1
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listPageHouse2(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse(pageDto);
		
		// 페이징을 위해서 게시물 전체 개수
		int count = dao.selectHouseCount();
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("count", count);
		return result;
	}
	
	@Override
	/**
	 * 페이징 사용 - 2 : 페이징 모듈화하기
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listPageHouse3(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<HouseDto> list = dao.selectHouse(pageDto);
		
		// 페이징을 위해서 게시물 전체 개수
		int count = dao.selectHouseCount();
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}
}
