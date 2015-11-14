/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.IGameClient;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author swallak
 */
public class Server implements IGameSever{
    
    private HashMap<Gamer,Integer> connectedGamers; // Synchronitation issuses ??
    private Fly fly;
    private String hostName;
    private Server(String hostName)
    {
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
        // TODO code application logic here
    }

    @Override
    public boolean login(String userName, IGameClient client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout(String userName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void huntFly(String userName) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
