import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Natallia_Rakitskaya.
 */
public class MainWindow extends JFrame implements ActionListener{
    JButton Quit;

    public MainWindow() {
        super("Decorator example");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel jp = new JPanel();

        getContentPane().add(jp);
        jp.add( new HighlightDecorator(new JButton("Decorated Button")));
        jp.add( new JButton("Simple Button"));
        jp.add(Quit = new JButton("Quit"));
        Quit.addActionListener(this);
        setSize(new Dimension(300, 100));

        setVisible(true);
        Quit.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    static public void main(String argv[]) {
        new MainWindow();
    }
}
