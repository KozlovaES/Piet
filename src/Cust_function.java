import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 10.05.2017.
 */
public class Cust_function extends Symbol {
    private Color baseclass = null;
    protected Vector<Color> args = null;
    protected Vector<Function> func;
    public Cust_function(Color name){
        this.name = name;
        func = null;
    }
    public Cust_function(Color name, Vector<Function> func){
        this.name = name;
        args = null;
        this.func = func;
    }
    public Cust_function(Color name, Vector<Color> arguments, Vector<Function> func){
        this.name = name;
        args = arguments;
        this.func = func;
    }
    public Cust_function(Color name, String type, Color baseclass, Vector<Function> func){
        this.name = name;
        args = null;
        this.baseclass = baseclass;
        this.func = func;
    }

    public Cust_function(Color name, Color baseclass, Vector<Color> arguments, Vector<Function> func){
        this.name = name;
        this.baseclass = baseclass;
        args = arguments;
        this.func = func;
    }

    public Vector<Color> getArgs(){return args;}
    public Agent work(Agent agent){
        for (int i=0; i<func.size(); ++i){
            agent = func.get(i).work(agent);
        }
        return agent;
    }
    @Override
    public int hashCode(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.name);
        for (int i=0; i<this.args.size(); i++)
            buffer.append(this.args.get(i));
        return buffer.toString().hashCode();
    }
    public boolean equals(Cust_function compare){
        if (compare.name==name) {
            if (args != null && args.size() == compare.args.size()) {
                for (int i = 0; i < args.size(); i++)
                    if (args.get(i) != compare.args.get(i))
                        return false;
                return true;
            }
            return true;
        }
        else
            return false;
    }
}
