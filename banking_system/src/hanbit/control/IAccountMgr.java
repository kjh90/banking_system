package hanbit.control;

public interface IAccountMgr {
	public void newAccount();			//������
	public void deposit();				//�Ա�
	public void withdrawal();			//����
	public void printAllInfo();			//���� ���
	public void printInfo();			//���� ���� �˻�
	public void deleteAccount();		//���� ����
	public void AccountFileSave(); //���� ���� ���� ����
	public void AccountFileLoad(); //���� ���� ���� �ε�
}
