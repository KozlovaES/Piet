/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Substract extends Function{
    public Substract(){
        name = new String("substract");
    }
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        agent.stack.push(a-b);
        return agent;
    }
}