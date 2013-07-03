package iam.rizel.prism.event;

public class SayEvent implements ServerEvent {

    private String message;

    @Override
    public ServerEventType getType() {
        return ServerEventType.SAY;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
