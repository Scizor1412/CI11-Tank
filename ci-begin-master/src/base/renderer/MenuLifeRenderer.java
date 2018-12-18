package base.renderer;

import base.GameObject;
import base.player.Player;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuLifeRenderer extends Renderer {
    TextRenderer text;
    BufferedImage image;

    public MenuLifeRenderer() {
        this.text = new TextRenderer(String.valueOf(Player.hp), Color.BLUE, 15);
        this.image = SpriteUtils.loadImage("assets/Image/player/player life/life.png");
    }
    @Override
    public void render(Graphics g, GameObject master) {
        text.render(g, master);
        g.drawImage(this.image, (int)(master.position.x - 20), (int)(master.position.y - 13),null);
    }
}
