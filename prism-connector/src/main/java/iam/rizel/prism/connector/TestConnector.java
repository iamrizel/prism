package iam.rizel.prism.connector;

import iam.rizel.prism.event.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestConnector {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry;

        registry = LocateRegistry.getRegistry(19991);

        EventReceiver receiver = (EventReceiver) registry.lookup("rmi://EventReceiver");

        SayEvent event = new SayEventImpl();
        event.setMessage("HelloWorld");

        EventResponse response = receiver.fireEvent(event);

        System.out.println(response.isBlocking());

    }

}
