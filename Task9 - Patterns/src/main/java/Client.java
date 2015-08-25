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

        ListToStackAdapter<String> arrlist1 = new ListToStackAdapter<>(new Vector<String>());
        arrlist1.push("abc");
        arrlist1.push("def");
        System.out.println(arrlist1.pop());
        arrlist1.push("xyz");
        arrlist1.push("www");
        System.out.println(arrlist1.pop());

    }
}
