/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author swallak
 */
public class AbstractSubject {
    
    IViewer viewer;
    
    public AbstractSubject()
    {
        super();
    }
    public void changeViewer(IViewer viewer)
    {
        this.viewer = viewer;
    }
    public void removeViewer()
    {
        this.viewer = null;
    }
    public void informViewer ()
    {
        this.viewer.upDateView();
    }

    
}
