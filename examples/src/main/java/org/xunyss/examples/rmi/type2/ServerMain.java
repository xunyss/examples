package org.xunyss.examples.rmi.type2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author XUNY
 */
public class ServerMain {
	
	public static void main(String[] args) {
		try {
			/**
			 * RMI Registry ���� (����)
			 * rmiregistry.exe �� �����ϴ� �� ��� �Ʒ��� ���� �ۼ��� �� ����
			 * �⺻ ��Ʈ��ȣ : 1099
			 */
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			SimpleRmiService service = new SimpleRmiServiceImpl();
			registry.bind(SimpleRmiService.BIND_NAME, service);
			System.out.println("Server started..");
			
			/*
			registry.unbind(SimpleRmiService.BIND_NAME);
			UnicastRemoteObject.unexportObject(service, true);
			*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
