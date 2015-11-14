/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Client;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Random;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author swallak
 */
public class Server implements IGameSever {

    private HashMap<String, Gamer> connectedGamers; // Synchronitation issuses ??
    private Fly fly;
    private String hostName;

    private Server(String hostName) {
        super();
        connectedGamers = new HashMap<>();
        //Generation initial random position
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        fly = new Fly(x, y);
        this.hostName = hostName;

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
            String hostName = "";
            IGameSever server = new Server(hostName);
            IGameSever stub = (Server) UnicastRemoteObject.exportObject(server, 0);

            Registry reg = LocateRegistry.getRegistry();
            reg.rebind(hostName, stub);
            System.out.println("Server is running");
        } catch (RemoteException ex) {
            System.out.println("server.Server.main()");;
        }

    }

    @Override
    public boolean login(String userName, Client client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
