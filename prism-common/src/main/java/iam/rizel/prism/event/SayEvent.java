package iam.rizel.prism.event;

public interface SayEvent extends ServerEvent {
	
	public String getMessage();
	public void setMessage(String message);

}
