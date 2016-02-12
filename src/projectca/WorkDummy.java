package projectca;


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
