/**
 * Created by Ekaterina on 02.05.2017.
 */
public class OutNum extends Function{
    public OutNum(){name = new String("out(number)");}
    public Agent work(Agent agent){
        System.out.println(Integer.parseInt(agent.stack.pop().toString()));
        return agent;
    }
}
