/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lefteris
 */
public class Executioner {

    void executePhase(ArrayList<Integer> phase) {
        ArrayList<Thread> jobs = new ArrayList<>();
        for(Integer jid : phase)
        {
           
           Thread t = ( new Thread(new WorkDummy(jid)));
           t.start();
           jobs.add(t);
        }
        try 
        {
            for(int i=0;i<jobs.size();i++)
                jobs.get(i).join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Executioner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
