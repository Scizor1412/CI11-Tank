package base.renderer;

import base.GameObject;
import base.enemy.Enemy;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuScoreRenderer extends Renderer{
    TextRenderer text;
    BufferedImage image;

    public MenuScoreRenderer(){
        this.text = new TextRenderer(String.valueOf(Enemy.numberEnemy), Color.BLUE, 15);
        this.image = SpriteUtils.loadImage("assets/Image/enemy/enemy counter/enemy_counter.png");
    }
    @Override
    public void render(Graphics g, GameObject master) {
        text.render(g,master);
        g.drawImage(this.image, (int)(master.position.x - 20), (int)(master.position.y -13),null);
    }
}
