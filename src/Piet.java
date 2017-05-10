import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
//import java.util.Scanner;


/**
 * Created by Ekaterina on 07.04.2017.
 */
public class Piet {
    public static void main(String[] args) {
//        String[] com = {"-", "pop", "push", "add", "substract", "multiply",
//                "divide", "mod", "not", "greater", "pointer", "switch", "duplicate", "roll", "in(number)"};
//        int[][] mass = new int[8][3];
//        for (int i=0;i<8;i++)
//            for (int j=0;j<3;j++)
//            {
//                mass[i][j] = i*3+j;
//                System.out.println(mass[i][j]);
//            }
//        String a;
//        Scanner s = new Scanner(System.in);
//        a = s.next().substring(0,1);
//        System.out.println(a);
//        b = s.nextInt();
//        System.out.println(mass[a][b]);
//        BufferedImage image;
//        try {
//            image = ImageIO.read(new File("./Test.gif"));
//            System.out.println(new Color(image.getRGB(1,0)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Agent agent = new Agent(ImageIO.read(new File("./Test.gif")));
            Transition trans = new Transition();
            int count_fails=0;
            for (int i=0; i<3; i++){
                if (agent.getX_cur()==agent.getX_prev() && agent.getY_cur()==agent.getY_prev())
                    ++count_fails;
                else
                    count_fails=0;
                if (count_fails>=3){
                    System.out.println("Finish!");
                    break;
                }
                agent.move_one_block();
//                System.out.println("Color value = " + agent.get_prev_color());
//                System.out.println("Color value = " + agent.get_cur_color());
                System.out.println("Blocks value = " + agent.count_prev_value());
                if (trans.isBaseColor(agent.get_cur_color())&&trans.isBaseColor(agent.get_prev_color())) {
                    System.out.println("Function name = " + trans.get_func(agent.get_prev_color(), agent.get_cur_color()).getName());
                    agent = trans.get_func(agent.get_prev_color(), agent.get_cur_color()).work(agent);
//                System.out.println("x: "+agent.getX_prev()+"->"+agent.getX_cur()+"\ny: "+agent.getY_prev()+"->"+agent.getY_cur());
                    System.out.println("1st element: " + agent.stack.lastElement());
                    System.out.println();
                }
                else
                {
                    Vector<Color> arguments = new Vector<Color>();
                    //Собрать аргументы!!!
                    for (int j=0; j<agent.classtable.size(); ++j){
                        agent = agent.classtable.elementAt(j).create(agent, arguments);
                        break;
                    }
                    for (int j=0;j<agent.functiontable.size(); ++j)
                        if (agent.functiontable.elementAt(j).getName().getRGB()==agent.get_cur_color().getRGB()&&
                                arguments==agent.functiontable.elementAt(j).getArgs()){
                        agent = agent.functiontable.elementAt(j).work(agent);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}