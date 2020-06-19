package hanbit.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import hanbit.model.Account; //일반 계좌
import hanbit.model.SpecialAccount; //스페셜 계좌

public class AccountMgr implements IAccountMgr {
	// Account[] AA; //Account Arrangement 계좌 배열
	// int AI; //Account Index 계좌 배열 주소
	Map<String, Account> map_Account;
	Account input_Account;
	String AC = ""; // Account_Code 계좌 번호
	String AN = ""; // Account_Name 사용자 이름
	long AO = 0; // Account_Open 계설시 초기 금액
	int AT = 0; // Account_Type 1.노말 2.스페셜
	float IR = 0; // Interest_Rate; 이자율
	boolean r = true; // Roof 루프용
	Scanner scan = new Scanner(System.in);

	public AccountMgr() {
		// AA = new Account [20]; //Account Arrangement 개좌 배열 20개로 제한
		// AI = 0; //Account Index 계좌 배열 주소 초기화
		map_Account = new HashMap<String, Account>();
		input_Account = new Account();

	}

	/** @-----------------------------Function--------------------------------
	* @함수명    - newAccount() : 계좌 등록
	* @목적      - 신규 계좌 정보를 등록합니다(계좌유형(무이자/이자),계좌번호,계좌예금주,개설액,이자율)
	* @매개변수  - 
	* @리턴값    - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* 계좌유형  입력부분에서 메뉴화면 이동 할 수 있도록 추가 구현
	* 계좌유형 입력시 예외처리
	* @---------------------------------------------------------------------
	*/
	public void newAccount() {

		System.out.println("계좌의 신규등록 서비스를 시작합니다.");
		System.out.println("개설할 계좌유형을 선택해주세요.");

		while (true) {
			try {
				System.out.print("0번 메뉴화면 이동, 1번 일반계좌(무이자), 2번 특별계좌(이자)>>");
				AT = scan.nextInt();

				if (AT == 1) {
					System.out.println("일반계좌(무이자) 생성");
					break;
				} else if (AT == 2) {
					System.out.println("특별계좌(이자) 생성");
					break;
				} else if (AT == 0) {
					break;
				}  else {
					System.out.println("잘못 입력 하셨습니다.");
					System.out.println("다시 입력해주세요(0번,1번,2번 선택)");
				}
			} catch (Exception e) {
				System.out.println("잘못 입력 하셨습니다.");
				System.out.println("다시 입력해주세요(0번,1번,2번 선택)");
				scan.nextLine();
			}
			
				
		}
		//메뉴화면 이동
		if(AT == 0) {
			return;
		}

		// 동일한 계좌를 중복 검사 없애기 위해서 제작
		while (true) {
			try {
				System.out.print("계좌번호>>");
				AC = scan.next();

				if (map_Account.size() > 0) {

					if (map_Account.containsKey(AC)) {
						// 똑같은 계좌번호 있다면
						System.out.println("동일한 계좌가 있습니다.계좌를 다시 입력해 주세요");
						continue;
					}
				}
				
				if(Integer.parseInt(AC) <= 0) {
					System.out.println("잘못된 값을 입력하였습니다.");
					System.out.println("계자번호는 숫자만 허용합니다.");
					continue;
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 값을 입력하였습니다.");
				System.out.println("계자번호는 숫자만 허용합니다.");
				continue;
			}

		}

		// 예금주 입력
		while (true) {
			try {
				System.out.print("계좌예금주>>");
				AN = scan.next();
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 값을 입력하였습니다.");
				System.out.println("계자번호는 숫자만 허용합니다.");
				continue;
			}

		}

		// 계좌개설액 입력
		while (true) {
			try {
				System.out.print("계좌개설액>>");
				AO = scan.nextLong();
				if(AO <= 0) {
					System.out.println("잘못된 값을 입력하였습니다.");
					System.out.println("개설금액은 0원 이상으로 등록하셔야됩니다.");
					continue;
				}

				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 값을 입력하였습니다.");
				System.out.println("개설금액은 0원 이상으로 등록하셔야됩니다.");
				scan.nextLine();
				continue;
			}

		}

		if (AT == 1) { // 무이자 계좌

			System.out.println();
			System.out.println("계좌의 신규등록을 완료했습니다.");
			System.out.println("> [일반계좌:" + AN + "님] 계좌번호:" + AC + " 잔액:" + AO);
			System.out.println();

			// 무이자 계좌 정보 저장
			input_Account = new Account(AC, AN, AO,AT, true);
			// 맵에 계좌 정보 저장
			map_Account.put(AC, input_Account);
		} else {
			// 이자 계좌

			// 이율 입력
			while (true) {
				try {
					System.out.print("이율(%)을 입력하세요>>");
					IR = scan.nextFloat();
					if(IR <= 0) {
						System.out.println("이율이 0보다 작습니다.");
						System.out.println("이율은 0% 이상으로 설정하셔야됩니다.");
						continue;
					}
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("잘못된 값을 입력하였습니다.");
					System.out.println("이율은 0이상의 숫자만을 허용합니다.");
					scan.nextLine();
					continue;
				}

			}

			System.out.println();
			System.out.println("계좌의 신규등록을 완료했습니다.");
			AO = (long) (AO + (AO * (IR / 100)));
			System.out.println("> [특별 계좌:" + AN + "님] 계좌번호:" + AC + " 잔액:" + AO + " 이자율:" + IR + "%");
			System.out.println();
			
			// 이자 계좌 정보 저장
			input_Account = new SpecialAccount(AC,AN,AO,IR,AT,true);
			// 맵에 계좌 정보 저장
			map_Account.put(AC, input_Account);
			
		}

		scan.nextLine();
		
		//계좌 정보 파일에 저장
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @함수명   - deposit
	* @목적     - 기존 개설된 계좌에 입금
	* @매개변수 - 
	* @리턴값   - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* 입금기능 취소시 메뉴화면 이동 할 수 있도록  구현
	* 계좌정보 없으면 메뉴화면 이동 구현
	* @---------------------------------------------------------------------
	*/
	public void deposit() {
		String depositAccount = "";
		long depositMoney = 0;
		boolean exit = false; // true면 입력오류,false면 정상입력

		// 계좌정보가 없을시
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {

			System.out.println("입금할 계좌를 입력하세요>>");
			System.out.println("(메뉴화면 : 0 입력)");
			depositAccount = scan.next();

			if (map_Account.containsKey(depositAccount)) {

				while (true) {
					try {
						System.out.println("입금액을 입력해주세요>>");
						System.out.println("(메뉴화면 : 0 입력)");
						depositMoney = scan.nextLong();

						if (depositMoney > 0) {
							if (map_Account.get(depositAccount).getNA_checkinterest() == 1) {
								// 무통장
								input_Account = new Account();
								input_Account = map_Account.get(depositAccount);

								input_Account.deposit(depositMoney);

							} else {
								// 이자통장
								input_Account = map_Account.get(depositAccount);
								((SpecialAccount) input_Account).specialAccountDeposit(depositMoney);
							}
							break;

						} else {
							if (depositMoney == 0) {
								exit = true;
								System.out.println("메뉴화면으로 돌아갑니다.");
								break;
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("입금액을 다시 입력해주세요.");
						scan.nextLine();
						continue;
					}

				}

				if (exit == true) {
					// 입금액 입력값이 0일때
					break;
				} else if (exit == false) {
					// 입금액 기능 정상적으로 처리
					break;
				}

			} else if (depositAccount.equals("0")) {
				System.out.println("메뉴화면으로 돌아갑니다.");
				break;
			} else {
				System.out.println("입력오류.");
				continue;
			}

		}
		// 계좌 정보 파일에 저장
		AccountFileSave();
	}

	/**
	 * -----------------------------Method--------------------------------
	 * 
	 * @메소드명 - withdrawal() (출금 메소드)
	 * @목적 - 콘솔에서 출금에 관련된 사항(계좌번호,출금액)을 입력받고 
	 * 입력받은 값이 조건에 맞으면 출금 처리 후 남은 잔액 리턴하는 메소드
	 * 
	 * @---------------------------------------------------------------------
	 * 
	 * @작업내역 및 예외사항
	 * 
	 * @추가 작업사항 입력
	 * 출금기능 취소시 메뉴화면 이동 할 수 있도록 구현
	 * 계좌정보 없으면 메뉴화면 이동 구현
	 * @---------------------------------------------------------------------
	 */
	public void withdrawal() {
		
		// 계좌정보가 없을시
		if (!CheckAccountInfo()) {
			return;
		}

		long outmoney; // 출금액을 저장할 변수 선언
		A://레이블설정,주의사항 : Unreachable code(연결할 수없는 코드),break/continue레이블 
		while (true) { 
			while (true) {
				try {
					System.out.println("[ 0입력시 메뉴화면으로 이동합니다. ]");
					System.out.println("출금하실 계좌번호를 입력하세요. : ");
					
					AC = scan.next(); // 사용자가 입력한 계좌번호 저장.
					if (Integer.parseInt(AC) < 0) {
						System.out.println("잘못된 계좌 번호 입니다.");
						System.out.println();
						System.out.println("계좌번호를 다시 입력해 주세요.");
						continue;
					} else if (Integer.parseInt(AC) == 0) // 메뉴로 돌아가기
						break A; // A while문 탈출
					break;
				} catch (Exception e) {
					System.out.println("존재하지 않는 계좌번호 입니다.");
					System.out.println("계좌번호를 다시 입력해 주세요.");
					scan.nextLine();
					continue;
				}
			}

			// 입력된 계좌번호 값이 키영역에 존재 할 경우
			if (map_Account.containsKey(AC)) {
				// 맵에 저장된 그 계좌번호의 정보를 저장.
				Account acc = map_Account.get(AC);
				while (true) {
					try {
						System.out.println("[ 0입력시 메뉴화면으로 이동합니다. ]");
						System.out.println("출금액을 입력하세요 :");
						// 스캐너로 입력받은 출금액을 저장.
						outmoney = scan.nextLong();
						if (outmoney < 0) {
							System.out.println("출금액을 잘못 입력하였습니다.");
							System.out.println("출금액은 0원 이상의 금액으로 입력해야합니다.");
							continue;
						}else if(outmoney == 0)// 메뉴로 돌아가기
							break A; // A while문 탈출
						break;
					} catch (Exception e) {
						System.out.println("출금액을 잘못 입력하였습니다.");
						System.out.println("출금액은 0원 이상의 금액으로 입력해야합니다.");
						scan.nextLine();
						continue;
					}
				}
				// Account클래스에 withdraw() 리턴값 저장
				boolean res = acc.withdraw(outmoney);
				// 출금 처리 성공
				if (res) {
					System.out
							.println(acc.getNA_name() + "님의 " + acc.getNA_code() + "계좌에서 " + outmoney + "원을 출금하였습니다.");
					System.out.println("출금 후 잔액은 " + acc.getNA_open() + " 원 입니다.");
				} else {
					// 출금 처리 실패
					System.out.println("출금 실패. 잔액부족. 현재 잔액은 " + acc.getNA_open() + "원 입니다.");
				}

				break; // 출금 과정(출금처리 성공or실패)이 끝나면 메뉴로 이동
			} else {
				// 입력된 계좌번호 값이 키영역에 존재 하지 않은 경우
				System.out.println("존재하지 않는 계좌번호 입니다.");
				System.out.println("계좌번호를 다시 입력해 주세요.");
				System.out.println();
				continue;
			}
		}
		// 계좌 정보 파일에 저장
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @함수명   - printAllInfo()
	* @목적     - 등록된 계좌전체의 정보를 출력
	* @매개변수 - 
	* @리턴값   - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* 계좌정보 없으면 메뉴화면 이동 구현
	* @---------------------------------------------------------------------
	*/
	public void printAllInfo() {
		Set<String> keys = map_Account.keySet(); // 키값을저장
		// 계좌정보가 없을시
		if (!CheckAccountInfo()) {
			return;
		}

		for (String key : keys) { // for each문을 이용해서 key에 key의 키값을 반복
			Account acc = map_Account.get(key); // Account 정보를 가져와서 acc로 인스턴스화

			if (acc.getNA_checkinterest() == 1) { // 고객유형 1 일반(무이자)
				System.out.println("일반계좌");
				System.out.println("[ 예금주 : " + acc.getNA_name() 
				+ "]    계좌번호 : " + acc.getNA_code() 
				+ "  계좌 잔액 : " + acc.getNA_open() + "원");

			} else if (acc.getNA_checkinterest() == 2) { // 고객유형 2 보통(이자)

				System.out.println("특별계좌");
				System.out.println("[ 예금주 : " + acc.getNA_name() 
				+ "]    계좌번호 : " + acc.getNA_code() 
				+ "  계좌 잔액 : " + acc.getNA_open() + "원"
				+ " 이자율 :"
				+ ((SpecialAccount) map_Account.get(key)).getInterest_rate() + "%");
			}

		} 
	}

	/** @-----------------------------Function--------------------------------
	* @함수명   - printInfo()
	* @목적     - 등록된 단일계좌의 정보를 출력
	* @매개변수 - 
	* @리턴값   - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* 검색 기능 취소시 메뉴화면으로 이동 하도록 구현
	* 계좌정보 없으면 메뉴화면 이동 구현
	* @---------------------------------------------------------------------
	*/
	public void printInfo() {
		// 입력 저장값
		String account_string = "";

		// 계좌정보가 없을시
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {
			System.out.println("[ 0입력시 메뉴화면으로 이동합니다. ]");
			System.out.print("계좌번호를 입력하세요. : ");
			account_string = scan.next(); // 사용자가 입력한 계좌번호 저장.

			if (map_Account.containsKey(account_string)) {
				break;
			}
			else if(account_string.trim().equals("0")) {
				break;
			}
			else {
				System.out.println("계좌를 다시 입력해주세요.");
				continue;
			}
		}
		
		//메뉴화면 이동
		if(account_string.trim().equals("0")) {
			return;
		}

		if (map_Account.containsKey(account_string)) {
			// 맵에 저장된  계좌번호의 정보를 저장.
			Account acc = map_Account.get(account_string); // Account 정보를 가져와서 acc로 인스턴스화

			if (acc.getNA_checkinterest() == 1) { // 고객유형 1 일반(무이자)
				System.out.println("일반계좌");
				System.out.println("[ 예금주 : " + acc.getNA_name() + "]    계좌번호 : " + acc.getNA_code() + "  계좌 잔액 : "
						+ acc.getNA_open() + "원");

			} else if (acc.getNA_checkinterest() == 2) { // 고객유형 2 보통(이자)

				System.out.println("특별계좌");
				System.out.println("[ 예금주 : " + acc.getNA_name() + "]    계좌번호 : " + acc.getNA_code() + "  계좌 잔액 : "
						+ acc.getNA_open() + "원" + " 이자율 :"
						+ ((SpecialAccount) map_Account.get(account_string)).getInterest_rate() + "%");
			} else {
				System.out.println("등록되지 않은 계좌 입니다.");
				System.out.println();
			}
		}

	}

	/** @-----------------------------Function--------------------------------
	* @함수명    - deleteAccount()
	* @목적      - 등록된 계좌정보 삭제
	* @매개변수  - 
	* @리턴값    - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* 해지기능 취소시 메뉴화면으로 이동 하도록 구현
	* 계좌정보 없으면 메뉴화면 이동 구현
	* @---------------------------------------------------------------------
	*/

	public void deleteAccount() {
		
		// 계좌정보가 없을시
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {

			System.out.println("메뉴화면으로 돌아가시려면 0번을 입력하세요");
			System.out.println();
			System.out.println("해지하실 계좌번호를 입력하세요.>>");
			// 해지할 계좌번호 입력
			AC = scan.next();
			if (AC.equals("0")) {
				break;
			} else if (map_Account.containsKey(AC)) {
				//map_Account.get(AC);
				map_Account.remove(AC);
				System.out.println("(" + AN + ")" + "고객님의 계좌번호(" + AC + ")가 해지되었습니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		// 계좌 정보 파일에 저장
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @함수명    - AccountFileSave() 
	* @목적      - 계좌 정보를 파일에 저장(계좌유형(무이자/이자),계좌번호,계좌예금주,잔액,이자율)
	* - 저장 파일명 : AccountInfo.txt
	* @매개변수  - 
	* @리턴값    - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* @---------------------------------------------------------------------
	*/
	@Override
	public void AccountFileSave() {
		//저장할 파일인스턴스 선언 및 초기화
    	File accountinfofile = new File("AccountInfo.txt");
    	
    	try {
    		//직렬화하여 파일에 저장
    		
    		if(accountinfofile.exists() == false) {
    			//파일 없으면 파일생성
    			accountinfofile.createNewFile();
        	}
    		
        	FileOutputStream fos = new FileOutputStream(accountinfofile); 
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	//등록된 통장 정보가 있으면 파일 저장
        	if(map_Account.size() > 0) {
        		oos.writeObject(map_Account);
        		
        	}
        	oos.flush();
        	oos.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	/** @-----------------------------Function--------------------------------
	* @함수명    - AccountFileLoad()
	* @목적      - 파일에 저장된 계좌정보 출력(계좌유형(무이자/이자),계좌번호,계좌예금주,잔액,이자율)
	* - 출력 파일명 : AccountInfo.txt
	* @매개변수  - 
	* @리턴값    - 
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* @---------------------------------------------------------------------
	*/
	@Override
	public void AccountFileLoad() {
		
		//저장할 파일인스턴스 선언 및 초기화
    	File accountinfofile = new File("AccountInfo.txt");
    	
    	try {
    		//직렬화되어 파일에 저장된 데이터 호출
    		if(accountinfofile.exists()) {
    			FileInputStream fis = new FileInputStream(accountinfofile);
            	ObjectInputStream ois = new ObjectInputStream(fis);
            	
            	map_Account = (HashMap<String, Account>) ois.readObject();
            	
            	Set<String> keyset = map_Account.keySet();
            	
            	for (String key : keyset) {
            		StringBuffer strbuff = new StringBuffer();
            		if(map_Account.get(key).getNA_checkinterest() == 1 ) {
            			//무통장 정보 출력
            			strbuff.append(" [ 예금주 : ");
                		strbuff.append(map_Account.get(key).getNA_name());
                		strbuff.append(" ] ");
            			strbuff.append("\t계좌번호 : ");
                		strbuff.append(map_Account.get(key).getNA_code());
                		strbuff.append("\t잔액 : ");
                		strbuff.append(map_Account.get(key).getNA_open());
                		strbuff.append("\t일반계좌");
            		}
            		else {
            			//이자 통장 정보 출력
            			strbuff.append(" [ 예금주 : ");
                		strbuff.append(map_Account.get(key).getNA_name());
                		strbuff.append(" ] ");
            			strbuff.append("\t계좌번호 : ");
                		strbuff.append(map_Account.get(key).getNA_code());
                		strbuff.append("\t잔액 : ");
                		strbuff.append(map_Account.get(key).getNA_open());
                		strbuff.append("\t이자율 : ");
                		strbuff.append(((SpecialAccount)map_Account.get(key)).getInterest_rate());
                		strbuff.append("%");
                		strbuff.append("\t특별계좌");
            		}
            		System.out.println(strbuff.toString());
				}
            	
            	ois.close();
    		}
    		else {
    			//계좌정보 없을때
    			if(!CheckAccountInfo()) {
    				return;
    			}
    		}
        	
		} catch (Exception e) {
			//e.printStackTrace();
			//계좌정보 없을때
			if(!CheckAccountInfo()) {
				
				if(accountinfofile.exists()) {
					//맵에 계좌 정보가 없는데 파일이 있다면 파일 삭제
					accountinfofile.delete();
				}
				return;
			}
			System.out.println("파일에 저장된 정보가 없습니다.");
		}
		
	}
	/** @-----------------------------Function--------------------------------
	* @함수명    - CheckAccountInfo()
	* @목적      - 해쉬맵에 계좌정보 저장 유무 검사
	* @매개변수  - 
	* @리턴값    - isCheck : true면 계좌정보 있음, false면 계좌 정보 없음
	* @---------------------------------------------------------------------
	* @작업내역및예외사항
	* @추가작업사항입력
	* @---------------------------------------------------------------------
	*/
	public boolean CheckAccountInfo() {
		boolean isCheck = true;
		// 계좌정보가 없을시
		if (map_Account.size() <= 0) {
			System.out.println("계좌를 등록해주세요");
			isCheck = false;
		}
		return isCheck;
	}

}
