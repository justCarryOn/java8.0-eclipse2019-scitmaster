package service;

import java.util.ArrayList;

import dao.BoardDAO;
import vo.Board;
import vo.Member;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	public boolean insertMember(Member mem) {
		boolean flag = true;

		flag = dao.insertMember(mem);

		return flag;
	}

	public Member selectMember(Member mem) {
		Member result = null;

		result = dao.selectMember(mem);

		return result;
	}

	public boolean deleteMember(Member mem) {
		boolean flag = true;

		flag = dao.deleteMember(mem);

		return flag;
	}

	public boolean insertBoard(Board b) {
		boolean flag = true;

		flag = dao.insertBoard(b);

		return flag;
	}

	public ArrayList<Board> selectAllBoard() {

		return dao.selectAllBoard();
	}
	
	public Board selectBoard(String boardSeq) {
		
		return dao.selectBoard(boardSeq);
	}
	
	public void deleteBoard(String boardSeq) {
		dao.deleteBoard(boardSeq);
	}
	
	public void updateBoard(Board b) {
		dao.updateBoard(b);
	}
}
