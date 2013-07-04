package iam.rizel.prism.bundle.test;

import iam.rizel.prism.bundle.test.observer.SayObserver;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.ObserverRegistrator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator{
	
	private SayObserver observer;
	
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle start");
                
        ServiceReference ref = bundleContext.getServiceReference(ObserverRegistrator.class.getName());
        ObserverRegistrator registrator = (ObserverRegistrator) bundleContext.getService(ref);
        
        observer = new SayObserver();
        registrator.registerObserver(ServerEventType.SAY, observer);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle stop");
        ServiceReference ref = bundleContext.getServiceReference(ObserverRegistrator.class.getName());
        ObserverRegistrator registrator = (ObserverRegistrator) bundleContext.getService(ref);
        
        registrator.unregisterObserver(ServerEventType.SAY, observer);
    }
}
