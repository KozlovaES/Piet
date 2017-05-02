import java.util.Scanner;

/**
 * Created by Ekaterina on 02.05.2017.
 */
public class InNumb extends Function{
    public InNumb(){name = new String("in numb");}
    public Agent work(Agent agent){
        Scanner s = new Scanner(System.in);
        // Должно юыть считывание ввода пользователя. Сейчас с консоли.
        agent.stack.push(s.nextInt());
        return agent;
    }
}
