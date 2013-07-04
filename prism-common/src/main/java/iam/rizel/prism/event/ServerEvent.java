package iam.rizel.prism.event;

import java.io.Serializable;

public interface ServerEvent extends Serializable {

    public ServerEventType getType();

}
