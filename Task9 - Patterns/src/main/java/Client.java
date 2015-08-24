import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Natallia_Rakitskaya.
 */
public class Client {
    public static void main(String[] args) {
        ListToStackAdapter<Integer> arrlist = new ListToStackAdapter<>(new ArrayList<Integer>());
        arrlist.push(15);
        arrlist.push(22);
        System.out.println(arrlist.pop());
        arrlist.push(30);
        arrlist.push(40);
        System.out.println(arrlist.pop());

        ListToStackAdapter<Integer> arrlist1 = new ListToStackAdapter<>(new Vector<Integer>());
        arrlist1.push(15);
        arrlist1.push(22);
        System.out.println(arrlist1.pop());
        arrlist1.push(30);
        arrlist1.push(40);
        System.out.println(arrlist1.pop());

    }
}
