package base.menu;

import base.GameObject;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class MenuWhite extends GameObject {
    public MenuWhite() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/Image/Sprite-0001.jpg");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(700,150);

    }

    @Override
    public void run() {
        super.run();
        MenuScore menuScore = GameObject.recycle(MenuScore.class);
    }
}
