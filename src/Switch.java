/**
 * Created by Ekaterina on 02.05.2017.
 */
public class Switch extends Function{
    public Switch(){name = new String("switch");}
    public Agent work(Agent agent){
        int a;
        a = Math.abs(Integer.parseInt(agent.stack.pop().toString()));
        for (int i=0;i<a;i++){
            agent.change_cc();
        }
        return agent;
    }
}