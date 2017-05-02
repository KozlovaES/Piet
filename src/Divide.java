package Functions;

/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Divide extends Function {
    public Divide() {
        name = new String("divide");
    }

    public Agent work(Agent agent) {
        int a, b;
        a = Integer.parseInt(agent.stack.pop().toString());
        b = Integer.parseInt(agent.stack.pop().toString());
        agent.stack.push(a / b);
        return agent;
    }
}