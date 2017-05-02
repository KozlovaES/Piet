import java.awt.*;

/**
 * Created by Ekaterina on 30.04.2017.
 * @version 1.0.0
 * Класс записи в таблице символов.
 * Хранит информацию о типе (def, class, const) и для функций их принадлежность классу и аргументы.
 */
public class Symbol {
    private
    String type;
    List args;
    Color name;
    public Symbol(Color name, String type){
        this.type = type;
        this.name = name;
        args = null;
    }
    public Symbol(Color name, String type, List arguments){
        this.type = type;
        this.name = name;
        args = arguments;
    }
    public boolean equals(Symbol compare){
        if (compare.name==name) {
            if (args != null && args.getItemCount() == compare.args.getItemCount()) {
                for (int i = 0; i < args.getItemCount(); i++)
                    if (args.getItem(i) != compare.args.getItem(i))
                        return false;
                return true;
            }
            return true;
        }
        else
            return false;
    }
}
