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
    int direction;
    FrameCounter fireCounter;

    public Player() {
        this.position.set(210, 310);
        this.boxCollider = new BoxCollider(this.position, 16, 16);
        this.renderer = new BoxRenderer(this.boxCollider, Color.CYAN, true);
        this.moveCounter = new FrameCounter(1);
        this.fireCounter = new FrameCounter(15);
        this.direction = 1;
    }

    @Override
    public void run() {
        this.move();
        if(this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void move() {
        if (moveCounter.run()) {
            if(KeyEventPress.isUpPress) {
                this.position.addThis(0, -Settings.WAY_SIZE/2);
                this.direction = 1;
            }

            if(KeyEventPress.isDownPress) {
                this.position.addThis(0, Settings.WAY_SIZE/2);
                this.direction = 2;
            }

            if(KeyEventPress.isLeftPress) {
                this.position.addThis(-Settings.WAY_SIZE/2, 0);
                this.direction = 3;
            }

            if(KeyEventPress.isRightPress) {
                this.position.addThis(Settings.WAY_SIZE/2, 0);
                this.direction = 4;
            }
            moveCounter.reset();

        }

    }

    private void fire() {
        GameObject playerBullet = GameObject.recycle(PlayerBullet.class);
        playerBullet.position.set(this.position);
        if (this.direction == 1) {
            playerBullet.velocity.set(0,-5);
        }
        if (this.direction == 2) {
            playerBullet.velocity.set(0,5);
        }
        if (this.direction == 3) {
            playerBullet.velocity.set(-5, 0);
        }
        if (this.direction == 4) {
            playerBullet.velocity.set(5,0);
        }
        this.fireCounter.reset();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
