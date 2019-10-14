package service;

import vo.Game;

public interface GameInterface {

	
	public boolean insertGame(Game g);//매장내 게임등록, 등록성공 여부를 반환
	public boolean sellGame(String pCode);//게임 판매, 성공여부 반환
	public String printAll();//매장내 모든게임 전체출력
	public String printGame(String pCode);//매장내 특정게임 정보출력
	public boolean deleteGame(String pCode);//게임삭제, 삭제 성공여부 반환
	public boolean updateGame(String pCode, Game g);//게임수정, 해당 제품코드의 제품을 매개변수의 내용으로 변경, 성공여부 반환
	public String xboxIdSearch(String id);//해당 ID가 가지고있는 xbox 타이틀 검색
	public String psRegNumSearch(String psRegNum);//해당 ps 타이틀등록번호로 게임 검색
	public String internetCodeSearch(String internetCode);//해당 다운로드코드로 pc게임 검색
	public void saveData();//등록부파일저장
	public void loadData();//등록부파일불러오기
	
	//번외
	public void printInfoFile();//판매된 제품의 정보를 메모장에 요약하여 출력
	//예시
	//
	//타이틀명: DIABLO3, 가격: 23000, 수량 : 1
	//타이틀명: FABLE2, 가격: 15000, 수량 : 1
	//타이틀명: TEKKEN6, 가격: 20000, 수량 : 1
	// 합계 : 58000 원
}
