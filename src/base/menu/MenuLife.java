package base.menu;

import base.GameObject;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuLife extends GameObject {
    int i = 3;
    public MenuLife() {
        this.renderer = new TextRenderer(this.position, String.valueOf(i), Color.BLUE, 15);
        this.position.set(470, 300);
//        BufferedImage image = SpriteUtils.loadImage("assets/Image/player/player life/life.png");
//        this.renderer = new SingleImageRenderer(image);
//        this.position.set(400,300);
    }

    @Override
    public void run() {
        super.run();
//        if ()
    }
}
