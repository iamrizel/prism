package iam.rizel.prism.event;

import java.io.Serializable;

public interface EventResponse extends Serializable {

    public boolean isBlocking();

    public void setBlocking(boolean blocking);

}
