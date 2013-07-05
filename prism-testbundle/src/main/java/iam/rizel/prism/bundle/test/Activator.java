package iam.rizel.prism.bundle.test;

import javax.annotation.Resource;
import javax.xml.ws.BindingType;

import iam.rizel.prism.bundle.test.observer.SayObserver;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.ObserverRegistrator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.springframework.beans.factory.annotation.Autowired;

public class Activator implements BundleActivator{
	
	@Autowired
	private ObserverRegistrator registrator;
	private SayObserver observer;
	
	@Autowired
	private TestBean tb;
	
	private String valami;
	
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle start ");
                
  //      observer = new SayObserver();
    //    registrator.registerObserver(ServerEventType.SAY, observer);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle stop");
        
      //  registrator.unregisterObserver(ServerEventType.SAY, observer);
    }
}
