import java.awt.*;

public class Player extends Sprite {

    double dx, dy;

    public Player(Color color, int x, int y, double speed, double direction, int width, int height, Screen screen){
        super(color, x, y, speed, direction, width, height, screen);
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void moveFour(int xDir, int yDir) {
        x += speed * xDir;
        y += speed * yDir;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
