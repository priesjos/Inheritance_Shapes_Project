public class STATS {

    private static final int MAX_LEVELS = 2;
    private static int currentLevel = 1;

    public enum GAMESTATES{
        MENU,
        PLAY,
        PAUSE,
        TRANSITION,
        FINISH,
        DEAD
    }

    public static int getCurrentLevel() { return currentLevel; }

    public static void setCurrentLevel(int currentLevel) { STATS.currentLevel = currentLevel; }

    public static int getMaxLevels() { return MAX_LEVELS; }

}
