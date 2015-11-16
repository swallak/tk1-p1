/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author swallak
 */
public class Gamer implements Serializable {
    
    private String userName;
    private int score;
    
    public Gamer (String userName)
    {
        this.userName = userName;
        this.score = 0;
    }
    
    public void incrScore()
    {
        this.score++;
    }
    
    public int getScore()
    {
        return this.score;
    }
    public String getUserName ()
    {
        return this.userName;
    }
    @Override
    public boolean equals (Object g)
    {
        return ((Gamer)g).userName == this.userName;
    }
    @Override
    public int hashCode ()
    {
        return this.userName.hashCode();
    }
    @Override
    public String toString()
    {
        return userName +" "+ score;
    }
    
}
