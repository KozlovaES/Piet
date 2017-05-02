import java.util.Scanner;

/**
 * Created by Ekaterina on 02.05.2017.
 */
public class InNum extends Function{
    public InNum(){name = new String("in(number)");}
    public Agent work(Agent agent){
        Scanner s = new Scanner(System.in);
        // Должно юыть считывание ввода пользователя. Сейчас с консоли.
        agent.stack.push(s.nextInt());
        return agent;
    }
}
