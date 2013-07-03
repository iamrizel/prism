package iam.rizel.prism;

import iam.rizel.prism.broadcaster.Broadcaster;
import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;
import iam.rizel.prism.event.ServerEventType;

import java.util.EnumMap;
import java.util.Map;

public class BroadcasterContainerImpl implements BroadcasterContainer {

    private Map<ServerEventType, Broadcaster> broadcasterMap;

    public BroadcasterContainerImpl() {
        this.broadcasterMap = new EnumMap<ServerEventType, Broadcaster>(ServerEventType.class);
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
}
