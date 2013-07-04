package iam.rizel.prism.bundle.test.observer;

import iam.rizel.prism.event.SayEvent;
import iam.rizel.prism.event.ServerEvent;
import iam.rizel.prism.observer.Observer;

public class SayObserver implements Observer {

	@Override
	public Boolean fire(ServerEvent serverEvent) {
		SayEvent event = (SayEvent) serverEvent;
		
		System.out.println("TestObserver: " + event.getMessage());
		
		return false;
	}

}
