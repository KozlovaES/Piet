import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.awt.Color;

/**
 * Created by Ekaterina on 07.04.2017.
 */
public class Agent {
    public Stack stack;
    public HashSet<Symbol> symboltable;
    private BufferedImage bi;
    private Color prev_col;
    private int x_cur, y_cur, x_prev, y_prev, dp, cc;
    public Agent(BufferedImage bi){
        this.bi = bi;
        stack = new Stack();
        symboltable = new HashSet<Symbol>();
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }

//    Field field;
    public void move_one_block(){
        prev_col = get_cur_color();
        if (dp==0 && x_cur<(bi.getWidth()-1) && new Color(bi.getRGB(x_cur+1,y_cur))!= Color.black)
            ++x_cur;
        if (dp==1 && y_cur<(bi.getHeight()-1) && new Color(bi.getRGB(x_cur,y_cur+1))!= Color.black)
            ++y_cur;
        if (dp==2 && x_cur>0 && new Color(bi.getRGB(x_cur-1,y_cur))!= Color.black)
            --x_cur;
        if (dp==3 && y_cur>0 && new Color(bi.getRGB(x_cur,y_cur-1))!= Color.black)
            --y_cur;
    };
    public void change_dp(int dir){
        switch (dir){
            case 1:
                dp = (dp+1)%4;
            case 0:
                dp = (dp-1)%4;
        }
    }
    public void change_cc(){cc = (cc+1)%2;}
    public void move(){

    };
    public Symbol get_function(){
        return new Symbol(Color.red, "name");
    };

    public Color get_cur_color(){
        return new Color(bi.getRGB(x_cur,y_cur));
    };

    public Color get_prev_color(){
        return prev_col;
    };
    public int count_prev_value(){
        HashSet<Pair> blocks = new HashSet<Pair>();
        blocks.add(new Pair(x_cur, y_cur));
        boolean flag = true;
        int x,y;
        Color col = new Color(bi.getRGB(x_cur,y_cur));
        Color test;
        Pair[] temp;
        while (flag) {
            flag = false;
            for (int i=0; i<blocks.size();i++){
                temp = new Pair[blocks.size()];
                temp = blocks.toArray(new Pair[blocks.size()]);
                x = Integer.parseInt(temp[i].getElement0().toString());
                y = Integer.parseInt(temp[i].getElement1().toString());
                if (x_cur<(bi.getWidth()-1) && new Color(bi.getRGB(x_cur+1,y_cur))!= Color.black) {
                    test = new Color(bi.getRGB(++x_cur, y_cur));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x_cur+1, y_cur))) {
                            blocks.add(new Pair(x_cur+1, y_cur));
//                            System.out.println((x_cur+1)+"  "+y_cur);
                            flag = true;
                        }
                }
                if (x_cur>0 && new Color(bi.getRGB(x_cur-1,y_cur))!= Color.black){
                    test = new Color(bi.getRGB(x_cur-1,y_cur));
                    if (test.getRGB()==col.getRGB())
                        if (!blocks.contains(new Pair(x_cur-1,y_cur)))
                            if (!blocks.contains(new Pair(x_cur-1,y_cur))) {
                            blocks.add(new Pair(x_cur-1,y_cur));
//                                System.out.println((x_cur-1)+"  "+y_cur);
                            flag = true;
                        }
                }
                if (y_cur<(bi.getHeight()-1) && new Color(bi.getRGB(x_cur,y_cur+1))!= Color.black) {
                    test = new Color(bi.getRGB(x_cur, y_cur+1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x_cur, y_cur+1))) {
                            blocks.add(new Pair(x_cur, y_cur+1));
//                            System.out.println(x_cur+"  "+(y_cur+1));
                            flag = true;
                        }
                }
                if (y_cur>0 && new Color(bi.getRGB(x_cur,y_cur-1))!= Color.black) {
                    test = new Color(bi.getRGB(x_cur, y_cur-1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x_cur, y_cur-1))) {
                            blocks.add(new Pair(x_cur, y_cur-1));
//                            System.out.println(x_cur+"  "+(y_cur-1));
                            flag = true;
                        }
                }
            }
        }
        return blocks.size();
    }
}
