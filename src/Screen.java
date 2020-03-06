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
    STATS.GAMESTATES state = STATS.GAMESTATES.MENU;

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


        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2, 8, 40, 100, 0, -100,100, 0, actors, this, 1);
        WALL_LAYOUTS.shiftingSeries(8, (getWidth()/2)-300, getHeight()/2+120, 8, 40, 100, 0, -100,100, 0, actors, this, 1);

        WALL_LAYOUTS.shiftingSeries(10, (getWidth()/2)-300, getHeight()/2-200, 8,40, 210, -100, 0,100, 0, actors, this, 2);

        timer = new Timer(1000/60, this);
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        switch (state){
            case MENU:
                g.setColor(Color.WHITE);
                g.setFont(new Font("Calibri", Font.PLAIN, 40));
                printString("DON'T DIE", getWidth(), 0, 200, g);
                g.setFont(new Font("Calibri", Font.PLAIN, 28));
                printString("Arrow keys to move", getWidth(), 0,300, g);
                printString("Left mouse click to begin", getWidth(), 0,400, g);
                break;
            case PLAY:
                for (Sprite actor: actors) { actor.paint(g); }
                break;
            case PAUSE:
                g.setColor(Color.WHITE);
                g.setFont(new Font("Calibri", Font.PLAIN, 40));
                printString("PAUSED", getWidth(), 0, 200, g);
                g.setFont(new Font("Calibri", Font.PLAIN, 28));
                printString("Click to continue", getWidth(), 0,300, g);
                break;
            case DEAD:
                g.setColor(Color.RED);
                g.setFont(new Font("Calibri", Font.PLAIN, 40));
                printString("YOU DIED", getWidth(), 0, 200, g);
                break;
            default:
                System.out.println("ain't doing anything");
        }
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
                    state = STATS.GAMESTATES.DEAD;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //switch state based on mouse click
        if (game.isMouseClicked()){
            game.setMouseClicked(false);
            switch (state){
                case MENU:
                    state = STATS.GAMESTATES.PLAY;
                    break;
                case PLAY:
                    state = STATS.GAMESTATES.PAUSE;
                    break;
                case PAUSE:
                    state = STATS.GAMESTATES.PLAY;
                    break;
                default:
                    System.out.println("ain't doing anything");
                    break;
            }
        }
        //overall loop
        switch (state){
            case MENU:
                break;
            case PLAY:
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
                break;
            case PAUSE:
                break;
            default:
                System.out.println("ain't doing anything");

        }

        repaint();
    }
}
