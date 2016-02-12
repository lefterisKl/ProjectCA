package projectca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        File fin = new File(filename);
	FileInputStream fis=null;
        try {
            fis = new FileInputStream(fin);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
 
	
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
        try {
            while ((line = br.readLine()) != null) {
               String[] edgelist = line.split(" ");
               ArrayList<Integer> incoming  = new ArrayList<>();
               Integer node = Integer.parseInt(edgelist[0]);
               for(int i=1;i<edgelist.length;i++)
               {
                    incoming.add(Integer.parseInt(edgelist[i]));
               }
               graph.put(node, incoming);
            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
 
	

    }
    
    public void display()
    {
         for (HashMap.Entry<Integer,ArrayList<Integer>> entry : graph.entrySet()) 
        {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            System.out.print(key+" " );
            for(Integer e : value)
            {
                System.out.print(e+" ");
            }
            System.out.println("");
        }
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
                //graph.remove(key);
                for (Integer k : graph.keySet()) 
                {
                    graph.get(k).remove(key);
                }
            }
            
        }
        
        for( Integer key : phase)
        {
            graph.remove(key);
        }
        return phase;
    }
    
    
       
    
    
        
}
