import java.awt.*;

public class Wall extends Sprite {

    boolean mobile = false;
    int groupNum = 0; //GroupNum of 0 implies a stationary wall

    public Wall(Color color, int x, int y, double speed, double direction, int width, int height, Screen screen, boolean mobile, int groupNum){
        super(color, x, y, speed, direction, width, height, screen);
        this.mobile = mobile;
        this.groupNum = groupNum;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
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

    public int getGroupNum(){ return groupNum; }
}
