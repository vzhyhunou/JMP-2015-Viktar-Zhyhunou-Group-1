import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Natallia_Rakitskaya
 */
public class Main {
    public static void main(String args[]) throws IOException {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 500; i++) {
            InputStream in = Main.class.getResourceAsStream("/data2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while ((line = br.readLine()) != null) {
                //list.add(line.substring(0, 3)); // <-- causes memory leak
                list.add(new String(line.substring(0, 3))); // <-- fixes leak!
            }
        }
    }
}
