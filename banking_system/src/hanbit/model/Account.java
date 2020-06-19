package hanbit.model;

import java.io.Serializable;

public class Account implements Serializable{
	String NA_code;				//계정 계좌 번호
	String NA_name;				//계정 계좌 이름
	long NA_open;				//계정 개설 시작 비용(잔액)
	int NA_checkinterest;	//무이자,이자 통장 여부
	boolean NA_use;				//계정 사용 여부 false는 계약해지, ture는 정상상태 (사용안함)
	
	//생성자 초기화
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
		System.out.println(NA_name + " 계좌에 " + money + "원을 입금하였습니다. 잔액은 "+ NA_open + "입니다.");
	}
//	public void printAll(){
//		System.out.println("> [일반계좌:"+NA_name+"님] 계좌번호:"+NA_code+" 잔액:"+NA_open);
//	}
//	public void printsearch(){
//		System.out.println("> [일반계좌:"+NA_name+"님] 계좌번호:"+NA_code+" 잔액:"+NA_open);
//	}
//	public void deleteAccount(){
//		NA_use = false;
//	}
	
	/**
	 * -----------------------------Method--------------------------------
	 * 
	 * @메소드명 - withdraw()
	 * 
	 * @목적 - AccountMgr의 withdrawal() 출금조건과 출금시 잔액 계산하는 메소드
	 * 
	 * @매개변수- int outmoney(출금액)
	 * 
	 * @리턴값 - boolean status : true면 정상 출금, false면 잔액부족
	 * 
	 * @---------------------------------------------------------------------
	 */
	public boolean withdraw(long outmoney) {
		boolean status = false; // 상태정보 저장 변수 선언,초기화
		// 계좌 잔액이 0원이 아니고 출금액이 잔액보다 적거나 같은 금액일 경우
		if (NA_open != 0 && outmoney <= NA_open) {
			NA_open -= outmoney; // 잔액에서 출금액을 차감한 금액을 잔액에 저장
			status = true;
		}
		return status;
	}
}
