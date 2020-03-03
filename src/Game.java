import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Screen screen;
    boolean upPressed, leftPressed, rightPressed, downPressed;

    public Game() {
        setTitle("DON'T DIE");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        screen = new Screen(this);
        add(screen);
        addKeyListener(this);
        pack();
        screen.init();
        setLocationRelativeTo(null);

        /*
        mouse listeners and etc. here
         */
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }

    public static void main(String[] args){
        new Game();
    }
}
