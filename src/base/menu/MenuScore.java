package base.menu;

import base.GameObject;
import base.enemy.Enemy;
import base.renderer.TextRenderer;

import java.awt.*;

public class MenuScore extends GameObject {
    public MenuScore() {
        this.renderer = new TextRenderer(this.position, String.valueOf(Enemy.numberEnemy), Color.BLUE, 15);
        this.position.set(470, 50);
    }

    @Override
    public void run() {
        super.run();
//        if (Enemy.numberEnemy ) {
//            Enemy.numberEnemy --;
//        }
    }
}
