package com.ssafy.model.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.board.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao BoardDao;
	
	private BoardDaoImpl() {}
	
	public static BoardDao getBoardDao() {
		if(BoardDao == null) BoardDao = new BoardDaoImpl();
		return BoardDao;
	}
	
	@Override
	public void registBoard(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board (title, writer, content) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setString(index++, boardDto.getTitle());
			pstmt.setString(index++, boardDto.getWriter());
			pstmt.setString(index++, boardDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BoardDto> listBoard(String key, String word) throws SQLException {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, title, writer, content, boarddate\n");
			sql.append("from board \n");
//			if(!word.isEmpty()) {
//				if("subject".equals(key)) {
//					sql.append("where subject like ? \n");
//				} else {
//					sql.append("where " + key + " = ? \n");
//				}
//			}
//			sql.append("order by itemnum desc \n");
			pstmt = conn.prepareStatement(sql.toString());
//			if(!word.isEmpty()) {
//				if("subject".equals(key))
//					pstmt.setString(1, "%" + word + "%");
//				else
//					pstmt.setString(1, word);
//			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setId(rs.getInt("id"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setBoarddate(rs.getTimestamp("boarddate"));
				
				list.add(boardDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public BoardDto getBoard(int itemnum) throws SQLException {
		BoardDto boardDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, title, writer, content, boarddate\n");
			sql.append("from board \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, itemnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setId(rs.getInt("id"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setBoarddate(rs.getTimestamp("boarddate"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return boardDto;
	}

	@Override
	public void modifyBoard(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update board \n");
			sql.append("set title = ?, writer = ?, content = ? \n");
			sql.append("where id = ?");
			DBUtil.update(sql.toString(), boardDto.getTitle(), boardDto.getWriter(), boardDto.getContent(), boardDto.getId());
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public void deleteBoard(int itemnum) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from board \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, itemnum);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

}
