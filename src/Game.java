import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame implements KeyListener {

    Screen screen;
    boolean upPressed, leftPressed, rightPressed, downPressed, mouseClicked = false;

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

        //mouse listeners and etc. here
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClicked = true;
            }
        });
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

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked){
        this.mouseClicked = mouseClicked;
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
