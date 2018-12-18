package base.obstructor;

import base.GameObject;
import base.game.Platform;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Wall extends Platform implements Physics {
    BoxCollider boxCollider;
    int hp;

    public Wall(){
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor, Settings.WAY_SIZE, Settings.WAY_SIZE);
//        this.renderer = new BoxRenderer(this.boxCollider, Color.GREEN, true);
        BufferedImage image = SpriteUtils.loadImage("assets/Image/objects/brick.png");
        this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0,0);
        this.hp = 2;
    }

    @Override
    public void run() {
        super.run();
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            this.hp = 0;
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

