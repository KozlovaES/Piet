import javafx.scene.paint.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
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
            Agent agent = new Agent(ImageIO.read(new File("./Test_3.gif")));
            int res = agent.perform_function(Color.BLACK);
            if (res==0)
                System.out.println("Fin 0");
            System.out.println(agent.getFunctiontable().elementAt(0).getName()+
                    "  "+agent.getFunctiontable().elementAt(0).getX()+
                    "  "+agent.getFunctiontable().elementAt(0).getY()+
                    "  "+agent.getFunctiontable().elementAt(0).getDp()+
                    "  "+agent.getFunctiontable().elementAt(0).getCc());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}