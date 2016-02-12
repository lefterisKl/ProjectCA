
package projectca;

import java.util.ArrayList;


public class Controler {
   static private DirectedGraph dg;
   static private Executioner ex;
    
    
    
    public static void main(String[] args)
    {
        ArrayList<Integer> phase;
      
        dg = new DirectedGraph();
        dg.readGraph(args[0]);
        ex = new Executioner();
        int i=1;
        while((phase=dg.getNextPhase()) != null)
        {
            System.out.print("phase"+ i+": jobs[");
            for(Integer job:phase)
                System.out.print(job+" ");
            System.out.println("\b] will start concurrent execution..");
            ex.executePhase(phase);
            i++;
            System.out.println("");
        }
        
    }
}
