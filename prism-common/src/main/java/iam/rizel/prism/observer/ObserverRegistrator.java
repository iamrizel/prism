package iam.rizel.prism.observer;

import iam.rizel.prism.event.ServerEventType;

public interface ObserverRegistrator {
	
	public void registerObserver(ServerEventType type, Observer observer);
	public void unregisterObserver(ServerEventType type, Observer observer);

}
