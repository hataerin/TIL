package com.ssafy.model.service.clinic;

import java.util.Map;

import com.ssafy.model.dto.clinic.PageDto;


public interface ClinicService {
	Map<String, Object> listPageClinic(PageDto pageDto) throws Exception;
}
