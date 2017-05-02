/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Pop extends Function {
    public Pop(){
        name = new String("pop");
    }
    public Agent work(Agent agent){
        agent.stack.pop();
        return agent;
    }
}