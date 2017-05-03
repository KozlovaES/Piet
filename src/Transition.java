import java.awt.*;
import java.util.HashMap;

/**
 * Created by Ekaterina on 02.05.2017.
 */
public class Transition {
    HashMap<Color, Pair<Integer, Integer>> dict;
    Function[] functions = {new NoAction(), new Push(), new Pop(),
                            new Add(), new Substract(), new Multiply(),
                            new Divide(), new Mod(), new Not(),
                            new Greater(), new Pointer(), new Switch(),
                            new Duplicate(), new Roll(), new InNum(),
                            new InChar(), new OutNum(), new OutChar(),
                            new Def(), new Class()};
    public Transition() {
        dict = new HashMap<Color, Pair<Integer, Integer>>();
        dict.put(new Color(255, 192, 192), new Pair(0, 0));
        dict.put(new Color(255, 0, 0), new Pair(0, 1));
        dict.put(new Color(192, 0, 0), new Pair(0, 2));
        dict.put(new Color(255, 255, 192), new Pair(1, 0));
        dict.put(new Color(255, 255, 0), new Pair(1, 1));
        dict.put(new Color(192, 192, 0), new Pair(1, 2));
        dict.put(new Color(192, 255, 192), new Pair(2, 0));
        dict.put(new Color(0, 255, 0), new Pair(2, 1));
        dict.put(new Color(0, 192, 0), new Pair(2, 2));
        dict.put(new Color(192, 255, 255), new Pair(3, 0));
        dict.put(new Color(0, 255, 255), new Pair(3, 1));
        dict.put(new Color(0, 192, 192), new Pair(3, 2));
        dict.put(new Color(192, 255, 255), new Pair(4, 0));
        dict.put(new Color(0, 0, 255), new Pair(4, 1));
        dict.put(new Color(0, 0, 192), new Pair(4, 2));
        dict.put(new Color(255, 192, 255), new Pair(5, 0));
        dict.put(new Color(255, 00, 255), new Pair(5, 1));
        dict.put(new Color(192, 0, 192), new Pair(5, 2));
        dict.put(new Color(255, 192, 0), new Pair(6, 0));
        dict.put(new Color(255, 153, 0), new Pair(6, 1));
        dict.put(new Color(153, 112, 0), new Pair(6, 2));
        dict.put(new Color(255,255,255), new Pair(0,0));
        dict.put(new Color(0,0,0), new Pair(0,0));

    }
    public Function get_func(Color c1, Color c2){
        if (dict.containsKey(c1) && dict.containsKey(c2) && c1!=Color.black &&
                c2!=Color.black && c1!=Color.white && c2!=Color.white) {
            Pair d1, d2;
            d1 = dict.get(c1);
            d2 = dict.get(c2);
            int a1, a2, b1, b2;
            a1 = Integer.parseInt(d1.getElement0().toString());
            a2 = Integer.parseInt(d2.getElement0().toString());
            b1 = Integer.parseInt(d1.getElement1().toString());
            b2 = Integer.parseInt(d2.getElement1().toString());
            return functions[(7 + a2 - a1) % 7 * 3
                    + (3 + b2 - b1) % 3];
        }
        else
            return functions[0];
    }
    public boolean isBaseColor(Color c){
        if (dict.containsKey(c))
            return true;
        else
            return false;
    }

}
