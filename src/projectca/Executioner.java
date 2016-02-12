package projectca;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
