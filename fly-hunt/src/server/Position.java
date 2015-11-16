/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swallak
 */
public class Position implements Serializable{

    private int posX;
    private int posY;

    public Position(int x, int y) {
        try {
            setPosition(x,y);
        } catch (PositionInvalidException ex) {
            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Invalid Position");
        }
    }

    public void setPosition(int x, int y) throws PositionInvalidException {
        if(x>=0 && y>=0)
        {
            this.posX=x;
            this.posY=y;
        }
        else
            throw new PositionInvalidException();

    }
    public int getPosX()
    {
        return this.posX;
    }
    public int getPosY()
    {
        return this.posY;
    }
    @Override
    public String toString()
    {
        return "("+posX+","+posY+")";
    }

}

class PositionInvalidException extends Exception {

    public PositionInvalidException() {
        super();
    }
}
