import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Scanner;


/**
 * Created by Ekaterina on 07.04.2017.
 */
public class Piet {
    public static void main(String[] args) {
        String[] com = {"-", "pop", "push", "add", "substract", "multiply",
                "divide", "mod", "not", "greater", "pointer", "switch", "duplicate", "roll", "in(number)"};
        int[][] mass = new int[8][3];
        for (int i=0;i<8;i++)
            for (int j=0;j<3;j++)
            {
                mass[i][j] = i*3+j;
//                System.out.println(mass[i][j]);
            }
//        String a;
//        Scanner s = new Scanner(System.in);
//        a = s.next().substring(0,1);
//        System.out.println(a);
//        b = s.nextInt();
//        System.out.println(mass[a][b]);
        BufferedImage image;
        try {
            Agent agent = new Agent(ImageIO.read(new File("./Test.gif")));
            Transition trans = new Transition();
            Color c1, c2;
            c1 = new Color(255,255,192);
            c2 = new Color( 255,192,0);
            System.out.println("Color value = " + agent.get_cur_color());
            agent.move_one_block();
            System.out.println("Color value = " + agent.get_cur_color());
            System.out.println("Blocks value = " + agent.count_prev_value());
            System.out.println("Function name = " + trans.get_func(c1, c2).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}