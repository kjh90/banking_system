package hanbit.model;

import java.io.Serializable;

public class Account implements Serializable{
	String NA_code;				//���� ���� ��ȣ
	String NA_name;				//���� ���� �̸�
	long NA_open;				//���� ���� ���� ���(�ܾ�)
	int NA_checkinterest;	//������,���� ���� ����
	boolean NA_use;				//���� ��� ���� false�� �������, ture�� ������� (������)
	
	//������ �ʱ�ȭ
	public Account() {
		NA_code="";
		NA_name="";
		NA_open=0;
		NA_checkinterest = 0;
		NA_use=true;
	}

	public Account(String NA_code,String NA_name,long NA_open,int NA_checkinterest ,boolean NA_use){
		this.NA_code = NA_code;
		this.NA_name = NA_name;
		this.NA_open = NA_open;
		this.NA_checkinterest = NA_checkinterest;
		this.NA_use = NA_use;
		
	}

	public String getNA_code() {
		return NA_code;
	}

	public void setNA_code(String nA_code) {
		NA_code = nA_code;
	}

	public String getNA_name() {
		return NA_name;
	}

	public void setNA_name(String nA_name) {
		NA_name = nA_name;
	}

	public long getNA_open() {
		return NA_open;
	}

	public void setNA_open(long nA_open) {
		NA_open = nA_open;
	}
	
	public boolean isNA_use() {
		return NA_use;
	}

	public void setNA_use(boolean nA_use) {
		NA_use = nA_use;
	}

	public int getNA_checkinterest() {
		return NA_checkinterest;
	}

	public void setNA_checkinterest(int nA_checkinterest) {
		NA_checkinterest = nA_checkinterest;
	}

	public void deposit(long money){
		NA_open += money;
		System.out.println(NA_name + " ���¿� " + money + "���� �Ա��Ͽ����ϴ�. �ܾ��� "+ NA_open + "�Դϴ�.");
	}
//	public void printAll(){
//		System.out.println("> [�Ϲݰ���:"+NA_name+"��] ���¹�ȣ:"+NA_code+" �ܾ�:"+NA_open);
//	}
//	public void printsearch(){
//		System.out.println("> [�Ϲݰ���:"+NA_name+"��] ���¹�ȣ:"+NA_code+" �ܾ�:"+NA_open);
//	}
//	public void deleteAccount(){
//		NA_use = false;
//	}
	
	/**
	 * -----------------------------Method--------------------------------
	 * 
	 * @�޼ҵ�� - withdraw()
	 * 
	 * @���� - AccountMgr�� withdrawal() ������ǰ� ��ݽ� �ܾ� ����ϴ� �޼ҵ�
	 * 
	 * @�Ű�����- int outmoney(��ݾ�)
	 * 
	 * @���ϰ� - boolean status : true�� ���� ���, false�� �ܾ׺���
	 * 
	 * @---------------------------------------------------------------------
	 */
	public boolean withdraw(long outmoney) {
		boolean status = false; // �������� ���� ���� ����,�ʱ�ȭ
		// ���� �ܾ��� 0���� �ƴϰ� ��ݾ��� �ܾ׺��� ���ų� ���� �ݾ��� ���
		if (NA_open != 0 && outmoney <= NA_open) {
			NA_open -= outmoney; // �ܾ׿��� ��ݾ��� ������ �ݾ��� �ܾ׿� ����
			status = true;
		}
		return status;
	}
}
