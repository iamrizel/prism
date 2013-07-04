package iam.rizel.prism.event;

import java.rmi.Remote;
import java.rmi.RemoteException;

import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;

public interface EventReceiver extends Remote {
	
	public EventResponse fireEvent(ServerEvent event) throws RemoteException;

}
