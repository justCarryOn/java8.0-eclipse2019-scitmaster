package service;

import dao.BoardDAO;
import vo.Member;

public class BoardService {

	private BoardDAO dao=new BoardDAO();
	
	public boolean insertMember(Member mem) {
		boolean flag=true;
		
		flag=dao.insertMember(mem);
		
		return flag;
	}
	
	public Member selectMember(Member mem) {
		Member result=null;
		
		result=dao.selectMember(mem);
		
		return result;
	}
	
	public boolean deleteMember(Member mem) {
		boolean flag=true;
		
		flag=dao.deleteMember(mem);
		
		return flag;
	}
}





