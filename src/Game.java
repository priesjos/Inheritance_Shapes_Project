import javax.swing.*;

public class Game extends JFrame {

    Screen screen;

    public Game() {
        setTitle("DON'T DIE");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        /*
        action listeners and etc. here
         */

        screen = new Screen(this);
        add(screen);
        pack();
        screen.init();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        new Game();
    }

}
