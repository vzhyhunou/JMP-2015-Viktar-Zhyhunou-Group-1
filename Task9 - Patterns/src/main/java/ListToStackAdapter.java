import java.util.LinkedList;
import java.util.List;

/**
 * Created by Natallia_Rakitskaya.
 */
public class ListToStackAdapter<T> implements Stack<T>{
    private List<T> instance;

    public ListToStackAdapter(final List<T> instance) {
        this.instance = instance;
    }

    @Override
    public void push(T t) {
        instance.add(0, t);
    }

    @Override
    public T pop() {
        T t = instance.get(0);
        instance = instance.subList(1, instance.size());
        return t;
    }
}
