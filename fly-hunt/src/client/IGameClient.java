/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import server.Position;

/**
 *
 * @author swallak
 */
public interface IGameClient {
    
    void receiveFlyPosition(Position p);
    
}
