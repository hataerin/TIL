package com.ssafy.model.service.hospital;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.dto.paging.PageDto;



public interface HospitalService {
	Map<String, Object> listHospital(PageDto pageDto) throws Exception;
}
