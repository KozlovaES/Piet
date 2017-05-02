package Functions;

/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Push extends Function {
    public Push(){ name = new String("push");}
    public Agent work(Agent agent){
        agent.stack.push(agent.count_prev_value());
        return agent;
    }
}
