/**
 * Created by Ekaterina on 07.04.2017.
 * @version 1.0.0
 * Абстрактный класс, от которого наследуются классы функций.
 */
public abstract class Function {
    protected String name;
    /** @param agent объект агента, над которым будет проводиться операция в функции */
    public abstract Agent work(Agent agent);
    public String getName(){
        return name;
    }
}

/*"roll", "in(number)",
in(char)	out(number),out(char),
def, class, is_class*/