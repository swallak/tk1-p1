/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.Client;
import java.util.Collection;
/**
 *
 * @author swallak
 */
public interface IGameSever extends Remote{
    
    boolean login (String userName) throws RemoteException;
    boolean logout (String userName)throws RemoteException;
    void huntFly (String userName)throws RemoteException;
    Object[] getGamers() throws RemoteException;
    Position getFlyPosition() throws RemoteException;
    
}
