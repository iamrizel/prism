package iam.rizel.prism.event;

public class EventResponseImpl implements EventResponse {

    private boolean blocking;

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    @Override
    public boolean isBlocking() {
        return blocking;
    }
}
