import java.awt.*;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Ekaterina on 10.05.2017.
 */
public class Cust_class extends Symbol {
    private Vector<Cust_function> constructor = null;
    public Cust_class(Color name){
        this.name = name;
    };
    public Cust_class(Color name, Vector<Cust_function> constructor){
        this.name = name;
        this.constructor = constructor;
    }

    public Agent create(Agent agent, Vector<Color> args){
        if (constructor != null) {
            for (int i = 0; i < constructor.size(); ++i) {
                if (args.size() == constructor.elementAt(i).args.size()) {
                    boolean flag = true;
                    for (int j = 0; j < args.size(); ++j) {
                        if (args.elementAt(j).getRGB() != constructor.elementAt(i).args.elementAt(j).getRGB())
                            flag = false;
//                    if (flag)
                        // Прописать создание объекта класса и помещение его в стек.
                    }
                }
            }
        }
        return agent;
    };

}
