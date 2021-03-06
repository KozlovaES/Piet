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
            System.out.println("\nRunning "+args[0].substring(1)+'\n');
            Agent agent = new Agent(ImageIO.read(new File(args[0].substring(1)))); //"./Test_4.gif"
            int res = agent.perform_function();
            if (res==0)
                System.out.println("Fin 0");
            System.out.println("\tFunctions:");
            for (int i = 0; i<agent.getFunctiontable().size(); ++i)
                System.out.println(agent.getFunctiontable().elementAt(i).getName()+
                        "  "+agent.getFunctiontable().elementAt(i).getX()+
                        "  "+agent.getFunctiontable().elementAt(i).getY()+
                        "  "+agent.getFunctiontable().elementAt(i).getDp()+
                        "  "+agent.getFunctiontable().elementAt(i).getCc()+
                        "  "+agent.getFunctiontable().elementAt(i).getArgs()+
                        "  "+agent.getFunctiontable().elementAt(i).getBaseclass());
            System.out.println("\tClasses:");
            for (int i=0; i<agent.getClasstable().size(); ++i)
                System.out.println(agent.getClasstable().elementAt(i).getName()+
                        "  "+agent.getClasstable().elementAt(i).getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}