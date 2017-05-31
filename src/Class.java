import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 03.05.2017.
 */
public class Class extends Function {
    public Class(){name = new String("class");}
    @Override
    public Agent work(Agent agent) {
        System.out.println("Class creation");
        Transition t = new Transition();
        Vector<Function> func = new Vector<>();
        if (!agent.move()) {
            agent.setCur_class(null);
            return agent;
        }
        Color name = agent.get_cur_color();
        agent.setCur_class(name);
        if (!agent.move()) {
            agent.setCur_class(null);
            return agent;
        }
        if (!agent.getClasstable().contains(name)) {
            if (t.isBaseColor(agent.get_cur_color()))
                agent.getClasstable().add(new Cust_class(name));
            else {
                for (int i=0; i<agent.getClasstable().size(); ++i)
                    if (agent.getClasstable().elementAt(i).getName().equals(agent.get_cur_color())){
                        agent.getClasstable().add(new Cust_class(name, agent.get_cur_color()));
                        for (int j=0; j<agent.getFunctiontable().size(); j++){
                            if (agent.getFunctiontable().elementAt(j).getBaseclass()!=null &&
                                    agent.getFunctiontable().elementAt(j).getBaseclass().equals(agent.get_cur_color())) {
                                Cust_function temp = agent.getFunctiontable().elementAt(j);
                                agent.getFunctiontable().add(new Cust_function(temp.name, name, temp.getArgs(),
                                        temp.getX(), temp.getY(), temp.getDp(), temp.getCc()));
                            }
                        }
                        if (!agent.move()) {
                            agent.setCur_class(null);
                            return agent;
                        }
                        break;
                    }
            }
        }
        while (!agent.get_cur_color().equals(name)){
            if (!agent.move()) {
                agent.setCur_class(null);
                return agent;
            }
            if (t.get_func(agent.get_prev_color(), agent.get_cur_color()).getName().equals("def")) {
                System.out.println("\nFunction name = " + t.get_func(agent.get_prev_color(), agent.get_cur_color()).getName());
                System.out.println("x = " + agent.getX_cur() + ", y = " + agent.getY_cur());
                t.get_func(agent.get_prev_color(), agent.get_cur_color()).work(agent);
            }
        }
        agent.setCur_class(null);
        System.out.println("Class fin");
        return agent;
    }
}
