/**
 * Created by Ekaterina on 02.05.2017.
 */
public class Pointer extends Function {
    public Pointer(){name = new String("pointer");}
    public Agent work(Agent agent){
        int a;
        a = Integer.parseInt(agent.stack.pop().toString());
        int dir;
        if (a>0)
            dir = 1;
        else
            dir = 0;
        for (int i=0;i<a;i++){
            agent.change_dp(dir);
        }
        return agent;
    }
}
