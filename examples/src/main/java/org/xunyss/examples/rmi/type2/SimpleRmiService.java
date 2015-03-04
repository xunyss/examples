package org.xunyss.examples.rmi.type2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleRmiService extends Remote {

	public static final String BIND_NAME = "SimpleRmiService";
	
	public Response request(Request request) throws RemoteException;
	
	public void asynchronousRequest(Callback callback, Request request) throws RemoteException;
}
