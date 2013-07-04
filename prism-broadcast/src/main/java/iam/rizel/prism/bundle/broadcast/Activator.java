package iam.rizel.prism.bundle.broadcast;

import iam.rizel.prism.broadcast.Broadcaster;
import iam.rizel.prism.broadcast.BroadcasterContainer;
import iam.rizel.prism.broadcast.BroadcasterContainerImpl;
import iam.rizel.prism.broadcast.BroadcasterImpl;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.ObserverRegistrator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		ObserverRegistrator registrator = new BroadcasterContainerImpl();
        BroadcasterContainer bc = (BroadcasterContainer)registrator;
        Broadcaster sayBroadcaster = new BroadcasterImpl();

        System.out.println("Register service: ObserverRegistrator");
        
        bc.addBroadcaster(ServerEventType.SAY, sayBroadcaster);
        context.registerService(ObserverRegistrator.class.getName(), registrator, null);
        context.registerService(BroadcasterContainer.class.getName(), registrator, null);
	}

	public void stop(BundleContext context) throws Exception {
				
	}

}
