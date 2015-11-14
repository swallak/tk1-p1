/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.IGameClient;
/**
 *
 * @author swallak
 */
public interface IGameSever extends Remote{
    
    boolean login (String userName, IGameClient client) throws RemoteException;
    void logout (String userName)throws RemoteException;
    void huntFly (String userName)throws RemoteException;
    
}
