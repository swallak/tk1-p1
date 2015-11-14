/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.Client;
/**
 *
 * @author swallak
 */
public interface IGameSever extends Remote{
    
    boolean login (String userName, Client client) throws RemoteException;
    boolean logout (String userName)throws RemoteException;
    void huntFly (String userName)throws RemoteException;
    
}
