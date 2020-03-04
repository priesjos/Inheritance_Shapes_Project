import java.awt.*;
import java.util.ArrayList;

public class WALL_LAYOUTS {

    Wall wall;

    public static void columns(int columns, int x, int y, int width, int height, int offset, int offsetIncrement, ArrayList<Sprite> load, Screen screen){
        for (int i = 0; i < columns; i++){
            load.add(new Wall(Color.RED, x+offset, y, 0, 0, width, height, screen, false, 0));
            offset += offsetIncrement;
        }
    }

    public static void shiftingColumns(int columns, int x, int y, int speed, int width, int height, int offset, int offsetIncrement, ArrayList<Sprite> load, Screen screen, int groupNum){
        for (int i = 0; i < columns; i++){
            load.add(new Wall(Color.RED, x+offset, y, speed, 0, width, height, screen, true, groupNum));
            offset += offsetIncrement;
        }
    }

    public static void box(ArrayList<Sprite> load, Screen screen){
        load.add(new Wall(Color.RED, 0, 20, 0, 0, screen.getWidth()*2, 20, screen, false, 0 ));
        load.add(new Wall(Color.RED, 0, screen.getHeight()+20, 0, 0, screen.getWidth()*2, 20, screen, false, 0));
        load.add(new Wall(Color.RED, 0, 20, 0, 0, 20, screen.getHeight()*2, screen, false, 0 ));
        load.add(new Wall(Color.RED, screen.getWidth()-10, 20, 0, 0, 20, screen.getWidth()*2, screen, false, 0));
    }
}
