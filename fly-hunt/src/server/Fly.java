/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;

/**
 *
 * @author swallak
 */
public class Fly extends TimerTask implements Serializable{

    private Position pos;

    public Fly(int x, int y) {
        this.pos = new Position(x, y);
        Timer t = new Timer();
        t.schedule(this, 0, 1000);
    }

    public void setPosition(int x, int y) {
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
    public void changePosition()
    {
        Random r1 = new Random();
        Random r2 = new Random();
        int x = r1.nextInt();
        int y = r2.nextInt();
        this.setPosition(Math.abs(x), Math.abs(y));
    }
    @Override
    public String toString()
    {
        return "("+pos.getPosX()+","+pos.getPosY()+")";
    }

    @Override
    public void run() {
        this.changePosition();
    }

}
