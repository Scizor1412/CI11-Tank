package base.game;

import java.awt.event.KeyEvent;

public class Settings {

    public static int SCREEN_WIDTH = 750;
    public static int SCREEN_HEIGHT = 600;
    public static int WAY_SIZE = 30;
    public static int GAME_WIDTH = 600;
    public static int GAME_HEIGHT = 600;
    public static int ROW_COUNT = GAME_HEIGHT/WAY_SIZE;
    public static int COLUMN_COUNT = GAME_WIDTH/WAY_SIZE;
    public static int UP_BUTTON = KeyEvent.VK_W;
    public static int DOWN_BUTTON = KeyEvent.VK_S;
    public static int LEFT_BUTTON = KeyEvent.VK_A;
    public static int RIGHT_BUTTON = KeyEvent.VK_D;
    public static int FIRE_BUTTON = KeyEvent.VK_SPACE;
    public static int PAUSE_BUTTON = KeyEvent.VK_ENTER;
    public static int RETURN_BUTTON = KeyEvent.VK_ESCAPE;
}
