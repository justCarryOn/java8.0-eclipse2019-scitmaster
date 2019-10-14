package service;

import vo.Game;

public interface GameInterface {

	
	public boolean insertGame(Game g);//���峻 ���ӵ��, ��ϼ��� ���θ� ��ȯ
	public boolean sellGame(String pCode);//���� �Ǹ�, �������� ��ȯ
	public String printAll();//���峻 ������ ��ü���
	public String printGame(String pCode);//���峻 Ư������ �������
	public boolean deleteGame(String pCode);//���ӻ���, ���� �������� ��ȯ
	public boolean updateGame(String pCode, Game g);//���Ӽ���, �ش� ��ǰ�ڵ��� ��ǰ�� �Ű������� �������� ����, �������� ��ȯ
	public String xboxIdSearch(String id);//�ش� ID�� �������ִ� xbox Ÿ��Ʋ �˻�
	public String psRegNumSearch(String psRegNum);//�ش� ps Ÿ��Ʋ��Ϲ�ȣ�� ���� �˻�
	public String internetCodeSearch(String internetCode);//�ش� �ٿ�ε��ڵ�� pc���� �˻�
	public void saveData();//��Ϻ���������
	public void loadData();//��Ϻ����Ϻҷ�����
	
	//����
	public void printInfoFile();//�Ǹŵ� ��ǰ�� ������ �޸��忡 ����Ͽ� ���
	//����
	//
	//Ÿ��Ʋ��: DIABLO3, ����: 23000, ���� : 1
	//Ÿ��Ʋ��: FABLE2, ����: 15000, ���� : 1
	//Ÿ��Ʋ��: TEKKEN6, ����: 20000, ���� : 1
	// �հ� : 58000 ��
}
