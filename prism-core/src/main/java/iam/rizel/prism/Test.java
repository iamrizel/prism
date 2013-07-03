package iam.rizel.prism;

import iam.rizel.prism.broadcaster.Broadcaster;
import iam.rizel.prism.broadcaster.BroadcasterImpl;
import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.SayEvent;
import iam.rizel.prism.event.ServerEventType;

public class Test {

    public static void main(String[] args) {

        BroadcasterContainer broadcasterContainer = new BroadcasterContainerImpl();

        Broadcaster sayBroadcaster = new BroadcasterImpl();

        broadcasterContainer.addBroadcaster(ServerEventType.SAY, sayBroadcaster);

        SayEvent event = new SayEvent();
        event.setMessage("HelloWorld");

        EventResponse response = broadcasterContainer.onEvent(event);

        System.out.println(response.isBlocking());

    }

}
