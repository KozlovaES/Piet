import java.awt.image.BufferedImage;
import java.util.HashSet;
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
        dp = 1;
        cc = 3;
    }

//    Field field;
    public void move_one_block(){
        prev_col = get_cur_color();
        switch (dp){
            case 0:
                y_cur++;
            case 1:
                x_cur++;
            case 2:
                y_cur--;
            case 3:
                x_cur--;
        }
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
        return 0;
    };
}
