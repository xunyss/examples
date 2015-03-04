package org.xunyss.examples.rmi.type2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SimpleRmiServiceImpl extends UnicastRemoteObject implements SimpleRmiService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Executor executor = Executors.newSingleThreadExecutor();
	
	protected SimpleRmiServiceImpl() throws RemoteException {
		/**
		 * 생성자에 Remote 객체가 내부적으로 사용 할 포트번호 지정 (RMI registry 의 포트번호와는 다른 거임)
		 * 지정하지 않을 경우 random 한 번호가 임의로 설정 됨
		 * 동일한 프로그램 내일 경우에 한해서 RMI registry 의 포트번호와 동일한 번호를 지정할 수 있음.
		 */
		super();
	}

	@Override
	public Response request(Request request) throws RemoteException {
		System.out.println("Server.request() executed..");
		
		return new Response("Response @ " + request.getValue());
	}
	
	public void asynchronousRequest(final Callback callback, final Request request) throws RemoteException {
		System.out.println("Server.asynchronousRequest() executed..");
		
		executor.execute(new Runnable() {
			public void run() {
				try {
					Response response = new Response("Response @ " + request.getValue());
					callback.response(response);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
