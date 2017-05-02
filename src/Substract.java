/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Substract extends Function {
    public Substract(){
        name = new String("substract");
    }
    public Agent work(Agent agent){
        int a, b;
        a = Integer.parseInt(agent.stack.pop().toString());
        b = Integer.parseInt(agent.stack.pop().toString());
        agent.stack.push(a-b);
        return agent;
    }
}