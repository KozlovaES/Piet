import java.awt.*;
import java.util.Vector;

/**
 * Created by Ekaterina on 30.04.2017.
 * @version 1.0.0
 * Класс записи в таблице символов.
 * Хранит информацию о типе (def, class, const) и для функций их принадлежность классу и аргументы.
 */
public class Symbol {
    private String type;
    private Vector<Color> args;
    private Color name, baseclass;
    private Vector<Function> func;
    public Symbol(Color name, String type, Color baseclass){
        this.type = type;
        this.name = name;
        args = null;
        this.baseclass = baseclass;
        func = null;
    }
    public Symbol(Color name, String type, Color baseclass, Vector<Function> func){
        this.type = type;
        this.name = name;
        args = null;
        this.baseclass = baseclass;
        this.func = func;
    }
    public Symbol(Color name, String type, Vector<Color> arguments, Color baseclass, Vector<Function> func){
        this.type = type;
        this.name = name;
        args = arguments;
        this.baseclass = baseclass;
        this.func = func;
    }
    @Override
    public int hashCode(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.name);
        for (int i=0; i<this.args.size(); i++)
            buffer.append(this.args.get(i));
        return buffer.toString().hashCode();
    }
    public boolean equals(Symbol compare){
        if (compare.name==name) {
            if (args != null && args.size() == compare.args.size()) {
                for (int i = 0; i < args.size(); i++)
                    if (args.get(i) != compare.args.get(i))
                        return false;
                return true;
            }
            return true;
        }
        else
            return false;
    }
}
