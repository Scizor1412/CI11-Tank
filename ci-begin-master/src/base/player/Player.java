package base.player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.Renderer.BoxRenderer;
import base.enemy.Enemy;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class Player extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter moveCounter;
    public Player() {
        this.position.set(210, 310);
        this.boxCollider = new BoxCollider(this.position, 16, 16);
        this.renderer = new BoxRenderer(this.boxCollider, Color.CYAN, true);
        this.moveCounter = new FrameCounter(1);
    }

    @Override
    public void run() {
        this.move();
        if(KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void move() {
        if (moveCounter.run()) {
            if(KeyEventPress.isUpPress) {
                this.position.addThis(0, -Settings.WAY_SIZE/2);
            }

            if(KeyEventPress.isDownPress) {
                this.position.addThis(0, Settings.WAY_SIZE/2);
            }

            if(KeyEventPress.isLeftPress) {
                this.position.addThis(-Settings.WAY_SIZE/2, 0);
            }

            if(KeyEventPress.isRightPress) {
                this.position.addThis(Settings.WAY_SIZE/2, 0);
            }
            moveCounter.reset();

        }

    }

    private void fire() {
        GameObject playerBullet = GameObject.recycle(PlayerBullet.class);
        playerBullet.position.set(this.position);
        playerBullet.velocity.set(0,-5);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
