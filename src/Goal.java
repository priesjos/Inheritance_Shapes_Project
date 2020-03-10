import java.awt.*;

public class Goal extends Sprite{

    public Goal(Color color, int x, int y, double speed, double direction, int width, int height, Screen screen){
        super(color, x, y, speed, direction, width, height, screen);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void moveFour(int i, int i1) {

    }

}
