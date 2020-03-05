import java.awt.*;
import java.util.ArrayList;

public class WALL_LAYOUTS {

    Wall wall;

    public static void series(int wallNum, int x, int y, int width, int height, int xOffset, int yOffset, int xOffsetIncrement, int yOffsetIncrement, ArrayList<Sprite> load, Screen screen){
        for (int i = 0; i < wallNum; i++){
            load.add(new Wall(Color.RED, x+xOffset, y, 0, 0, width, height, screen, false, 0));
            xOffset += xOffsetIncrement;
            yOffset += yOffsetIncrement;
        }
    }

    public static void shiftingSeries(int wallNum, int x, int y, int speed, int width, int height, int xOffset, int yOffset, int xOffsetIncrement, int yOffsetIncrement,  ArrayList<Sprite> load, Screen screen, int groupNum){
        for (int i = 0; i < wallNum; i++){
            load.add(new Wall(Color.RED, x+xOffset, y+yOffset, speed, 0, width, height, screen, true, groupNum));
            xOffset += xOffsetIncrement;
            yOffset += yOffsetIncrement;
        }
    }

    public static void box(ArrayList<Sprite> load, Screen screen){
        load.add(new Wall(Color.RED, 0, 20, 0, 0, screen.getWidth()*2, 20, screen, false, 0 ));
        load.add(new Wall(Color.RED, 0, screen.getHeight()+20, 0, 0, screen.getWidth()*2, 20, screen, false, 0));
        load.add(new Wall(Color.RED, 0, 20, 0, 0, 20, screen.getHeight()*2, screen, false, 0 ));
        load.add(new Wall(Color.RED, screen.getWidth()-10, 20, 0, 0, 20, screen.getWidth()*2, screen, false, 0));
    }

    public static void branches(ArrayList<Sprite> load, Screen screen){
        load.add(new Wall(Color.RED, 0, 100, 0, 0, 1600, 20, screen, false, 0));
        load.add(new Wall(Color.RED, 200, 300, 0, 0, 1600, 20, screen, false, 0));
        load.add(new Wall(Color.RED, 0, 500, 0, 0, 1600, 20, screen, false, 0));
    }

}
