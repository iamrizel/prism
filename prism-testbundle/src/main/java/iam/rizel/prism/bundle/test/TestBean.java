package iam.rizel.prism.bundle.test;


import iam.rizel.prism.bundle.test.observer.SayObserver;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.ObserverRegistrator;

public class TestBean {
	
	private ObserverRegistrator registrator;
	
	private SayObserver observer;
	
	public ObserverRegistrator getRegistrator() {
		return registrator;
	}
	
	public void setRegistrator(ObserverRegistrator registrator) {
		this.registrator = registrator;
		
		System.out.println("R!!!!!!!!!!!!!!!!!!!!!!!!!!!!! SET " + registrator.toString());
	}
	
	public void create() {
		System.out.println(":::::::::::::Create");
		observer = new SayObserver();
	    registrator.registerObserver(ServerEventType.SAY, observer);
	}
	
	public void destroy() {
		System.out.println(":::::::::::::Destroy");
		registrator.unregisterObserver(ServerEventType.SAY, observer);
	}

}
