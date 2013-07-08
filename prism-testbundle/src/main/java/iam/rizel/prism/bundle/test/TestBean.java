package iam.rizel.prism.bundle.test;


import iam.rizel.prism.bundle.test.observer.SayObserver;
import iam.rizel.prism.config.Config;
import iam.rizel.prism.config.ConfigImpl;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.ObserverRegistrator;

public class TestBean {
	
	private ObserverRegistrator registrator;
	
	private SayObserver observer;
	
	private Config config;
	
	public ObserverRegistrator getRegistrator() {
		return registrator;
	}
	
	public void setRegistrator(ObserverRegistrator registrator) {
		this.registrator = registrator;
	}
	
	public void create() {
		observer = new SayObserver();
	    registrator.registerObserver(ServerEventType.SAY, observer);
	    config = new ConfigImpl(TestBean.class);
	    System.out.println(config.getString("//TestParameter"));
	}
	
	public void destroy() {
		registrator.unregisterObserver(ServerEventType.SAY, observer);
	}

}
