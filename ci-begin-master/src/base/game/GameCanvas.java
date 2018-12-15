package base.game;


import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.maps.Map;
import base.obstructor.Wall;
import base.player.Player;
import base.scene.MenuScene;
import base.scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    public GameCanvas() {
        Background backGround = GameObject.recycle(Background.class);
        this.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        Player player = GameObject.recycle(Player.class);
        EnemySummoner enemySummoner = GameObject.recycle(EnemySummoner.class);
        enemySummoner.position.set(-20, 0);
        EnemySummoner enemySummoner1 = GameObject.recycle(EnemySummoner.class);
        enemySummoner.position.set(620, 0);
        Wall wall = GameObject.recycle(Wall.class);

        Map map = Map.load("assets/Image/map/tank..json");
        map.generate();
        SceneManager.signNewScene(new MenuScene());
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        for (int i =0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.render(g);
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
//        for(GameObject gameObject: GameObject.gameObjects) {
        for (int i=0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
