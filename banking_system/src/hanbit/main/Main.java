package hanbit.main;

import hanbit.control.AccountMgr;
import hanbit.view.AccountMenuView;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AccountMgr AM=new AccountMgr();
		Scanner scan = new Scanner(System.in);
		//시스템 사용 암호
		final String Password = "admin";
		//시스템 암호 유호성 체크
		boolean ispasswordok = false;
		
		while (true) {

			if (!ispasswordok) {
				System.out.print("시스템 암호 입력 >>");
				String input_Password = scan.nextLine();

				ispasswordok = AccountMenuView.CheckPassword(Password, input_Password);

				if (!ispasswordok) {
					// 암호 입력 오류
					continue;
				}
			} else {
				AccountMenuView.ShowMenu();
				System.out.print("선택>>");
				// 메뉴번호 입력
				int choice = scan.nextInt();
				switch (choice) {

				case 1:
					AM.newAccount();
					break;
				case 2:
					AM.deposit();
					break;
				case 3:
					AM.withdrawal();
					break;
				case 4:
					AM.printAllInfo();
					break;
				case 5:
					AM.printInfo();
					break;
				case 6:
					AM.AccountFileLoad();
					break;
				case 7:
					AM.deleteAccount();
					break;
				case 8:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("메뉴번호를 다시 입력하세요");
					break;
				}
			}

		}
	}
}
