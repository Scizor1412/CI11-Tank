package base.game;


import base.GameObject;
import base.BackGround;
import base.obstructor.Wall;
import base.enemy.EnemySummoner;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    public GameCanvas(){
        BackGround backGround = GameObject.recycle(BackGround.class);
        this.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        Player player = GameObject.recycle(Player.class);
        EnemySummoner enemySummoner = GameObject.recycle((EnemySummoner.class));
        Wall wall = GameObject.recycle(Wall.class);

//        SceneManager.signNewScene(new MenuScene());
    }

    @Override
    protected void paintComponent(Graphics g) {
//        for (GameObject gameObject: GameObject.gameObjects) {
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
