package com.ssafy.model.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.board.BoardDto;

public interface BoardDao {
	public void registBoard(BoardDto boardDto) throws SQLException;
	
	public List<BoardDto> listBoard(String key, String word) throws SQLException;
	
	public BoardDto getBoard(int itemnum) throws SQLException;
	
	public void modifyBoard(BoardDto boardDto) throws SQLException;
	
	public void deleteBoard(int itemnum) throws SQLException;
}
