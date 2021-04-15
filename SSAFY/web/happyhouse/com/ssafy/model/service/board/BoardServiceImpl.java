package com.ssafy.model.service.board;

import java.util.List;

import com.ssafy.model.dto.board.BoardDto;
import com.ssafy.model.dao.board.BoardDao;
import com.ssafy.model.dao.board.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService boardService;
	private static BoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getBoardDao();
	}
	
	public static BoardService getBoardService() {
		if(boardService == null) boardService = new BoardServiceImpl();
		return boardService;
	}

	@Override
	public void registBoard(BoardDto boardDto) throws Exception {
		if(boardDto.getTitle() == null || boardDto.getWriter() == null || boardDto.getContent() == null) {
			throw new Exception();
		}
		boardDao.registBoard(boardDto);
	}

	@Override
	public List<BoardDto> listBoard(String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return boardDao.listBoard(key, word);
	}

	@Override
	public BoardDto getBoard(int itemnum) throws Exception {
		return boardDao.getBoard(itemnum);
	}

	@Override
	public void modifyBoard(BoardDto boardDto) throws Exception {
		boardDao.modifyBoard(boardDto);
	}

	@Override
	public void deleteBoard(int itemnum) throws Exception {
		boardDao.deleteBoard(itemnum);
	}

}
