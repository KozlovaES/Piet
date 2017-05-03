/**
 * Created by Ekaterina on 02.05.2017.
 * Вспомогательный класс для выбора кастомной функции по перепаду цветов.
 */
public class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getElement0() {
        return element0;
    }

    public V getElement1() {
        return element1;
    }

    public int hashCode(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.element0);
        buffer.append(this.element1);
        return buffer.toString().hashCode();
    }

    public boolean equals(Object object){
        if (object == null) return false;
        if (object == this) return true;
        if(this.hashCode()== object.hashCode()) return true;
        return false;
    }

}