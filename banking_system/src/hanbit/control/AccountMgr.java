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

import hanbit.model.Account; //�Ϲ� ����
import hanbit.model.SpecialAccount; //����� ����

public class AccountMgr implements IAccountMgr {
	// Account[] AA; //Account Arrangement ���� �迭
	// int AI; //Account Index ���� �迭 �ּ�
	Map<String, Account> map_Account;
	Account input_Account;
	String AC = ""; // Account_Code ���� ��ȣ
	String AN = ""; // Account_Name ����� �̸�
	long AO = 0; // Account_Open �輳�� �ʱ� �ݾ�
	int AT = 0; // Account_Type 1.�븻 2.�����
	float IR = 0; // Interest_Rate; ������
	boolean r = true; // Roof ������
	Scanner scan = new Scanner(System.in);

	public AccountMgr() {
		// AA = new Account [20]; //Account Arrangement ���� �迭 20���� ����
		// AI = 0; //Account Index ���� �迭 �ּ� �ʱ�ȭ
		map_Account = new HashMap<String, Account>();
		input_Account = new Account();

	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���    - newAccount() : ���� ���
	* @����      - �ű� ���� ������ ����մϴ�(��������(������/����),���¹�ȣ,���¿�����,������,������)
	* @�Ű�����  - 
	* @���ϰ�    - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* ��������  �Էºκп��� �޴�ȭ�� �̵� �� �� �ֵ��� �߰� ����
	* �������� �Է½� ����ó��
	* @---------------------------------------------------------------------
	*/
	public void newAccount() {

		System.out.println("������ �űԵ�� ���񽺸� �����մϴ�.");
		System.out.println("������ ���������� �������ּ���.");

		while (true) {
			try {
				System.out.print("0�� �޴�ȭ�� �̵�, 1�� �Ϲݰ���(������), 2�� Ư������(����)>>");
				AT = scan.nextInt();

				if (AT == 1) {
					System.out.println("�Ϲݰ���(������) ����");
					break;
				} else if (AT == 2) {
					System.out.println("Ư������(����) ����");
					break;
				} else if (AT == 0) {
					break;
				}  else {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���(0��,1��,2�� ����)");
				}
			} catch (Exception e) {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���(0��,1��,2�� ����)");
				scan.nextLine();
			}
			
				
		}
		//�޴�ȭ�� �̵�
		if(AT == 0) {
			return;
		}

		// ������ ���¸� �ߺ� �˻� ���ֱ� ���ؼ� ����
		while (true) {
			try {
				System.out.print("���¹�ȣ>>");
				AC = scan.next();

				if (map_Account.size() > 0) {

					if (map_Account.containsKey(AC)) {
						// �Ȱ��� ���¹�ȣ �ִٸ�
						System.out.println("������ ���°� �ֽ��ϴ�.���¸� �ٽ� �Է��� �ּ���");
						continue;
					}
				}
				
				if(Integer.parseInt(AC) <= 0) {
					System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
					System.out.println("���ڹ�ȣ�� ���ڸ� ����մϴ�.");
					continue;
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
				System.out.println("���ڹ�ȣ�� ���ڸ� ����մϴ�.");
				continue;
			}

		}

		// ������ �Է�
		while (true) {
			try {
				System.out.print("���¿�����>>");
				AN = scan.next();
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
				System.out.println("���ڹ�ȣ�� ���ڸ� ����մϴ�.");
				continue;
			}

		}

		// ���°����� �Է�
		while (true) {
			try {
				System.out.print("���°�����>>");
				AO = scan.nextLong();
				if(AO <= 0) {
					System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
					System.out.println("�����ݾ��� 0�� �̻����� ����ϼžߵ˴ϴ�.");
					continue;
				}

				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
				System.out.println("�����ݾ��� 0�� �̻����� ����ϼžߵ˴ϴ�.");
				scan.nextLine();
				continue;
			}

		}

		if (AT == 1) { // ������ ����

			System.out.println();
			System.out.println("������ �űԵ���� �Ϸ��߽��ϴ�.");
			System.out.println("> [�Ϲݰ���:" + AN + "��] ���¹�ȣ:" + AC + " �ܾ�:" + AO);
			System.out.println();

			// ������ ���� ���� ����
			input_Account = new Account(AC, AN, AO,AT, true);
			// �ʿ� ���� ���� ����
			map_Account.put(AC, input_Account);
		} else {
			// ���� ����

			// ���� �Է�
			while (true) {
				try {
					System.out.print("����(%)�� �Է��ϼ���>>");
					IR = scan.nextFloat();
					if(IR <= 0) {
						System.out.println("������ 0���� �۽��ϴ�.");
						System.out.println("������ 0% �̻����� �����ϼžߵ˴ϴ�.");
						continue;
					}
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
					System.out.println("������ 0�̻��� ���ڸ��� ����մϴ�.");
					scan.nextLine();
					continue;
				}

			}

			System.out.println();
			System.out.println("������ �űԵ���� �Ϸ��߽��ϴ�.");
			AO = (long) (AO + (AO * (IR / 100)));
			System.out.println("> [Ư�� ����:" + AN + "��] ���¹�ȣ:" + AC + " �ܾ�:" + AO + " ������:" + IR + "%");
			System.out.println();
			
			// ���� ���� ���� ����
			input_Account = new SpecialAccount(AC,AN,AO,IR,AT,true);
			// �ʿ� ���� ���� ����
			map_Account.put(AC, input_Account);
			
		}

		scan.nextLine();
		
		//���� ���� ���Ͽ� ����
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���   - deposit
	* @����     - ���� ������ ���¿� �Ա�
	* @�Ű����� - 
	* @���ϰ�   - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* �Աݱ�� ��ҽ� �޴�ȭ�� �̵� �� �� �ֵ���  ����
	* �������� ������ �޴�ȭ�� �̵� ����
	* @---------------------------------------------------------------------
	*/
	public void deposit() {
		String depositAccount = "";
		long depositMoney = 0;
		boolean exit = false; // true�� �Է¿���,false�� �����Է�

		// ���������� ������
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {

			System.out.println("�Ա��� ���¸� �Է��ϼ���>>");
			System.out.println("(�޴�ȭ�� : 0 �Է�)");
			depositAccount = scan.next();

			if (map_Account.containsKey(depositAccount)) {

				while (true) {
					try {
						System.out.println("�Աݾ��� �Է����ּ���>>");
						System.out.println("(�޴�ȭ�� : 0 �Է�)");
						depositMoney = scan.nextLong();

						if (depositMoney > 0) {
							if (map_Account.get(depositAccount).getNA_checkinterest() == 1) {
								// ������
								input_Account = new Account();
								input_Account = map_Account.get(depositAccount);

								input_Account.deposit(depositMoney);

							} else {
								// ��������
								input_Account = map_Account.get(depositAccount);
								((SpecialAccount) input_Account).specialAccountDeposit(depositMoney);
							}
							break;

						} else {
							if (depositMoney == 0) {
								exit = true;
								System.out.println("�޴�ȭ������ ���ư��ϴ�.");
								break;
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("�Աݾ��� �ٽ� �Է����ּ���.");
						scan.nextLine();
						continue;
					}

				}

				if (exit == true) {
					// �Աݾ� �Է°��� 0�϶�
					break;
				} else if (exit == false) {
					// �Աݾ� ��� ���������� ó��
					break;
				}

			} else if (depositAccount.equals("0")) {
				System.out.println("�޴�ȭ������ ���ư��ϴ�.");
				break;
			} else {
				System.out.println("�Է¿���.");
				continue;
			}

		}
		// ���� ���� ���Ͽ� ����
		AccountFileSave();
	}

	/**
	 * -----------------------------Method--------------------------------
	 * 
	 * @�޼ҵ�� - withdrawal() (��� �޼ҵ�)
	 * @���� - �ֿܼ��� ��ݿ� ���õ� ����(���¹�ȣ,��ݾ�)�� �Է¹ް� 
	 * �Է¹��� ���� ���ǿ� ������ ��� ó�� �� ���� �ܾ� �����ϴ� �޼ҵ�
	 * 
	 * @---------------------------------------------------------------------
	 * 
	 * @�۾����� �� ���ܻ���
	 * 
	 * @�߰� �۾����� �Է�
	 * ��ݱ�� ��ҽ� �޴�ȭ�� �̵� �� �� �ֵ��� ����
	 * �������� ������ �޴�ȭ�� �̵� ����
	 * @---------------------------------------------------------------------
	 */
	public void withdrawal() {
		
		// ���������� ������
		if (!CheckAccountInfo()) {
			return;
		}

		long outmoney; // ��ݾ��� ������ ���� ����
		A://���̺���,���ǻ��� : Unreachable code(������ ������ �ڵ�),break/continue���̺� 
		while (true) { 
			while (true) {
				try {
					System.out.println("[ 0�Է½� �޴�ȭ������ �̵��մϴ�. ]");
					System.out.println("����Ͻ� ���¹�ȣ�� �Է��ϼ���. : ");
					
					AC = scan.next(); // ����ڰ� �Է��� ���¹�ȣ ����.
					if (Integer.parseInt(AC) < 0) {
						System.out.println("�߸��� ���� ��ȣ �Դϴ�.");
						System.out.println();
						System.out.println("���¹�ȣ�� �ٽ� �Է��� �ּ���.");
						continue;
					} else if (Integer.parseInt(AC) == 0) // �޴��� ���ư���
						break A; // A while�� Ż��
					break;
				} catch (Exception e) {
					System.out.println("�������� �ʴ� ���¹�ȣ �Դϴ�.");
					System.out.println("���¹�ȣ�� �ٽ� �Է��� �ּ���.");
					scan.nextLine();
					continue;
				}
			}

			// �Էµ� ���¹�ȣ ���� Ű������ ���� �� ���
			if (map_Account.containsKey(AC)) {
				// �ʿ� ����� �� ���¹�ȣ�� ������ ����.
				Account acc = map_Account.get(AC);
				while (true) {
					try {
						System.out.println("[ 0�Է½� �޴�ȭ������ �̵��մϴ�. ]");
						System.out.println("��ݾ��� �Է��ϼ��� :");
						// ��ĳ�ʷ� �Է¹��� ��ݾ��� ����.
						outmoney = scan.nextLong();
						if (outmoney < 0) {
							System.out.println("��ݾ��� �߸� �Է��Ͽ����ϴ�.");
							System.out.println("��ݾ��� 0�� �̻��� �ݾ����� �Է��ؾ��մϴ�.");
							continue;
						}else if(outmoney == 0)// �޴��� ���ư���
							break A; // A while�� Ż��
						break;
					} catch (Exception e) {
						System.out.println("��ݾ��� �߸� �Է��Ͽ����ϴ�.");
						System.out.println("��ݾ��� 0�� �̻��� �ݾ����� �Է��ؾ��մϴ�.");
						scan.nextLine();
						continue;
					}
				}
				// AccountŬ������ withdraw() ���ϰ� ����
				boolean res = acc.withdraw(outmoney);
				// ��� ó�� ����
				if (res) {
					System.out
							.println(acc.getNA_name() + "���� " + acc.getNA_code() + "���¿��� " + outmoney + "���� ����Ͽ����ϴ�.");
					System.out.println("��� �� �ܾ��� " + acc.getNA_open() + " �� �Դϴ�.");
				} else {
					// ��� ó�� ����
					System.out.println("��� ����. �ܾ׺���. ���� �ܾ��� " + acc.getNA_open() + "�� �Դϴ�.");
				}

				break; // ��� ����(���ó�� ����or����)�� ������ �޴��� �̵�
			} else {
				// �Էµ� ���¹�ȣ ���� Ű������ ���� ���� ���� ���
				System.out.println("�������� �ʴ� ���¹�ȣ �Դϴ�.");
				System.out.println("���¹�ȣ�� �ٽ� �Է��� �ּ���.");
				System.out.println();
				continue;
			}
		}
		// ���� ���� ���Ͽ� ����
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���   - printAllInfo()
	* @����     - ��ϵ� ������ü�� ������ ���
	* @�Ű����� - 
	* @���ϰ�   - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* �������� ������ �޴�ȭ�� �̵� ����
	* @---------------------------------------------------------------------
	*/
	public void printAllInfo() {
		Set<String> keys = map_Account.keySet(); // Ű��������
		// ���������� ������
		if (!CheckAccountInfo()) {
			return;
		}

		for (String key : keys) { // for each���� �̿��ؼ� key�� key�� Ű���� �ݺ�
			Account acc = map_Account.get(key); // Account ������ �����ͼ� acc�� �ν��Ͻ�ȭ

			if (acc.getNA_checkinterest() == 1) { // ������ 1 �Ϲ�(������)
				System.out.println("�Ϲݰ���");
				System.out.println("[ ������ : " + acc.getNA_name() 
				+ "]    ���¹�ȣ : " + acc.getNA_code() 
				+ "  ���� �ܾ� : " + acc.getNA_open() + "��");

			} else if (acc.getNA_checkinterest() == 2) { // ������ 2 ����(����)

				System.out.println("Ư������");
				System.out.println("[ ������ : " + acc.getNA_name() 
				+ "]    ���¹�ȣ : " + acc.getNA_code() 
				+ "  ���� �ܾ� : " + acc.getNA_open() + "��"
				+ " ������ :"
				+ ((SpecialAccount) map_Account.get(key)).getInterest_rate() + "%");
			}

		} 
	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���   - printInfo()
	* @����     - ��ϵ� ���ϰ����� ������ ���
	* @�Ű����� - 
	* @���ϰ�   - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* �˻� ��� ��ҽ� �޴�ȭ������ �̵� �ϵ��� ����
	* �������� ������ �޴�ȭ�� �̵� ����
	* @---------------------------------------------------------------------
	*/
	public void printInfo() {
		// �Է� ���尪
		String account_string = "";

		// ���������� ������
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {
			System.out.println("[ 0�Է½� �޴�ȭ������ �̵��մϴ�. ]");
			System.out.print("���¹�ȣ�� �Է��ϼ���. : ");
			account_string = scan.next(); // ����ڰ� �Է��� ���¹�ȣ ����.

			if (map_Account.containsKey(account_string)) {
				break;
			}
			else if(account_string.trim().equals("0")) {
				break;
			}
			else {
				System.out.println("���¸� �ٽ� �Է����ּ���.");
				continue;
			}
		}
		
		//�޴�ȭ�� �̵�
		if(account_string.trim().equals("0")) {
			return;
		}

		if (map_Account.containsKey(account_string)) {
			// �ʿ� �����  ���¹�ȣ�� ������ ����.
			Account acc = map_Account.get(account_string); // Account ������ �����ͼ� acc�� �ν��Ͻ�ȭ

			if (acc.getNA_checkinterest() == 1) { // ������ 1 �Ϲ�(������)
				System.out.println("�Ϲݰ���");
				System.out.println("[ ������ : " + acc.getNA_name() + "]    ���¹�ȣ : " + acc.getNA_code() + "  ���� �ܾ� : "
						+ acc.getNA_open() + "��");

			} else if (acc.getNA_checkinterest() == 2) { // ������ 2 ����(����)

				System.out.println("Ư������");
				System.out.println("[ ������ : " + acc.getNA_name() + "]    ���¹�ȣ : " + acc.getNA_code() + "  ���� �ܾ� : "
						+ acc.getNA_open() + "��" + " ������ :"
						+ ((SpecialAccount) map_Account.get(account_string)).getInterest_rate() + "%");
			} else {
				System.out.println("��ϵ��� ���� ���� �Դϴ�.");
				System.out.println();
			}
		}

	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���    - deleteAccount()
	* @����      - ��ϵ� �������� ����
	* @�Ű�����  - 
	* @���ϰ�    - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* ������� ��ҽ� �޴�ȭ������ �̵� �ϵ��� ����
	* �������� ������ �޴�ȭ�� �̵� ����
	* @---------------------------------------------------------------------
	*/

	public void deleteAccount() {
		
		// ���������� ������
		if (!CheckAccountInfo()) {
			return;
		}

		while (true) {

			System.out.println("�޴�ȭ������ ���ư��÷��� 0���� �Է��ϼ���");
			System.out.println();
			System.out.println("�����Ͻ� ���¹�ȣ�� �Է��ϼ���.>>");
			// ������ ���¹�ȣ �Է�
			AC = scan.next();
			if (AC.equals("0")) {
				break;
			} else if (map_Account.containsKey(AC)) {
				//map_Account.get(AC);
				map_Account.remove(AC);
				System.out.println("(" + AN + ")" + "������ ���¹�ȣ(" + AC + ")�� �����Ǿ����ϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

		// ���� ���� ���Ͽ� ����
		AccountFileSave();
	}

	/** @-----------------------------Function--------------------------------
	* @�Լ���    - AccountFileSave() 
	* @����      - ���� ������ ���Ͽ� ����(��������(������/����),���¹�ȣ,���¿�����,�ܾ�,������)
	* - ���� ���ϸ� : AccountInfo.txt
	* @�Ű�����  - 
	* @���ϰ�    - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* @---------------------------------------------------------------------
	*/
	@Override
	public void AccountFileSave() {
		//������ �����ν��Ͻ� ���� �� �ʱ�ȭ
    	File accountinfofile = new File("AccountInfo.txt");
    	
    	try {
    		//����ȭ�Ͽ� ���Ͽ� ����
    		
    		if(accountinfofile.exists() == false) {
    			//���� ������ ���ϻ���
    			accountinfofile.createNewFile();
        	}
    		
        	FileOutputStream fos = new FileOutputStream(accountinfofile); 
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	//��ϵ� ���� ������ ������ ���� ����
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
	* @�Լ���    - AccountFileLoad()
	* @����      - ���Ͽ� ����� �������� ���(��������(������/����),���¹�ȣ,���¿�����,�ܾ�,������)
	* - ��� ���ϸ� : AccountInfo.txt
	* @�Ű�����  - 
	* @���ϰ�    - 
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* @---------------------------------------------------------------------
	*/
	@Override
	public void AccountFileLoad() {
		
		//������ �����ν��Ͻ� ���� �� �ʱ�ȭ
    	File accountinfofile = new File("AccountInfo.txt");
    	
    	try {
    		//����ȭ�Ǿ� ���Ͽ� ����� ������ ȣ��
    		if(accountinfofile.exists()) {
    			FileInputStream fis = new FileInputStream(accountinfofile);
            	ObjectInputStream ois = new ObjectInputStream(fis);
            	
            	map_Account = (HashMap<String, Account>) ois.readObject();
            	
            	Set<String> keyset = map_Account.keySet();
            	
            	for (String key : keyset) {
            		StringBuffer strbuff = new StringBuffer();
            		if(map_Account.get(key).getNA_checkinterest() == 1 ) {
            			//������ ���� ���
            			strbuff.append(" [ ������ : ");
                		strbuff.append(map_Account.get(key).getNA_name());
                		strbuff.append(" ] ");
            			strbuff.append("\t���¹�ȣ : ");
                		strbuff.append(map_Account.get(key).getNA_code());
                		strbuff.append("\t�ܾ� : ");
                		strbuff.append(map_Account.get(key).getNA_open());
                		strbuff.append("\t�Ϲݰ���");
            		}
            		else {
            			//���� ���� ���� ���
            			strbuff.append(" [ ������ : ");
                		strbuff.append(map_Account.get(key).getNA_name());
                		strbuff.append(" ] ");
            			strbuff.append("\t���¹�ȣ : ");
                		strbuff.append(map_Account.get(key).getNA_code());
                		strbuff.append("\t�ܾ� : ");
                		strbuff.append(map_Account.get(key).getNA_open());
                		strbuff.append("\t������ : ");
                		strbuff.append(((SpecialAccount)map_Account.get(key)).getInterest_rate());
                		strbuff.append("%");
                		strbuff.append("\tƯ������");
            		}
            		System.out.println(strbuff.toString());
				}
            	
            	ois.close();
    		}
    		else {
    			//�������� ������
    			if(!CheckAccountInfo()) {
    				return;
    			}
    		}
        	
		} catch (Exception e) {
			//e.printStackTrace();
			//�������� ������
			if(!CheckAccountInfo()) {
				
				if(accountinfofile.exists()) {
					//�ʿ� ���� ������ ���µ� ������ �ִٸ� ���� ����
					accountinfofile.delete();
				}
				return;
			}
			System.out.println("���Ͽ� ����� ������ �����ϴ�.");
		}
		
	}
	/** @-----------------------------Function--------------------------------
	* @�Լ���    - CheckAccountInfo()
	* @����      - �ؽ��ʿ� �������� ���� ���� �˻�
	* @�Ű�����  - 
	* @���ϰ�    - isCheck : true�� �������� ����, false�� ���� ���� ����
	* @---------------------------------------------------------------------
	* @�۾������׿��ܻ���
	* @�߰��۾������Է�
	* @---------------------------------------------------------------------
	*/
	public boolean CheckAccountInfo() {
		boolean isCheck = true;
		// ���������� ������
		if (map_Account.size() <= 0) {
			System.out.println("���¸� ������ּ���");
			isCheck = false;
		}
		return isCheck;
	}

}
