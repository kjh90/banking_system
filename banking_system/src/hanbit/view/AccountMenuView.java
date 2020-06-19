package hanbit.view;

public class AccountMenuView {
	public static void ShowMenu() {
		
		System.out.println("********************");
		System.out.println("    ::뱅킹시스템::");
		System.out.println("********************");
		System.out.println("       [메뉴]");
		System.out.println("********************");
		System.out.println("1. 신규계좌 개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌정보 전체 출력");
		System.out.println("5. 계좌정보 검색");
		System.out.println("6. 계좌정보 파일 출력");
		System.out.println("7. 계좌 해지");
		System.out.println("8. 종료");

	}
	
	public static boolean CheckPassword(String password ,String inputpassword) {
		boolean isCheck = false;
		if (password.equalsIgnoreCase(inputpassword) == false) {
			// 암호입력 실패시
			isCheck = false;
			System.out.println("암호 다시 입력해주세요");
		} else {
			isCheck = true;
		}

		return isCheck;
	}
}
