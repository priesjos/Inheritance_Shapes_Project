import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Timer timer;

    public Screen(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }

    public void init(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
