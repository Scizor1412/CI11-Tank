package base.player;

import base.GameObject;
import base.renderer.BoxRenderer;
import base.enemy.Enemy;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int damage;

    public PlayerBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, 24, 24);
        this.renderer = new BoxRenderer(this.boxCollider, Color.RED, true);
        this.damage = 3;
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
