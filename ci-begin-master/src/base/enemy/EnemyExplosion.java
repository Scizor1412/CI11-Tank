package base.enemy;

import base.GameObject;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion(){
        this.createAnimation();
    }
    private void createAnimation() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/Image/explosion/0.gif",
                "assets/Image/explosion/1.gif",
                "assets/Image/explosion/2.gif",
                "assets/Image/explosion/3.gif",
                "assets/Image/explosion/4.gif",
                "assets/Image/explosion/5.gif"
        );
        this.renderer = new AnimationRenderer(images
                , 5, true);
    }
}