package org.xunyss.examples.rmi.type2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleRmiService extends Remote {

	String BIND_NAME = "SimpleRmiService";
	
	Response request(Request request) throws RemoteException;
	
	void asynchronousRequest(Callback callback, Request request) throws RemoteException;
}
