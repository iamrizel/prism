package iam.rizel.prism.eventreceiver;

import iam.rizel.prism.broadcast.BroadcasterContainer;
import iam.rizel.prism.event.EventReceiver;
import iam.rizel.prism.event.EventResponse;
import iam.rizel.prism.event.ServerEvent;

public class EventReceiverImpl implements EventReceiver {

	private BroadcasterContainer container;
	
	public EventReceiverImpl(BroadcasterContainer container) {
		this.container = container;
	}
	
	@Override
	public EventResponse fireEvent(ServerEvent event) {
		
		return container.onEvent(event);
	}

}
