/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Random;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author swallak
 */
public class Server implements IGameSever {

    private HashMap<String, Gamer> connectedGamers; // Synchronitation issuses ??
    private Fly fly;
    public final static String name = "SERVER";

    private Server() {
        super();
        connectedGamers = new HashMap<>();
        //Generation initial random position
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        fly = new Fly(Math.abs(x), Math.abs(y));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Setting the security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            IGameSever server = new Server();
            IGameSever stub = (IGameSever) UnicastRemoteObject.exportObject(server, 0);

            Registry reg = LocateRegistry.getRegistry();
            reg.rebind(Server.name, stub);
        } catch (RemoteException ex) {
            System.out.println("Remote exeption");
            ex.printStackTrace();
        }
        System.out.println("Server is running");

    }

    @Override
    public boolean login(String userName) throws RemoteException {
        boolean result = connectedGamers.containsKey(userName);
        if (result)
        {
            System.out.println("An existing user is trying to connect");
        }
        else
        {
            System.out.println("new User "+userName+" has been added");
            Gamer g = new Gamer(userName);
            connectedGamers.put(userName, g);
        }
        return !result;
    }

    @Override
    public boolean logout(String userName) throws RemoteException {

        Gamer g = connectedGamers.remove(userName);
        if (g == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void huntFly(String userName) throws RemoteException {
        this.fly.changePosition();
        Gamer g = connectedGamers.get(userName);
        g.incrScore();
        connectedGamers.put(userName, g);

    }

    @Override
    public Object[] getGamers() throws RemoteException {
        
        Object[] gamers =  new Object[connectedGamers.size()];
        //gamers[0]=connectedGamers.get("swallak");
        gamers = connectedGamers.values().toArray();
        return gamers;
        //return (Gamer[])connectedGamers.values().toArray();
    }

    @Override
    public Position getFlyPosition() throws RemoteException {
        return new Position(fly.getposX(), fly.getposX());
    }

}
