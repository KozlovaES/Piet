import java.util.Scanner;

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
//                System.out.println(mass[i][j]);S
            }
        int a;
        int b;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();
        System.out.println(mass[a][b]);
    }
}