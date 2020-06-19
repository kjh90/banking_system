package hanbit.model;

public class SpecialAccount extends Account{
	float interest_rate;				//이자율
	
	//생성자 초기화
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
		System.out.println("이자율:"+interest_rate+"%");
		System.out.println("그에 따른 이체된 금액:"+interest+"원");
		System.out.println(NA_name + " 계좌에 " + (interest+money) + "원을 입금하였습니다. 잔액은 "+ NA_open + "입니다.");
	}
	
//	public void printAll(){
//		System.out.println("> [특별계좌:"+NA_name+"님] 계좌번호:"+NA_code+" 잔액:"+NA_open+" 이자율:"+interest_rate+"%");
//	}
//	
//	public void printsearch(){
//		System.out.println("> [특별계좌:"+NA_name+"님] 계좌번호:"+NA_code+" 잔액:"+NA_open+" 이자율:"+interest_rate+"%");
//	}
//	
//	public void deleteAccount(){
//		NA_use = false;
//	}
}
