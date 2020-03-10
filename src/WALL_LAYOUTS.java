import java.awt.*;
import java.util.ArrayList;

public class WALL_LAYOUTS {

    Wall wall;

    public static void series(int wallNum, int x, int y, int speed, int width, int height, int xOffset, int yOffset, int xOffsetIncrement, int yOffsetIncrement, ArrayList<Sprite> load, Screen screen, int groupNum){
        boolean mobileVal;
        if (groupNum != 0)
            mobileVal = true;
        else
            mobileVal = false;
        for (int i = 0; i < wallNum; i++){
            load.add(new Wall(Color.RED, x+xOffset, y+yOffset, speed, 0, width, height, screen, mobileVal, groupNum));
            xOffset += xOffsetIncrement;
            yOffset += yOffsetIncrement;
        }
    }
/*
    public static void shiftingSeries(int wallNum, int x, int y, int speed, int width, int height, int xOffset, int yOffset, int xOffsetIncrement, int yOffsetIncrement,  ArrayList<Sprite> load, Screen screen, int groupNum){
        for (int i = 0; i < wallNum; i++){
            load.add(new Wall(Color.RED, x+xOffset, y+yOffset, speed, 0, width, height, screen, true, groupNum));
            xOffset += xOffsetIncrement;
            yOffset += yOffsetIncrement;
        }
    }*/


    public static void box(ArrayList<Sprite> load, Screen screen){
        load.add(new Wall(Color.RED, 0, 0, 0, 0, screen.getWidth(), 20, screen, false, 0 ));
        load.add(new Wall(Color.RED, 0, screen.getHeight()-20, 0, 0, screen.getWidth(), 20, screen, false, 0));
        load.add(new Wall(Color.RED, 0, 0, 0, 0, 20, screen.getHeight(), screen, false, 0 ));
        load.add(new Wall(Color.RED, screen.getWidth()-20, 20, 0, 0, 20, screen.getWidth(), screen, false, 0));
    }

    public static void branches(ArrayList<Sprite> load, Screen screen, int startY, int iterations, int yOffset){
        int xVal;

        for (int i = 0; i < iterations; i++){
            if (i%2 == 0)
                xVal = 200;
            else
                xVal = 0;
            load.add(new Wall(Color.RED, xVal, startY+(yOffset*i), 0, 0, 800, 20, screen, false, 0));
        }
    }

    public static void verticalBranches(ArrayList<Sprite> load, Screen screen, int startX, int iterations, int xOffset){
        int yVal;
        for (int i = 0; i < iterations; i++){
            if (i%2 == 0)
                yVal = screen.getHeight()-400;
            else
                yVal = 0;
            load.add(new Wall(Color.RED, startX+(xOffset*i), yVal, 0, 0, 20, 400, screen, false, 0));
        }
    }

}
