package iam.rizel.prism.broadcast;

import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.EventResponseImpl;
import iam.rizel.prism.event.ServerEvent;
import iam.rizel.prism.observer.Observer;

import java.util.LinkedList;
import java.util.List;

public class BroadcasterImpl implements Broadcaster{

    protected List<Observer> observerList;

    public BroadcasterImpl() {
        this.observerList = new LinkedList<Observer>();
    }

    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    public EventResponse broadcast(ServerEvent event) {

        boolean blocking = false;

        for(Observer observer : observerList) {
            if(observer.fire(event))
                blocking = true;
        }

        if(blocking) {
            EventResponse response = new EventResponseImpl();
            response.setBlocking(true);

            return response;
        } else {
            EventResponse response = new EventResponseImpl();
            response.setBlocking(false);

            return response;
        }
    }
}
