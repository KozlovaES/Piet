/**
 * Created by Ekaterina on 07.04.2017.
 */

// Абстрактный класс, от которого наследуются классы функций.
public class Function {
    protected String name;
    public abstract Agent work(Agent agent);
}

public class Pop extends Function{
    public Pop(){
        name = new String("pop");
    }
    public Agent work(Agent agent){
        agent.stack.stack.pop();
        return agent;
    }
}

public class Push extends Function{
    public Push(){
        name = new String("push");
    }
    public Agent work(Agent agent){
        agent.stack.push(agent.count_prev_value(););
        return agent;
    }
}

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

public class Multiply extends Function{
    public Multiply(){ name = new String("multiply");}
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        agent.stack.push(a*b);
        return agent;
    }
}

public class Divide extends Function{
    public Dvide(){ name = new String("divide")}
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        agent.stack.push(a/b);
        return agent;
    }
}

public class Mod extends Function{
    public Mod(){ name = new String("mod");}
    public Agent work(Agent agent){
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        agent.stack.push(a%b);
        return agent;
    }
}

public class Not extends Function{
    public Not{ name = new String("not");}
    public Agent work(Agent agent){
        int a;
        a = agent.stack.pop();
        if (a==0):
            agent.stack.push(1);
        else:
            agent.stack.push(0);
        return agent;
    }
}

public class Greater extends Function{
    public Greater{ name = new String("greater");}
    public Agent work(Agent agent{
        int a, b;
        a = agent.stack.pop();
        b = agent.stack.pop();
        if (a>b):
            agent.stack.push(1);
        else:
            agent.stack.push(0);
        return agent;
    }
}

/*"pointer", "switch", "duplicate", "roll", "in(number)",
in(char)	out(number),out(char),
craete_def, craate_class, create_object,
 func, is_class, get
 */