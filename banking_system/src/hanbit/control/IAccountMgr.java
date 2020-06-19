package hanbit.control;

public interface IAccountMgr {
	public void newAccount();			//새계좌
	public void deposit();				//입금
	public void withdrawal();			//인출
	public void printAllInfo();			//계좌 출력
	public void printInfo();			//계좌 정보 검색
	public void deleteAccount();		//계좌 해지
	public void AccountFileSave(); //계좌 정보 파일 저장
	public void AccountFileLoad(); //계좌 정보 파일 로드
}
