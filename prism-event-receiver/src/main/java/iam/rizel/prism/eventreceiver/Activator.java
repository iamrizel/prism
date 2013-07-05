package iam.rizel.prism.eventreceiver;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.annotation.Resource;


import iam.rizel.prism.broadcast.BroadcasterContainer;
import iam.rizel.prism.event.EventReceiver;
import iam.rizel.prism.observer.ObserverRegistrator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private EventReceiver receiver;
	private Remote remoteReceiver;
	private Registry rmiRegistry;
	
	@Resource
	public BroadcasterContainer container;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("EventReceiver started");
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("EventReceiver stopped");
	}

}
