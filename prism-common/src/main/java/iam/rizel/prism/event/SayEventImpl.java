package iam.rizel.prism.event;

public class SayEventImpl implements SayEvent {

    private String message;

    @Override
    public ServerEventType getType() {
        return ServerEventType.SAY;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
    	return message;
    }
}
