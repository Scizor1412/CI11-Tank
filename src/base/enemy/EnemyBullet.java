package base.enemy;

import base.GameObject;
import base.renderer.BoxRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int direction;
    int damage;
    public EnemyBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor,8, 8);
        //this.renderer = new BoxRenderer(this.boxCollider, Color.LIGHT_GRAY, true);
        this.createrenderer();
        this.damage=3;


    }

    private void createrenderer() {
        BufferedImage image = SpriteUtils.loadImage("assets/Image/bullet/bullet_left.png");
        this.renderer=new EnemyBulletDirection(image);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.destroyIfNeeded();
    }

    private void move() {
        if (this.direction == 1) {
            this.position.addThis(0, -5);
        }
        if (this.direction == 2) {
            this.position.addThis(0, 5);
        }
        if (this.direction == 3) {
            this.position.addThis(-5, 0);
        }
        if (this.direction == 4) {
            this.position.addThis(5, 0);
        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT || this.position.x < -20 || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
