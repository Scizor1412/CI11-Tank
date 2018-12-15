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
<<<<<<< Updated upstream
                "assets/Image/explosion/0.gif",
                "assets/Image/explosion/1.gif",
                "assets/Image/explosion/2.gif",
                "assets/Image/explosion/3.gif",
                "assets/Image/explosion/4.gif",
                "assets/Image/explosion/5.gif"
=======
                "assets/Image/explosion/0.png",
                "assets/Image/explosion/1.png",
                "assets/Image/explosion/2.png",
                "assets/Image/explosion/3.png",
                "assets/Image/explosion/4.png",
                "assets/Image/explosion/5.png",
                "assets/Image/explosion/6.png",
                "assets/Image/explosion/7.png",
                "assets/Image/explosion/8.png",
                "assets/Image/explosion/9.png",
                "assets/Image/explosion/10.png"
>>>>>>> Stashed changes
        );
        this.renderer = new AnimationRenderer(images
                , 5, true);
    }
}