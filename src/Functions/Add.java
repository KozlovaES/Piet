/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Add extends Function{
    public Add(){
        name = new String("add");
    }
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        agent.stack.push(a+b);
        return agent;
    }
}
