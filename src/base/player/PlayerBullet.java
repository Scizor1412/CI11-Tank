package base.player;

import base.GameObject;
import base.KeyEventPress;
import base.renderer.BoxRenderer;
import base.enemy.Enemy;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int damage;
    int direction;

    public PlayerBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor, 8, 8);
        this.createrenderer();
        this.damage = 3;
    }

    private void createrenderer() {
        BufferedImage image = SpriteUtils.loadImage("assets/Image/bullet/bullet_left.png");
        this.renderer = new PlayerBulletDirection(image);
    }
    public void run() {
        super.run();
        this.hitEnemy();
        this.destroyIfNeeded();
    }


    private void hitEnemy() {
        Enemy enemy = GameObject.intersects(Enemy.class, this.boxCollider);
        if (enemy != null) {
            enemy.takeDamage(this.damage);
            this.destroy();
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
