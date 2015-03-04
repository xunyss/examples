package org.xunyss.examples.rmi.type2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
			SimpleRmiService service = (SimpleRmiService) registry.lookup(SimpleRmiService.BIND_NAME);

			Request request = new Request("client_request_value");
			Response response = service.request(request);
			System.out.println("Client > response value : " + response.getValue());
			
			/**
			 * 비동기호출
			 */
			service.asynchronousRequest(new CallbackImpl(), request);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
