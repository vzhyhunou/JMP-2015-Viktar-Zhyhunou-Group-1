import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Natallia_Rakitskaya.
 */

public class HighlightDecorator extends Decorator {
    boolean mouse_over;
    JComponent thisComp;

    public HighlightDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;
        c.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mouse_over = true;
                thisComp.repaint();
            }

            public void mouseExited(MouseEvent e) {
                mouse_over = false;
                thisComp.repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (mouse_over) {
            Dimension size = super.getSize();
            g.setColor(Color.RED);
            g.drawRect(0, 0, size.width - 1, size.height - 1);
            g.drawLine(size.width-2, 0, size.width - 2, size.height - 1);
            g.drawLine(0, size.height-2, size.width - 2, size.height - 2);
        }
    }
}
