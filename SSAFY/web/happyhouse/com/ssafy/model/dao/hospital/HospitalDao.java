package com.ssafy.model.dao.hospital;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.hospital.HospitalDto;
import com.ssafy.model.dto.paging.PageDto;

public interface HospitalDao {
	List<HospitalDto> listHospital() throws SQLException;
	int selectHospitalCount() throws SQLException;
	List<HospitalDto> listHospital(PageDto pageDto) throws SQLException;
}
