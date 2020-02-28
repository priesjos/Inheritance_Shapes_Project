import java.awt.*;

public abstract class Sprite {

    Color color;
    int x, y, width, height;
    double dx, dy;

    Screen screen;

    public Sprite(Color color, int x, int y, int width, int height, Screen screen){

        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.screen = screen;

    }

    public Rectangle getBounds(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean collidesWith(Sprite other){
        return getBounds().intersects(other.getBounds());
    }

    public abstract void paint(Graphics g);
    /*
    public void move(){

    }*/

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
