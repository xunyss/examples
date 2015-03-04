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
		 * �����ڿ� Remote ��ü�� ���������� ��� �� ��Ʈ��ȣ ���� (RMI registry �� ��Ʈ��ȣ�ʹ� �ٸ� ����)
		 * �������� ���� ��� random �� ��ȣ�� ���Ƿ� ���� ��
		 * ������ ���α׷� ���� ��쿡 ���ؼ� RMI registry �� ��Ʈ��ȣ�� ������ ��ȣ�� ������ �� ����.
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
