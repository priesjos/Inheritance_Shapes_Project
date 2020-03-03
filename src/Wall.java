import java.awt.*;

public class Wall extends Sprite {

    boolean mobile = false;

    public Wall(Color color, int x, int y, double speed, double direction, int width, int height, Screen screen){
        super(color, x, y, speed, direction, width, height, screen);
    }

    @Override
    public void paint(Graphics g){
        int wallX = getX();
        int wallY = getY();

        wallX += (24 * (float)Math.cos(Math.toRadians(direction -90)));
        wallY += (24 * (float)Math.sin(Math.toRadians(direction -90)));

        g.setColor(getColor());
        g.fillRect(wallX, wallY, getWidth()/2, getHeight()/2);
    }

    @Override
    public void moveFour(int i, int i1){

    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }
}
