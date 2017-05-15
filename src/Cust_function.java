import java.awt.*;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Ekaterina on 10.05.2017.
 */
public class Cust_function extends Symbol {
    private Color baseclass = null;
    protected Vector<Color> args = null;
    private int dp, cc, x, y;
    
    public Cust_function(Color name){
        this.name = name;
        dp = 0;
        cc = 0;
        x = 0;
        y = 0;
        args = null;
    }
    public Cust_function(Color name, Vector<Color> arguments){
        this.name = name;
        args = arguments;
        dp = 0;
        cc = 0;
        x = 0;
        y = 0;
    }
    public Cust_function(Color name, Vector<Color> arguments, int x, int y){
        this.name = name;
        args = arguments;
        dp = 0;
        cc = 0;
        this.x = x;
        this.y = y;
    }
    public Cust_function(Color name, Color baseclass, Vector<Color> arguments){
        this.name = name;
        args = arguments;
        this.baseclass = baseclass;
        dp = 0;
        cc = 0;
        x = 0;
        y = 0;
    }
    public Cust_function(Color name, Color baseclass, Vector<Color> arguments, int x, int y){
        this.name = name;
        this.baseclass = baseclass;
        args = arguments;
        dp = 0;
        cc = 0;
        this.x = x;
        this.y = y;
    }
    public Cust_function(Color name, Color baseclass, Vector<Color> arguments, int x, int y, int dp, int cc){
        this.name = name;
        this.baseclass = baseclass;
        args = arguments;
        this.dp = dp;
        this.cc = cc;
        this.x = x;
        this.y = y;
    }

    public Vector<Color> getArgs(){return args;}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getDp(){return dp;}
    public int getCc(){return cc;}
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
