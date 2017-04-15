import java.util.Stack;

/**
 * Created by Ekaterina on 07.04.2017.
 */
public class Agent {
    Stack stack;
    int x_cur, y_cur, x_prev, y_prev, dp, cc;
    public Agent(){
        stack = new Stack();
        x_cur = 0;
        y_cur = 0;
        x_prev = 0;
        y_prev = 0;
        dp = 1;
        cc = 3;
    }
    public

//    Field field;
    void move_one_block(){
        switch (dp){
            case 0:
                y_cur++;
                break;
            case 1:
                x_cur++;
                break;
            case 2:
                y_cur--;
                break;
            case 3:
                x_cur--;
                break;
        }
    };
    void move();
    void get_function();
    void get_cur_color();
    void get_prev_color();
    void count_prev_value();
}
