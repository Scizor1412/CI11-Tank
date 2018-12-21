package base.game;


import base.CoverGamePauseScene;
import base.GameObject;
import base.scene.MenuScene;
import base.scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    CoverGamePauseScene pauseScene;

    public GameCanvas() {
        SceneManager.signNewScene(new MenuScene());
        pauseScene = new CoverGamePauseScene();
        this.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        if (GameObject.pause) {
            pauseScene.render(g);
        } else {
            g.fillRect(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
            for (int i = 0; i < GameObject.gameObjects.size(); i++) {
                GameObject gameObject = GameObject.gameObjects.get(i);
                if (gameObject.isActive) {
                    gameObject.render(g);
                }
            }
        }
    }

    public void gameLoop() {
        int delay = 1000/60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        if (GameObject.pause) {
            pauseScene.run();
        } else {
            pauseScene.closeClip();
            for (int i = 0; i < GameObject.gameObjects.size(); i++) {
                GameObject gameObject = GameObject.gameObjects.get(i);
                if (gameObject.isActive) {
                    gameObject.run();
                }
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
