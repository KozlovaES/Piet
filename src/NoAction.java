/**
 * Created by Ekaterina on 02.05.2017.
 */
public class NoAction extends Function{
    public NoAction(){name = new String("No Action");}
    public Agent work(Agent agent){
        return agent;
    }
}
