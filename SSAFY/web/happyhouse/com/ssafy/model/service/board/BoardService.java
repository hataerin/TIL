package com.ssafy.model.service.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardDto;

public interface BoardService {
	public void registBoard(BoardDto boardDto) throws Exception;
	
	public List<BoardDto> listBoard(String key, String word) throws Exception;
	
	public BoardDto getBoard(int itemnum) throws Exception;
	
	public void modifyBoard(BoardDto boardDto) throws Exception;
	
	public void deleteBoard(int itemnum) throws Exception;
}
