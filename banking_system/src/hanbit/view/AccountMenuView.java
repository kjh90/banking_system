package hanbit.view;

public class AccountMenuView {
	public static void ShowMenu() {
		
		System.out.println("********************");
		System.out.println("    ::��ŷ�ý���::");
		System.out.println("********************");
		System.out.println("       [�޴�]");
		System.out.println("********************");
		System.out.println("1. �ű԰��� ����");
		System.out.println("2. �Ա�");
		System.out.println("3. ���");
		System.out.println("4. �������� ��ü ���");
		System.out.println("5. �������� �˻�");
		System.out.println("6. �������� ���� ���");
		System.out.println("7. ���� ����");
		System.out.println("8. ����");

	}
	
	public static boolean CheckPassword(String password ,String inputpassword) {
		boolean isCheck = false;
		if (password.equalsIgnoreCase(inputpassword) == false) {
			// ��ȣ�Է� ���н�
			isCheck = false;
			System.out.println("��ȣ �ٽ� �Է����ּ���");
		} else {
			isCheck = true;
		}

		return isCheck;
	}
}
