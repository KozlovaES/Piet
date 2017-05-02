/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Duplicate extends Function {
    public Duplicate(){ name = new String("duplicate");}
    public Agent work(Agent agent){
        int a;
        a = Integer.parseInt(agent.stack.pop().toString());
        agent.stack.push(a);
        agent.stack.push(a);
        return agent;
    }
}