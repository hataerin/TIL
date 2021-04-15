package com.ssafy.model.dao.clinic;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.clinic.ClinicDto;
import com.ssafy.model.dto.clinic.PageDto;

public interface ClinicDao {

	int selectClinicCount() throws SQLException;
	
	List<ClinicDto> selectClinic(PageDto pageDto) throws SQLException;
}
