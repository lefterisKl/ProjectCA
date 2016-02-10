/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

import java.util.ArrayList;

/**
 *
 * @author lefteris
 */
public class Controler {
   static private DirectedGraph dg;
   static private Executioner ex;
    
    
    
    public static void main(String[] args)
    {
        ArrayList<Integer> phase;
        //dg = new DirectedGraph(args[0]);
        dg = new DirectedGraph();
        dg.readGraph("testfile");
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
