import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.awt.Color;
import java.util.Vector;

/**
 * Created by Ekaterina on 07.04.2017.
 */
public class Agent {
    public Stack stack;
    private Vector<Cust_function> functiontable;
    private Vector<Cust_class> classtable;
    private BufferedImage bi;
    private Color prev_col, stop_col;
    private int x_cur, y_cur, x_prev, y_prev, dp, cc;
    public Agent (){
        bi = null;
        stop_col = Color.BLACK;
        stack = new Stack();
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }
    public Agent(BufferedImage bi){
        this.bi = bi;
        stop_col = Color.BLACK;
        stack = new Stack();
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }
    public Agent (BufferedImage bi, Vector<Cust_function> functiontable, Vector<Cust_class> classtable){
        this.bi = bi;
        stop_col = Color.BLACK;
        stack = new Stack();
        this.classtable = classtable;
        this.functiontable = functiontable;
        prev_col = Color.black;
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }
    public Agent(int x, int y, BufferedImage bi, Stack stack){
        this.bi = bi;
        stop_col = Color.BLACK;
        this.stack = stack;
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = x;
        y_cur = y;
        x_prev = x;
        y_prev = y;
        dp = 0;
        cc = 0;
    }
    public Agent(int x, int y, BufferedImage bi, Stack stack, Vector<Cust_function> functiontable, Vector<Cust_class> classtable){
        this.bi = bi;
        stop_col = Color.BLACK;
        this.stack = stack;
        this.classtable = classtable;
        this.functiontable = functiontable;
        prev_col = Color.black;
        x_cur = x;
        y_cur = y;
        x_prev = x;
        y_prev = y;
        dp = 0;
        cc = 0;
    }
    public Agent(int x, int y, int dp, int cc, BufferedImage bi, Stack stack){
        this.bi = bi;
        stop_col = Color.BLACK;
        this.stack = stack;
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = x;
        y_cur = y;
        x_prev = x;
        y_prev = y;
        this.dp = dp;
        this.cc = cc;
    }
    public Agent(int x, int y, int dp, int cc, BufferedImage bi, Stack stack, Color stop_col){
        this.bi = bi;
        this.stop_col = stop_col;
        this.stack = stack;
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = x;
        y_cur = y;
        x_prev = x;
        y_prev = y;
        this.dp = dp;
        this.cc = cc;
    }
    public Agent(int x, int y, int dp, int cc, BufferedImage bi, Stack stack, Vector<Cust_function> functiontable, Vector<Cust_class> classtable){
        this.bi = bi;
        stop_col = Color.BLACK;
        this.stack = stack;
        this.classtable = classtable;
        this.functiontable = functiontable;
        prev_col = Color.black;
        x_cur = x;
        y_cur = y;
        x_prev = x;
        y_prev = y;
        this.dp = dp;
        this.cc = cc;
    }
    public Agent (BufferedImage bi, Stack stack){
        this.bi = bi;
        stop_col = Color.BLACK;
        this.stack = stack;
        classtable = new  Vector<Cust_class>();
        functiontable = new Vector<Cust_function>();
        prev_col = Color.black;
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 0;
        cc = 0;
    }
    // Переход на следующий символ с совершением всех поворотов, при этом возврашает true.
    // Если идти можно только назад, возвращает false.
    public boolean move(){
        int count_fails=0;
        while (!this.move_one_block()){
            count_fails += 1;
            if (count_fails==2)
                this.change_dp(1);
            if (count_fails>=3){
                System.out.println("Finish!");
                return false;
            }
        }
        return true;
    }
    // Запускает режим выполнения функции агентом. Он будет идти и выполнять все команды, которые встретит,
    // до первого тупика или блока имени функции (для main - черный).
    public int perform_function(){
        boolean end = false;
        Transition trans = new Transition();
        int count_fails=-1;
        while (!end){
            if (!this.move())
                end = true;
            System.out.println("Color value = " + this.get_prev_color());
            System.out.println("Color value = " + this.get_cur_color());
            if (!this.get_prev_color().equals(Color.WHITE))
                System.out.println("Blocks value = " + this.count_prev_value());
            System.out.println(trans.isBaseColor(this.get_cur_color())+"   "+this.get_cur_color());
            if (trans.isBaseColor(this.get_cur_color())) {
                if (trans.isBaseColor(this.get_prev_color()) &&
                        !this.get_cur_color().equals(Color.BLACK) && !this.get_prev_color().equals(Color.WHITE) &&
                        !this.get_cur_color().equals(Color.WHITE)&& !this.get_cur_color().equals(stop_col)) {
                    System.out.println("Function name = " + trans.get_func(this.get_prev_color(), this.get_cur_color()).getName());
                    trans.get_func(this.get_prev_color(), this.get_cur_color()).work(this);
                    //                System.out.println("x: "+agent.getX_prev()+"->"+agent.getX_cur()+"\ny: "+agent.getY_prev()+"->"+agent.getY_cur());
                    if (!this.stack.isEmpty())
                        System.out.println("1st element: " + this.stack.lastElement());
                    System.out.println("dp = " + this.getDp());
                    System.out.println("cc = " + this.getCc());
                    System.out.println("x = " + this.getX_cur() + ", y = " + this.getY_cur());
                    System.out.println();
                }
            }
            else {
                if (this.get_cur_color().equals(stop_col)) {
                    end = true;
                    System.out.println("\t\tx = " + this.getX_cur() + ", y = " + this.getY_cur());
                    break;
                }
                else {
                    System.out.println("====start_init====\n");
                    Vector<Color> arguments = new Vector<Color>();
                    Color name = new Color(get_cur_color().getRGB());
                    if (!this.move())
                        end = true;
                    while (!this.get_cur_color().equals(name)) {
                        if (trans.isBaseColor(this.get_cur_color())) {
                            if (!this.get_cur_color().equals(Color.WHITE))
                                arguments.add(Color.WHITE);
                        }
                        else
                            arguments.add(new Color(this.get_cur_color().getRGB()));
                        System.out.println("\tx = " + this.getX_cur() + ", y = " + this.getY_cur());
                        if (!this.move())
                            end = true;
                    }
                    if (!this.move())
                        end = true;
//                    System.out.println("\tx = " + this.getX_cur() + ", y = " + this.getY_cur());
                    for (int j = 0; j < this.classtable.size(); ++j) {
                        this.classtable.elementAt(j).create(this, arguments);
                        break;
                    }
                    System.out.println(arguments);
                    for (int j = 0; j < this.functiontable.size(); ++j) {
                        if (this.functiontable.elementAt(j).getName().equals(name) &&
                                arguments.equals(this.functiontable.elementAt(j).getArgs())) {
                            // Выполнить функцию
                            Cust_function func = this.functiontable.elementAt(j);
                            Stack st = new Stack();
                            for (int k = 0; k < func.getArgs().size(); ++k) {
                                if (trans.isBaseColor(func.getArgs().get(k)) && stack.lastElement().getClass().getName().equals("java.lang.Integer"))
                                    st.push(stack.pop());
//                                         ||!trans.isBaseColor(func.getArgs().get(k)) && (Class)stack.lastElement().n)
                            }
                            if (!this.get_cur_color().equals(stop_col)) {
                                Agent temp = new Agent(func.getX(), func.getY(), func.getDp(), func.getCc(), bi, st, name);
                                System.out.println("...........\n\t\tFunction" + "   " + name + "\n...........");
                                System.out.println(st);
                                temp.perform_function();
                                stack.addAll(temp.stack);
                                System.out.println("====end====\n");
                                break;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    // Переход на следующий блок в соответствии с dp и cc, либо поворот на 1.
    public boolean move_one_block(){
        int x,y, x_new=x_cur, y_new=y_cur;
        boolean flag = true;
        Color col = new Color(bi.getRGB(x_new,y_new)), test;
        Pair[] temp;
        HashSet<Pair> blocks = new HashSet<Pair>();

        prev_col = get_cur_color();
        x_prev = x_cur;
        y_prev = y_cur;

        if (col.equals(Color.WHITE)) {
            x_new = x_cur;
            y_new = y_cur;
        }
        else {
            blocks.add(new Pair(x_prev, y_prev));
            while (flag) {
                flag = false;
                for (int i = 0; i < blocks.size(); i++) {
                    temp = new Pair[blocks.size()];
                    temp = blocks.toArray(new Pair[blocks.size()]);
                    x = Integer.parseInt(temp[i].getElement0().toString());
                    y = Integer.parseInt(temp[i].getElement1().toString());
                    Color temp_col;
                    if (x < (bi.getWidth() - 1)) {
                        temp_col = new Color(bi.getRGB(x + 1, y_cur));
                        if (!temp_col.equals(Color.BLACK) && !temp_col.equals(stop_col.getRGB())) {
                            test = new Color(bi.getRGB(x + 1, y));
                            if (test.getRGB() == col.getRGB())
                                if (!blocks.contains(new Pair(x + 1, y))) {
                                    blocks.add(new Pair(x + 1, y));
                                    flag = true;
                                }
                        }
                    }
                    if (x>0){
                        temp_col = new Color(bi.getRGB(x - 1, y_cur));
                        if (!temp_col.equals(Color.BLACK) && !temp_col.equals(stop_col.getRGB())) {
                            test = new Color(bi.getRGB(x - 1, y));
                            if (test.getRGB() == col.getRGB())
                                if (!blocks.contains(new Pair(x - 1, y)))
                                    if (!blocks.contains(new Pair(x - 1, y))) {
                                        blocks.add(new Pair(x - 1, y));
                                        flag = true;
                                    }
                        }
                    }
                    if (y_cur<(bi.getHeight() - 1)) {
                        temp_col = new Color(bi.getRGB(x, y + 1));
                        if (!temp_col.equals(Color.BLACK) && !temp_col.equals(stop_col.getRGB())) {
                            test = new Color(bi.getRGB(x, y + 1));
                            if (test.getRGB() == col.getRGB())
                                if (!blocks.contains(new Pair(x, y + 1))) {
                                    blocks.add(new Pair(x, y + 1));
                                    flag = true;
                                }
                        }
                    }
                    if (y>0) {
                        temp_col = new Color(bi.getRGB(x, y - 1));
                        if (!temp_col.equals(Color.BLACK) && !temp_col.equals(stop_col.getRGB())) {
                            test = new Color(bi.getRGB(x, y - 1));
                            if (test.getRGB() == col.getRGB())
                                if (!blocks.contains(new Pair(x, y - 1))) {
                                    blocks.add(new Pair(x, y - 1));
                                    flag = true;
                                }
                        }
                    }
                }
            }
            temp = new Pair[blocks.size()];
            temp = blocks.toArray(new Pair[blocks.size()]);
            for (int i = 0; i < temp.length; ++i) {
                x = Integer.parseInt(temp[i].getElement0().toString());
                y = Integer.parseInt(temp[i].getElement1().toString());
                if (dp == 0 && x >= x_new)
                    if (x > x_new) {
                        x_new = x;
                        y_new = y;
                    } else {
                        if (cc == 0 && y_new > y)
                            y_new = y;
                        if (cc == 1 && y_new < y)
                            y_new = y;
                    }
                if (dp == 1 && y >= y_new)
                    if (y > y_new) {
                        x_new = x;
                        y_new = y;
                    } else {
                        if (cc == 0 && x_new < x)
                            x_new = x;
                        if (cc == 1 && x_new > x)
                            x_new = x;
                    }
                if (dp == 2 && x <= x_new)
                    if (x < x_new) {
                        x_new = x;
                        y_new = y;
                    } else {
                        if (cc == 0 && y_new < y)
                            y_new = y;
                        if (cc == 1 && y_new > y)
                            y_new = y;
                    }
                if (dp == 3 && y <= y_new)
                    if (y < y_new) {
                        x_new = x;
                        y_new = y;
                    } else {
                        if (cc == 0 && x_new > x)
                            x_new = x;
                        if (cc == 1 && x_new < x)
                            x_new = x;
                    }
//            System.out.println(x+"-"+y+"   "+x_new+"-"+y_new);
            }
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
                bi.getRGB(x_new,y_new)!= Color.BLACK.getRGB()) {
            x_cur = x_new;
            y_cur = y_new;
            return true;
        }
        else {
            this.change_dp(1);
            return false;
        }
    };
    // Поворот dp на dir по правилам Piet.
    public void change_dp(int dir){
        if (dir>0)
            dp = (dp+dir)%4;
        else
            dp = ((dp-dir)%4+4)%4;
    }
    // Поворот cc в другую сторону.
    public void change_cc(){cc = (cc+1)%2;}
    // Возвращение цвета текущего символа.
    public Color get_cur_color(){
        return new Color(bi.getRGB(x_cur,y_cur));
    };
    // Возвращение цвета прошлого символа.
    public Color get_prev_color(){
        return prev_col;
    };
    public int getX_cur(){return x_cur;}
    public int getY_cur(){return y_cur;}
    public int getX_prev(){return x_prev;}
    public int getY_prev(){return y_prev;}
    public int getCc(){return cc;}
    public int getDp(){return  dp;}
    public Color getStop_col(){return stop_col;}
    public Vector<Cust_class> getClasstable(){return classtable;}
    public Vector<Cust_function> getFunctiontable(){return functiontable;}
    // Подсчет числа блоков одинаковго цвета вокруг предыдущего блока.
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
            for (int i=0; i<blocks.size();i++) {
                temp = new Pair[blocks.size()];
                temp = blocks.toArray(new Pair[blocks.size()]);
                x = Integer.parseInt(temp[i].getElement0().toString());
                y = Integer.parseInt(temp[i].getElement1().toString());
                if (x < (bi.getWidth() - 1) && bi.getRGB(x + 1, y_cur) != Color.BLACK.getRGB()) {
                    test = new Color(bi.getRGB(x + 1, y));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x + 1, y))) {
                            blocks.add(new Pair(x + 1, y));
//                            System.out.println((x+1)+"  "+y);
                            flag = true;
                        }
                }
                if (x > 0 && bi.getRGB(x - 1, y_cur) != Color.BLACK.getRGB()) {
                    test = new Color(bi.getRGB(x - 1, y));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x - 1, y)))
                            if (!blocks.contains(new Pair(x - 1, y))) {
                                blocks.add(new Pair(x - 1, y));
//                            System.out.println((x-1)+"  "+y);
                                flag = true;
                            }
                }
                if (y < (bi.getHeight() - 1) && bi.getRGB(x, y + 1) != Color.BLACK.getRGB()) {
                    test = new Color(bi.getRGB(x, y + 1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y + 1))) {
                            blocks.add(new Pair(x, y + 1));
//                            System.out.println(x+"  "+(y+1));
                            flag = true;
                        }
                }
                if (y > 0 && bi.getRGB(x, y - 1) != Color.BLACK.getRGB()) {
                    test = new Color(bi.getRGB(x, y - 1));
                    if (test.getRGB() == col.getRGB())
                        if (!blocks.contains(new Pair(x, y - 1))) {
                            blocks.add(new Pair(x, y - 1));
//                            System.out.println(x+"  "+(y-1));
                            flag = true;
                        }
                }
            }
            }
        return blocks.size();
    }
}
