package org.xunyss.examples.rmi.type2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements Callback {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3405543871810374683L;
	
	protected CallbackImpl() throws RemoteException {
		super();
	}

	@Override
	public void response(Response response) throws RemoteException {
		System.out.println("Response received : " + response);
		System.out.println("Response : " + response.getClass().getClassLoader());
	}
}
