package iam.rizel.prism.eventreceiver;

import iam.rizel.prism.broadcast.BroadcasterContainer;
import iam.rizel.prism.event.EventReceiver;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Init {
	
	private EventReceiver receiver;
	private Remote remoteReceiver;
	private Registry rmiRegistry;
	
	public BroadcasterContainer container;

	public void setContainer(BroadcasterContainer container) {
		this.container = container;
	}
	
	public BroadcasterContainer getContainer() {
		return container;
	}
	
	public void create() throws Exception {
        receiver = new EventReceiverImpl(container);

        rmiRegistry = LocateRegistry.createRegistry(19991);

        remoteReceiver = UnicastRemoteObject.exportObject(receiver, 0);
        rmiRegistry.rebind("rmi://EventReceiver", remoteReceiver);
		
	}

	public void destroy() throws Exception {
		rmiRegistry.unbind("rmi://EventReceiver");
		UnicastRemoteObject.unexportObject(remoteReceiver, false);
	}
}
