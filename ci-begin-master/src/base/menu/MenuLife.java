package base.menu;

import base.GameObject;
import base.player.Player;
import base.renderer.MenuLifeRenderer;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuLife extends GameObject {
    public MenuLife() {
        this.renderer = new MenuLifeRenderer();
        this.position.set(670, 500);
    }

    @Override
    public void run() {
        super.run();

    }
}
