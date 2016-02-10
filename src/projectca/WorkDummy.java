/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

/**
 *
 * @author lefteris
 */
public class WorkDummy implements Runnable {

    Integer jid;
    
    WorkDummy(Integer jid)
    {
        this.jid = jid;
    }
    
    
    public void run() {
        int x=0;
        for(int i=0;i<9999999;i++)
        {
             x++;
             x--;
        }
        System.out.println("Job "+jid+" is done.");
    }
    
    
    
}
