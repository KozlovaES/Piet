import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 03.05.2017.
 */
public class Def extends Function {
    public Def(){name = new String("def");}
    @Override
    public Agent work(Agent agent){
        Transition t = new Transition();
        agent.move_one_block();
        Color name = agent.get_cur_color();
        Vector<Color> args = new Vector<>();
        agent.move_one_block();
        while (agent.get_cur_color().getRGB()!= name.getRGB()) {
            if (t.isBaseColor(agent.get_cur_color())) {
                if (!agent.get_cur_color().equals(Color.WHITE))
                    args.add(Color.WHITE);
            }
            else
                args.add(agent.get_cur_color());
            agent.move_one_block();
        }
        for (int i=0; i<agent.getFunctiontable().size(); ++i) {
            if (agent.getFunctiontable().elementAt(i).args.equals(args) &&
                    agent.getFunctiontable().elementAt(i).getName().equals(name))
                return agent;
        }
        agent.move_one_block();
        agent.getFunctiontable().add(new Cust_function(name, args, agent.getX_cur(), agent.getY_cur(), agent.getDp(), agent.getCc()));
        while (agent.get_cur_color().getRGB()!=name.getRGB()) {
            agent.move_one_block();
        }
        return agent;
    }
}
