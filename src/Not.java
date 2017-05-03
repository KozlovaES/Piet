/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Not extends Function {
    public Not(){ name = new String("not");}
    @Override
    public Agent work(Agent agent){
        int a;
        a = Integer.parseInt(agent.stack.pop().toString());
        if (a==0) {
            agent.stack.push(1);
        } else
            agent.stack.push(0);
        return agent;
    }
}
