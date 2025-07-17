package org.xunyss.examples.rmi.type1;

import java.rmi.Naming;

public class HelloClient {

	public static void main(String[] args) {
		try {
			Hello service = (Hello) Naming.lookup("rmi://localhost:1099/HelloRemote");
			String s = service.sayHello("jh");
			System.out.println(s);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
