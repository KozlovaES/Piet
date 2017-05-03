import java.util.Scanner;

/**
 * Created by Ekaterina on 02.05.2017.
 */
public class InChar extends Function {
    public InChar(){name = new String("in(char)");}
    @Override
    public Agent work(Agent agent){
        Scanner s = new Scanner(System.in);
        // Должно юыть считывание ввода пользователя. Сейчас с консоли.
        agent.stack.push(s.next().substring(0,1));
        return agent;
    }
}
