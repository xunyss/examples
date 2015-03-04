package org.xunyss.examples.rmi.type1;

import java.rmi.Naming;

public class HelloServer {

//	�Ʒ���� ���� (RMI Registry ����)
//	�⺻ ��Ʈ��ȣ : 1099
//	> C:\Program Files\Java\jdk1.6.0_37\bin\rmiregistry.exe 1099
	
	public static void main(String[] args) {
		try {
			Hello service = new HelloImpl();
			
			/**
			 * bind name ..
			 * "HelloRemote"
			 * "rmi://ȣ��Ʈ/HelloRemote"
			 * "rmi://ȣ��Ʈ:��Ʈ/HelloRemote"
			 * 
			 * rmiregistry.exe(RMI Registry) ���� ������ ��Ʈ��ȣ�� ���
			 */
			Naming.rebind("rmi://localhost:1099/HelloRemote", service);
			
			System.out.println("bind service.!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
