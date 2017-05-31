import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 03.05.2017.
 */
public class Def extends Function {
    public Def(){name = new String("def");}
    @Override
    public Agent work(Agent agent){
        System.out.println("Method of class: "+agent.getCur_class());
        Transition t = new Transition();
        if (!agent.move())
            return agent;
        Color name = agent.get_cur_color();
        Vector<Color> args = new Vector<>();
        if (!agent.move())
            return agent;
        while (agent.get_cur_color().getRGB()!= name.getRGB()) {
            if (t.isBaseColor(agent.get_cur_color())) {
                if (!agent.get_cur_color().equals(Color.WHITE))
                    args.add(Color.WHITE);
            }
            else
                args.add(agent.get_cur_color());
            if (!agent.move())
                return agent;
        }
        for (int i=0; i<agent.getFunctiontable().size(); ++i) {
            if (agent.getFunctiontable().elementAt(i).args.equals(args) &&
                    agent.getFunctiontable().elementAt(i).getName().equals(name))
                return agent;
        }
        if (!agent.move())
            return agent;
        if (agent.getCur_class() == null)
            agent.getFunctiontable().add(new Cust_function(name, args, agent.getX_cur(), agent.getY_cur(),
                    agent.getDp(), agent.getCc()));
        else
            agent.getFunctiontable().add(new Cust_function(name, agent.getCur_class(), args, agent.getX_cur(),
                    agent.getY_cur(), agent.getDp(), agent.getCc()));
        while (!agent.get_cur_color().equals(name)) {
            if (!agent.move())
                return agent;
        }
        return agent;
    }
}
