package base;

import base.game.GameCanvas;
import base.game.GameWindow;
import base.game.Settings;
import base.maps.Layer;
import base.maps.Map;
import com.google.gson.Gson;
import tklibs.Utils;

import java.awt.*;

public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();

        GameCanvas canvas = new GameCanvas();
        canvas.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        window.add(canvas);
        window.pack();
        window.setVisible(true);
        canvas.gameLoop();


    }
}
