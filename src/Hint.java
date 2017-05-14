import java.awt.*;
import java.util.HashMap;

/**
 * Created by Ekaterina on 14.05.2017.
 */
public class Hint {
    HashMap<Color, Pair<Integer, Integer>> dict;
    String[] func = {"-", "push", "pop",
            "add", "substract", "multiply",
            "divide", "mod", "not",
            "greater", "pointer", "switch",
            "duplicate", "roll", "in(number)",
            "in(char", "put(num)", "out(char)",
            "def", "class", "is_class"};
    public Hint(){
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
        dict.put(new Color(192, 192, 255), new Pair(4, 0));
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
    public HashMap<String, Color> help(Color color){
        HashMap<String, Color> ans = new HashMap<String, Color>();
        Pair d1, d2;
        int a1, a2, b1, b2;
        d1 = dict.get(color);
        a1 = Integer.parseInt(d1.getElement0().toString());
        b1 = Integer.parseInt(d1.getElement1().toString());
        for (Color c : dict.keySet()) {
            if (!c.equals(Color.black)&&!c.equals(Color.white)) {
                d2 = dict.get(c);
                a2 = Integer.parseInt(d2.getElement0().toString());
                b2 = Integer.parseInt(d2.getElement1().toString());
                ans.put(func[(7 + a2 - a1) % 7 * 3
                        + (3 + b2 - b1) % 3], c);
            }
        }
        return ans;
    }
}
