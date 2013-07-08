package iam.rizel.prism.broadcast;

import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;
import iam.rizel.prism.event.ServerEventType;
import iam.rizel.prism.observer.Observer;
import iam.rizel.prism.observer.ObserverRegistrator;

import java.util.EnumMap;
import java.util.Map;

public class BroadcasterContainerImpl implements BroadcasterContainer, ObserverRegistrator {

    private Map<ServerEventType, Broadcaster> broadcasterMap;

    public BroadcasterContainerImpl() {
        this.broadcasterMap = new EnumMap<ServerEventType, Broadcaster>(ServerEventType.class);
        
        Broadcaster sayBroadcaster = new BroadcasterImpl();
        
        addBroadcaster(ServerEventType.SAY, sayBroadcaster);
    
    }

    @Override
    public void addBroadcaster(ServerEventType type, Broadcaster broadcaster) {
        broadcasterMap.put(type, broadcaster);
    }

    @Override
    public EventResponse onEvent(ServerEvent event) {
        Broadcaster broadcaster = broadcasterMap.get(event.getType());
        return broadcaster.broadcast(event);
    }

	@Override
	public void registerObserver(ServerEventType type, Observer observer) {
		broadcasterMap.get(type).registerObserver(observer);		
	}
	
	@Override
	public void unregisterObserver(ServerEventType type, Observer observer) {
		broadcasterMap.get(type).unregisterObserver(observer);
	}
}
