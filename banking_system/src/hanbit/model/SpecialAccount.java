package hanbit.model;

public class SpecialAccount extends Account{
	float interest_rate;				//������
	
	//������ �ʱ�ȭ
	public SpecialAccount() {
		super();
		interest_rate=1;
	}
	
	public SpecialAccount(String SA_code,String SA_name,long SA_open,float interest_rate,int NA_checkinterest,boolean SA_use) {
		super(SA_code,SA_name,SA_open,NA_checkinterest,SA_use);
		this.interest_rate=interest_rate;
	}
	
	public float getInterest_rate() {
		return interest_rate;
	}
	
	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}
	
	public void specialAccountDeposit(long money){//100
		//AO = (long) (AO + (AO * (IR / 100)));
		int interest= (int)(money*((float)interest_rate/100));
		NA_open += (interest+money); // 100 +10 -> 1110
		System.out.println("������:"+interest_rate+"%");
		System.out.println("�׿� ���� ��ü�� �ݾ�:"+interest+"��");
		System.out.println(NA_name + " ���¿� " + (interest+money) + "���� �Ա��Ͽ����ϴ�. �ܾ��� "+ NA_open + "�Դϴ�.");
	}
	
//	public void printAll(){
//		System.out.println("> [Ư������:"+NA_name+"��] ���¹�ȣ:"+NA_code+" �ܾ�:"+NA_open+" ������:"+interest_rate+"%");
//	}
//	
//	public void printsearch(){
//		System.out.println("> [Ư������:"+NA_name+"��] ���¹�ȣ:"+NA_code+" �ܾ�:"+NA_open+" ������:"+interest_rate+"%");
//	}
//	
//	public void deleteAccount(){
//		NA_use = false;
//	}
}
