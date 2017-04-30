/**
 * Created by Ekaterina on 30.04.2017.
 */
public class Divide {
    public class Divide extends Function{
        public Divide(){ name = new String("divide");}
        public Agent work(Agent agent){
            int a, b;
            a = agent.stack.pop();
            b = agent.stack.pop();
            agent.stack.push(a/b);
            return agent;
        }
    }