/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import server.Position;
import server.Server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.IGameSever;
/**
 *
 * @author swallak
 */
public class Client {

    private String myUserName;
    private int myScore;
    private IGameSever server;

    public Client(String serverHostName) {
        try {
            Registry reg = LocateRegistry.getRegistry(serverHostName);
            server = (Server) reg.lookup(Server.name);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean connect() {
        boolean result = false;
        System.out.println("trying to connect...");
        try {
            result = server.login(myUserName);
        } catch (RemoteException ex) {
            System.out.println("Connection Error");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public Position getFlyPosition()
    {
        Position pos = null;
        
        try {
            pos = server.getFlyPosition();
        } catch (RemoteException ex) {
            System.out.println("Connection Error");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pos;
    }
    public void setMyUserName (String myName)
    {
        this.myUserName = myName;
    }
    public int getMyScore()
    {
        return this.myScore;
    }
    
    public static void main (String[] args){
        
        // Setting the security manager for the client
        if(System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }
        System.out.println("Hallo!!");
//        //Connecting the client
//        //args[0] is the server host name for the rmi registry
        Client client = new Client("localhost");
        client.setMyUserName(args[1]);
        boolean connection = client.connect();
        
    }

}
