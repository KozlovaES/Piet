import java.util.Queue;
import java.util.Vector;

/**
 * Created by Ekaterina on 02.05.2017.
 */
public class Roll extends Function {
    public Roll(){name = new String("roll");}
    @Override
    public Agent work(Agent agent){
        int n,m;
        n = Integer.parseInt(agent.stack.pop().toString());
        m = Integer.parseInt(agent.stack.pop().toString());
        Object data;
        data = agent.stack.pop();
        if (m>=0)
        {
            Vector temp = new Vector(m);
            for (int i=0; i<m; i++){
                temp.add(agent.stack.pop());
            }
            for (int i=0; i<n;i++){
                agent.stack.push(data);
            }
            for (int i=0; i<m; i++){
                agent.stack.push(temp.get(m));
            }
        }
        return agent;
    }
}
