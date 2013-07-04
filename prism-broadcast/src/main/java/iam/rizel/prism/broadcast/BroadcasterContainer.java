package iam.rizel.prism.broadcast;

import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;
import iam.rizel.prism.event.ServerEventType;

public interface BroadcasterContainer {

    public void addBroadcaster(ServerEventType type, Broadcaster broadcaster);

    public EventResponse onEvent(ServerEvent event);

}
