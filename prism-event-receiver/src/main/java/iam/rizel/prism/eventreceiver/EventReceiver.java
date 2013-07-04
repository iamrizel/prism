package iam.rizel.prism.eventreceiver;

import java.rmi.Remote;

import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;

public interface EventReceiver extends Remote {
	
	public EventResponse fireEvent(ServerEvent event);

}
