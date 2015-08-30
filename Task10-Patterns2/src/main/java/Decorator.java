import javax.swing.*;
import java.awt.*;

/**
 * Created by Natallia_Rakitskaya.
 */
public class Decorator extends JComponent {
    public Decorator(JComponent c) {
        setLayout(new BorderLayout());
        add("Center", c);
    }
}
