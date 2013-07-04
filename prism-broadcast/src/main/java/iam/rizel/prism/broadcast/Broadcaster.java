package iam.rizel.prism.broadcast;

import iam.rizel.prism.Observer;
import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;

public interface Broadcaster {

    public void registerObserver(Observer observer);

    public void unregisterObserver(Observer observer);

    public EventResponse broadcast(ServerEvent event);

}
