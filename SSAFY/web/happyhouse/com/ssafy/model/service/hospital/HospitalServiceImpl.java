package com.ssafy.model.service.hospital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.model.dao.hospital.HospitalDao;
import com.ssafy.model.dao.hospital.HospitalDaoImpl;
import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.dto.paging.PageDto;
import com.ssafy.model.dto.paging.PageResultDto;


public class HospitalServiceImpl implements HospitalService {
	
	private static HospitalService hospitalService;
	private static HospitalDao hospitalDao;
	
	private HospitalServiceImpl() {
		hospitalDao = HospitalDaoImpl.getHospitalDao();
	}
	
	public static HospitalService getHospitalService() {
		if(hospitalService == null) hospitalService = new HospitalServiceImpl();
		return hospitalService;
	}
	
	public Map<String, Object> listHospital(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<HospitalDto> list = hospitalDao.listHospital(pageDto);
		
		// 페이징을 위해서 게시물 전체 개수
		int count = hospitalDao.selectHospitalCount();
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}
}