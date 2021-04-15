package com.ssafy.model.service.clinic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.model.dao.clinic.ClinicDao;
import com.ssafy.model.dao.clinic.ClinicDaoImpl;
import com.ssafy.model.dto.clinic.ClinicDto;
import com.ssafy.model.dto.clinic.PageDto;
import com.ssafy.model.dto.clinic.PageResultDto;


public class ClinicServiceImpl implements ClinicService{
	private ClinicDao dao;
	public ClinicServiceImpl() {
		dao = new ClinicDaoImpl();
	}
	@Override
	public Map<String, Object> listPageClinic(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
				List<ClinicDto> list = dao.selectClinic(pageDto);
				// 페이징을 위해서 게시물 전체 갯수
				int count = dao.selectClinicCount();
				PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
				Map<String, Object> result = new HashMap<>();
				result.put("list", list);
				result.put("pageResult", prd);
				return result;
	}

}
