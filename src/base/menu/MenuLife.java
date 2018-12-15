package base.menu;

import base.GameObject;
import base.renderer.MenuLifeRenderer;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuLife extends GameObject {
    int i = 3;
    public MenuLife() {
        this.renderer = new MenuLifeRenderer();
        this.position.set(470, 550);
//
//        this.renderer = new SingleImageRenderer(image);
//        this.position.set(400,300);
    }

    @Override
    public void run() {
        super.run();
//        if ()
    }
}
