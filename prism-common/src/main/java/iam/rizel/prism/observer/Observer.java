package iam.rizel.prism.observer;

import iam.rizel.prism.event.ServerEvent;

public interface Observer {
    public Boolean fire(ServerEvent serverEvent);

}
