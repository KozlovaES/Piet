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
        Vector<Function> func = new Vector<>();
        agent.move_one_block();
        // Прописать хранене аргументов.
        while (agent.get_cur_color().getRGB()!=name.getRGB()) {
            args.add(agent.get_cur_color());
        }
        agent.move_one_block();
        // Прописать хранение методов.
        while (agent.get_cur_color().getRGB()!=name.getRGB()) {
            func.add(t.get_func(agent.get_prev_color(), agent.get_cur_color()));
        }
        agent.functiontable.add(new Cust_function(name, args, func));
        return agent;
    }
}
