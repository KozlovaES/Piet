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
        prev_col = Color.black;
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }

//    Field field;
    public void move_one_block(){
        int x,y, x_new=x_cur, y_new=y_cur;
        boolean flag = true;
        Color col = new Color(bi.getRGB(x_new,y_new)), test;
        Pair[] temp;
        HashSet<Pair> blocks = new HashSet<Pair>();

        prev_col = get_cur_color();
        x_prev = x_cur;
        y_prev = y_cur;
        blocks.add(new Pair(x_prev, y_prev));
        while (flag) {
            flag = false;
            for (int i=0; i<blocks.size();i++){
                temp = new Pair[blocks.size()];
                temp = blocks.toArray(new Pair[blocks.size()]);
                x = Integer.parseInt(temp[i].getElement0().toString());
                y = Integer.parseInt(temp[i].getElement1().toString());
                if (x<(bi.getWidth()-1) && new Color(bi.getRGB(x+1,y_cur))!= Color.black) {
                    test = new Color(bi.getRGB(x+1, y));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x+1, y))) {
                            blocks.add(new Pair(x+1, y));
//                            System.out.println((x+1)+"  "+y);
                            flag = true;
                        }
                }
                if (x>0 && new Color(bi.getRGB(x-1,y_cur))!= Color.black){
                    test = new Color(bi.getRGB(x-1,y));
                    if (test.getRGB()==col.getRGB())
                        if (!blocks.contains(new Pair(x-1,y)))
                            if (!blocks.contains(new Pair(x-1,y))) {
                                blocks.add(new Pair(x-1,y));
//                            System.out.println((x-1)+"  "+y);
                                flag = true;
                            }
                }
                if (y_cur<(bi.getHeight()-1) && new Color(bi.getRGB(x,y+1))!= Color.black) {
                    test = new Color(bi.getRGB(x, y+1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y+1))) {
                            blocks.add(new Pair(x, y+1));
//                            System.out.println(x+"  "+(y+1));
                            flag = true;
                        }
                }
                if (y>0 && new Color(bi.getRGB(x,y-1))!= Color.black) {
                    test = new Color(bi.getRGB(x, y-1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y-1))) {
                            blocks.add(new Pair(x, y-1));
//                            System.out.println(x+"  "+(y-1));
                            flag = true;
                        }
                }
            }
        }
        temp = new Pair[blocks.size()];
        temp = blocks.toArray(new Pair[blocks.size()]);
        for (int i=0; i<temp.length; ++i){
            x = Integer.parseInt(temp[i].getElement0().toString());
            y = Integer.parseInt(temp[i].getElement1().toString());
            if (dp==0 && x>=x_new)
                if (x>x_new) {
                    x_new = x;
                    y_new = y;
                }
                else {
                if (cc==0 && y_new>y)
                    y_new = y;
                if (cc==1 && y_new<y)
                    y_new = y;
                }
            if (dp==1 && y>=y_new)
                if (y>y_new) {
                    x_new = x;
                    y_new = y;
                }
                else {
                    if (cc==0 && x_new>x)
                        x_new = x;
                    if (cc==1 && x_new<x)
                        x_new = x;
                }
            if (dp==2 && x<=x_new)
                if (x<x_new) {
                    x_new = x;
                    y_new = y;
                }
                else {
                    if (cc==0 && y_new<y)
                        y_new = y;
                    if (cc==1 && y_new>y)
                        y_new = y;
                }
            if (dp==3 && y<=y_new)
                if (y<y_new) {
                    x_new = x;
                    y_new = y;
                }
                else {
                    if (cc==0 && x_new<x)
                        x_new = x;
                    if (cc==1 && x_new>x)
                        x_new = x;
                }
//            System.out.println(x+"-"+y+"   "+x_new+"-"+y_new);
        }
        if (dp==0)
            ++x_new;
        if (dp==1)
            ++y_new;
        if (dp==2)
            --x_new;
        if (dp==3)
            --y_new;
        if (x_new<bi.getWidth()&&y_new<bi.getHeight()&&x_new>=0&&y_new>=0&&
                bi.getRGB(x_new,y_new)!= Color.black.getRGB()) {
            x_cur = x_new;
            y_cur = y_new;
        }
        else
            this.change_dp(1);
//        System.out.println(x_new+"---"+y_new);
    };
    public void change_dp(int dir){
        if (dir>0)
            dp = (dp+dir)%4;
        else
            dp = ((dp-dir)%4+4)%4;
    }
    public void change_cc(){cc = (cc+1)%2;}
    public void move(){

    };

    public Color get_cur_color(){
//        Заплатка!
//        return new Color(bi.getRGB(x_cur,y_cur));
        Color col = new Color(bi.getRGB(x_cur,y_cur));
        if (col.getBlue()==204)
            col = new Color(col.getRed(),col .getGreen(),192);
        if (col.getGreen()==213)
            col = new Color(col.getRed(), 192, col.getBlue());
        if (col.getRed()==204)
            col = new Color(192, col.getGreen(), col.getBlue());
        return col;
    };
    public int getX_cur(){return x_cur;}
    public int getY_cur(){return y_cur;}
    public int getX_prev(){return x_prev;}
    public int getY_prev(){return y_prev;}
    public int getCc(){return cc;}
    public int getDp(){return  dp;}
    public Color get_prev_color(){
        return prev_col;
    };
    public int count_prev_value(){
        HashSet<Pair> blocks = new HashSet<Pair>();
        blocks.add(new Pair(x_prev, y_prev));
        boolean flag = true;
        int x,y;
        Color col = new Color(bi.getRGB(x_prev,y_prev));
        Color test;
        Pair[] temp;
        while (flag) {
            flag = false;
            for (int i=0; i<blocks.size();i++){
                temp = new Pair[blocks.size()];
                temp = blocks.toArray(new Pair[blocks.size()]);
                x = Integer.parseInt(temp[i].getElement0().toString());
                y = Integer.parseInt(temp[i].getElement1().toString());
                if (x<(bi.getWidth()-1) && new Color(bi.getRGB(x+1,y_cur))!= Color.black) {
                    test = new Color(bi.getRGB(x+1, y));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x+1, y))) {
                            blocks.add(new Pair(x+1, y));
//                            System.out.println((x+1)+"  "+y);
                            flag = true;
                        }
                }
                if (x>0 && new Color(bi.getRGB(x-1,y_cur))!= Color.black){
                    test = new Color(bi.getRGB(x-1,y));
                    if (test.getRGB()==col.getRGB())
                        if (!blocks.contains(new Pair(x-1,y)))
                            if (!blocks.contains(new Pair(x-1,y))) {
                            blocks.add(new Pair(x-1,y));
//                            System.out.println((x-1)+"  "+y);
                            flag = true;
                        }
                }
                if (y_cur<(bi.getHeight()-1) && new Color(bi.getRGB(x,y+1))!= Color.black) {
                    test = new Color(bi.getRGB(x, y+1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y+1))) {
                            blocks.add(new Pair(x, y+1));
//                            System.out.println(x+"  "+(y+1));
                            flag = true;
                        }
                }
                if (y>0 && new Color(bi.getRGB(x,y-1))!= Color.black) {
                    test = new Color(bi.getRGB(x, y-1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y-1))) {
                            blocks.add(new Pair(x, y-1));
//                            System.out.println(x+"  "+(y-1));
                            flag = true;
                        }
                }
            }
        }
        return blocks.size();
    }
}
