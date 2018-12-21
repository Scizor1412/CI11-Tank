package base.menu;

import base.GameObject;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class MenuWhite2 extends GameObject {
    public MenuWhite2() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/Image/Sprite-0001.jpg");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(700,450);
    }

    @Override
    public void run() {
        super.run();
        MenuLife menuLife = GameObject.recycle(MenuLife.class);
    }
}
