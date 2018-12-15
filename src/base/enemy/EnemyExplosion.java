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

                "assets/Image/explosion/0.png",
                "assets/Image/explosion/1.png",
                "assets/Image/explosion/2.png",
                "assets/Image/explosion/3.png",
                "assets/Image/explosion/4.png",
                "assets/Image/explosion/5.png"
        );
        this.renderer = new AnimationRenderer(images
                , 5, true);
    }
}