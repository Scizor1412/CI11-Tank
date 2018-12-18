package base.menu;

import base.GameObject;
import base.enemy.Enemy;
import base.renderer.MenuScoreRenderer;
import base.renderer.TextRenderer;

import java.awt.*;

public class MenuScore extends GameObject {
    public MenuScore() {
        this.renderer = new MenuScoreRenderer();
        this.position.set(670, 150);
    }

    @Override
    public void run() {
        super.run();
//        if (Enemy.numberEnemy ) {
//            Enemy.numberEnemy --;
//        }
    }
}
