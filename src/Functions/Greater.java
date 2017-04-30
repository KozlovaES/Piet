/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Greater extends Function{
    public Greater(){ name = new String("greater");}
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        if (a>b)
            agent.stack.push(1);
        else
            agent.stack.push(0);
        return agent;
    }
}