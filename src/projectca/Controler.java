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
        dg = new DirectedGraph(args[0]);
        ex = new Executioner();
        
        while((phase=dg.getNextPhase()) != null)
        {
            ex.executePhase(phase);
        }
        
    }
}
