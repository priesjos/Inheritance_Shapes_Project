import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Timer timer;
    ArrayList<Sprite> actors;

    public Screen(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }

    public void init(){
        actors = new ArrayList<>();

        actors.add(new Player(Color.YELLOW, getWidth()/2, getHeight()/2, 4, 0, 20, 20, this));

        actors.add(new Wall(Color.RED, getWidth()/2, getHeight()/2, 0.4, 0, 80, 10, this));

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Sprite actor: actors) { actor.paint(g); }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //player input
        if (game.isUpPressed()){ actors.get(0).moveFour(0, -1); }
        if (game.isDownPressed()) { actors.get(0).moveFour(0, 1); }
        if (game.isLeftPressed()) { actors.get(0).moveFour(-1, 0); }
        if (game.isRightPressed()) { actors.get(0).moveFour(1, 0); }

        for (Sprite actor: actors){
            if (actor instanceof Wall){
                actor.rotate();
            }
        }
        repaint();
    }
}
