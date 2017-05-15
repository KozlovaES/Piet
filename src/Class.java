import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 03.05.2017.
 */
public class Class extends Function {
    public Class(){name = new String("class");}
    @Override
    public Agent work(Agent agent) {
        Transition t = new Transition();
        int count_fails = 0;
        Vector<Function> func = new Vector<>();
        agent.move_one_block();
        Color name = agent.get_cur_color();
        agent.getClasstable().add(new Cust_class(name));
        while (agent.get_cur_color().getRGB()!=name.getRGB()){
            if (agent.getX_cur()==agent.getX_prev() && agent.getY_cur()==agent.getY_prev())
                ++count_fails;
            else
                count_fails=0;
            if (count_fails>=3){
//                System.out.println("Finish creating class!");
                break;
            }
            agent.move_one_block();
            if (t.get_func(agent.get_prev_color(), agent.get_cur_color()).name == "def")
            {
                Color def_n = agent.get_cur_color();
                Vector<Color> args = new Vector<>();
                Vector<Function> function = new Vector<>();
                agent.move_one_block();
                while (agent.get_cur_color().getRGB()!=name.getRGB()) {
                    args.add(agent.get_cur_color());
                }
                agent.move_one_block();
                while (agent.get_cur_color().getRGB()!=name.getRGB()) {
                    function.add(t.get_func(agent.get_prev_color(), agent.get_cur_color()));
                }
                agent.getFunctiontable().add(new Cust_function(def_n, name, args,
                        agent.getX_cur(), agent.getY_cur(), agent.getDp(), agent.getCc()));
            }
            else
                func.add(t.get_func(agent.get_prev_color(), agent.get_cur_color()));
        }
        agent.getClasstable().add(new Cust_class(name));
        return agent;
    }
}
