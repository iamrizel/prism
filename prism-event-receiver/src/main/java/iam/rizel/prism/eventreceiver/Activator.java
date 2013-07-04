package iam.rizel.prism.eventreceiver;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import iam.rizel.prism.broadcast.BroadcasterContainer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private EventReceiver receiver;
	private Remote remoteReceiver;
	private Registry rmiRegistry;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("EventReceiver started");
		ServiceReference ref = context.getServiceReference(BroadcasterContainer.class.getName());
        BroadcasterContainer container = context.getService(ref);
        
        receiver = new EventReceiverImpl(container);
        
        rmiRegistry = LocateRegistry.createRegistry(19991);
        
        remoteReceiver = UnicastRemoteObject.exportObject(receiver, 0);
        rmiRegistry.rebind("rmi://EventReceiver", remoteReceiver);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("EventReceiver stopped");
		rmiRegistry.unbind("rmi://EventReceiver");
		UnicastRemoteObject.unexportObject(remoteReceiver, false);
	}

}
