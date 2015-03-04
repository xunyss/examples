package org.xunyss.examples.rmi.type2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback extends Remote {

	public void response(Response response) throws RemoteException;
}
