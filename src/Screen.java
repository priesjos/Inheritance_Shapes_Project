import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Timer timer;
    ArrayList<Sprite> actors;
    int spawnPadding = 25;

    public Screen(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }

    public void init(){
        actors = new ArrayList<>();

        actors.add(new Player(Color.YELLOW, spawnPadding, spawnPadding, 3, 0, 15, 15, this));

        WALL_LAYOUTS.box(actors, this);
        WALL_LAYOUTS.branches(actors, this);

        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2+150, 10, 40, 210, 0, -100,100, 0, actors, this, 1);
        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2-50, 10, 40, 210, 0, -100,100, 0, actors, this, 1);

        WALL_LAYOUTS.shiftingSeries(10, (getWidth()/2)-300, getHeight()/2-200, 10,40, 210, -100, 0,100, 0, actors, this, 2);

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Sprite actor: actors) { actor.paint(g); }
    }

    public void checkCollisions(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //player input
        if (game.isUpPressed()) { actors.get(0).moveFour(0, -1); }
        if (game.isDownPressed()) { actors.get(0).moveFour(0, 1); }
        if (game.isLeftPressed()) { actors.get(0).moveFour(-1, 0); }
        if (game.isRightPressed()) { actors.get(0).moveFour(1, 0); }

        for (Sprite actor: actors){
            if (actor instanceof Wall && ((Wall) actor).isMobile()){
                if ( ((Wall)actor).getGroupNum() == 1) {
                    actor.x += actor.speed;
                    if (actor.x >= getWidth() - actor.getWidth() / 2 || actor.x <= 0) {
                        actor.speed *= -1;
                    }
                }
                if ( ((Wall)actor).getGroupNum() == 2) {
                    actor.y += actor.speed;
                    if (actor.y >= getHeight() - actor.getHeight()/3 || actor.y <= 0) {
                        actor.speed *= -1;
                    }
                }
            }
        }
        repaint();
    }
}
