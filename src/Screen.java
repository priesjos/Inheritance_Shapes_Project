import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Timer timer;
    ArrayList<Sprite> actors;
    int spawnPadding = 40;
    long spawnMoment;
    long collideDelay = 400;

    enum GAMESTATE{
        PLAY,
        MENU,
        PAUSE
    }

    public Screen(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }

    public void init(){
        actors = new ArrayList<>();

        actors.add(new Player(Color.YELLOW, spawnPadding, spawnPadding, 3, 0, 15, 15, this));
        spawnMoment = System.currentTimeMillis();

        WALL_LAYOUTS.box(actors, this);
        WALL_LAYOUTS.branches(actors, this);

        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2+150, 8, 40, 150, 0, -100,100, 0, actors, this, 1);
        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2-50, 8, 40, 150, 0, -100,100, 0, actors, this, 1);

        WALL_LAYOUTS.shiftingSeries(10, (getWidth()/2)-300, getHeight()/2-200, 8,40, 210, -100, 0,100, 0, actors, this, 2);

        timer = new Timer(1000/60, this);
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        switch (GAMESTATE){
            case MENU:
                break;
            case PLAY:
                break;
            case PAUSE:
                break;
        }/*
        if (STATS.isMENU()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Calibri", Font.PLAIN, 40));
            printString("DON'T DIE", getWidth(), 0, 200, g);
            g.setFont(new Font("Calibri", Font.PLAIN, 28));
            printString("Arrow keys to move", getWidth(), 0,300, g);
            printString("Left mouse click to begin", getWidth(), 0,400, g);
        }

        if (STATS.isPAUSE()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Calibri", Font.PLAIN, 40));
            printString("PAUSED", getWidth(), 0, 200, g);
            g.setFont(new Font("Calibri", Font.PLAIN, 28));
            printString("Click to continue", getWidth(), 0,300, g);
        }

        if (STATS.isPLAY())
            for (Sprite actor: actors) { actor.paint(g); }*/
    }

    private void printString(String s, int width, int xPos, int yPos, Graphics g){
        int stringLen = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = width/2 - stringLen/2;
        g.drawString(s, start + xPos, yPos);
    }

    public void checkCollisions(){
        for (int i = 1; i < actors.size(); i++){
            if (actors.get(0) instanceof Player && actors.get(0).collidesWith(actors.get(i)) && System.currentTimeMillis() - spawnMoment >= collideDelay){
                if (actors.get(i) instanceof Wall){
                    STATS.setPLAY(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (STATS.isMENU() && game.isMouseClicked()){
            game.setMouseClicked(false);
            STATS.setMENU(false);
            STATS.setPLAY(true);
        }

        if (STATS.isPLAY() && game.isMouseClicked()){
            game.setMouseClicked(false);
            STATS.setPAUSE(true);
        }

        if (STATS.isPAUSE() && game.isMouseClicked()){
            System.out.println("work dammit");
            game.setMouseClicked(false);
            STATS.setPAUSE(false);
        }

        if (STATS.isPLAY() && !STATS.isPAUSE()){
            checkCollisions();
            //player input
            if (game.isUpPressed()) { actors.get(0).moveFour(0, -1); }
            if (game.isDownPressed()) { actors.get(0).moveFour(0, 1); }
            if (game.isLeftPressed()) { actors.get(0).moveFour(-1, 0); }
            if (game.isRightPressed()) { actors.get(0).moveFour(1, 0); }

            for (Sprite actor: actors){
                if (actor instanceof Wall && ((Wall) actor).isMobile()){
                    if ( ((Wall)actor).getGroupNum() == 1) {
                        actor.x += actor.speed;
                        if (actor.x >= getWidth() - actor.getWidth()/2 || actor.x <= 0) {
                            actor.speed *= -1;
                        }
                    }
                    if ( ((Wall)actor).getGroupNum() == 2) {
                        actor.y += actor.speed;
                        if (actor.y >= getHeight() - actor.getHeight() || actor.y <= 0) {
                            actor.speed *= -1;
                        }
                    }
                }
            }
        }

        repaint();
    }
}
