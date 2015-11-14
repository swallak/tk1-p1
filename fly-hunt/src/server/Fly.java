/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swallak
 */
public class Fly {

    private Position pos;

    Fly(int x, int y) {
        this.pos = new Position(x, y);
    }

    public void setPosittion(int x, int y) {
        try {
            pos.setPosition(x, y);
        } catch (PositionInvalidException ex) {
            Logger.getLogger(Fly.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Position invalid");
        }
    }
    public int getposX()
    {
        return pos.getPosX();
    }
    public int getPosY()
    {
        return pos.getPosY();
    }

}
