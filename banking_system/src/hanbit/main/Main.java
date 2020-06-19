package hanbit.main;

import hanbit.control.AccountMgr;
import hanbit.view.AccountMenuView;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AccountMgr AM=new AccountMgr();
		Scanner scan = new Scanner(System.in);
		//�ý��� ��� ��ȣ
		final String Password = "admin";
		//�ý��� ��ȣ ��ȣ�� üũ
		boolean ispasswordok = false;
		
		while (true) {

			if (!ispasswordok) {
				System.out.print("�ý��� ��ȣ �Է� >>");
				String input_Password = scan.nextLine();

				ispasswordok = AccountMenuView.CheckPassword(Password, input_Password);

				if (!ispasswordok) {
					// ��ȣ �Է� ����
					continue;
				}
			} else {
				AccountMenuView.ShowMenu();
				System.out.print("����>>");
				// �޴���ȣ �Է�
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
					System.out.println("���α׷� ����");
					return;
				default:
					System.out.println("�޴���ȣ�� �ٽ� �Է��ϼ���");
					break;
				}
			}

		}
	}
}
