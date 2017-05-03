/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Multiply extends Function {
    public Multiply(){ name = new String("multiply");}
    @Override
    public Agent work(Agent agent){
        int a, b;
        a = Integer.parseInt(agent.stack.pop().toString());
        b = Integer.parseInt(agent.stack.pop().toString());
        agent.stack.push(a*b);
        return agent;
    }
}
