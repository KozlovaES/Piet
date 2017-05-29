/**
 * Created by Ekaterina on 02.05.2017.
 */
public class OutChar extends Function{
    public OutChar(){name = new String("out(char)");}
    @Override
    public Agent work(Agent agent){
        System.out.println((char)(int)Integer.parseInt(agent.stack.pop().toString()));
        return agent;
    }
}
