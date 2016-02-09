/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lefteris
 */
public class DirectedGraph {
    private HashMap<Integer,ArrayList<Integer>> graph; // (key of vertex, incoming edges) 
   
    public DirectedGraph()
    {
        graph = new HashMap<>();
        
    }
    public DirectedGraph(String filename)
    {
        readGraph(filename);
    }
    
    public void readGraph(String filename)
    {
        
    }
    
    ArrayList<Integer> getNextPhase()
    {
        if(graph.size()==0)
        {
            return null;
        }
        ArrayList<Integer> phase = new ArrayList<>();
        for (HashMap.Entry<Integer,ArrayList<Integer>> entry : graph.entrySet()) 
        {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            if(value.size()==0)
            {
                phase.add(key);
                graph.remove(key);
                for (Integer k : graph.keySet()) 
                {
                    graph.get(k).remove(key);
                }
            }
        }
        return phase;
    }
    
        
}
