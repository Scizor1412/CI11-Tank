package base.renderer;

import base.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuLifeRenderer extends Renderer {
    TextRenderer text;
    BufferedImage image;
    int i = 3;

    public MenuLifeRenderer() {
        this.text = new TextRenderer(String.valueOf(i), Color.BLUE, 15);
        this.image = SpriteUtils.loadImage("assets/Image/player/player life/life.png");
    }
    @Override
    public void render(Graphics g, GameObject master) {
        text.render(g, master);
        g.drawImage(this.image, (int)(master.position.x - 20), (int)(master.position.y - 13),null);
    }
}
