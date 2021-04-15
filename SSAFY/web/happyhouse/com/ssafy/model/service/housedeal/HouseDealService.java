package com.ssafy.model.service.housedeal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.housedeal.HouseDealDto;
import com.ssafy.model.dto.paging.PageDto;

public interface HouseDealService {

//	public Map<String, Object> listHouseDeal(String key, String word) throws Exception;
	
	public Map<String, Object> listHouseDeal(PageDto pageDto, String key, String word) throws Exception;
	
	public HouseDealDto getHouseDeal(int no) throws Exception;

	List<String> listFavor(String memberId) throws Exception;
	
	int selectFavorCount(String memberId) throws Exception;
	
	void deleteFavor(String memberId, String dong) throws SQLException;

	void insertFavor(String memberId, String dong) throws SQLException;
	
//	public void registProduct(ProductDto productDto) throws Exception;
	
//	public List<ProductDto> listProduct(String key, String word) throws Exception;
	
//	public ProductDto getProduct(int itemnum) throws Exception;
	
//	public void modifyProduct(ProductDto productDto) throws Exception;
	
//	public void deleteProduct(int itemnum) throws Exception;

}
