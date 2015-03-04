package org.xunyss.examples.rmi.type1;

import java.rmi.Naming;

public class HelloServer {

//	아래명령 수행 (RMI Registry 실행)
//	기본 포트번호 : 1099
//	> C:\Program Files\Java\jdk1.6.0_37\bin\rmiregistry.exe 1099
	
	public static void main(String[] args) {
		try {
			Hello service = new HelloImpl();
			
			/**
			 * bind name ..
			 * "HelloRemote"
			 * "rmi://호스트/HelloRemote"
			 * "rmi://호스트:포트/HelloRemote"
			 * 
			 * rmiregistry.exe(RMI Registry) 에서 지정된 포트번호를 사용
			 */
			Naming.rebind("rmi://localhost:1099/HelloRemote", service);
			
			System.out.println("bind service.!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
