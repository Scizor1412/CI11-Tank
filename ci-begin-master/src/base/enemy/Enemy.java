package base.enemy;

import base.Action.Action;
import base.Action.ActionParallel;
import base.FrameCounter;
import base.GameObject;
import base.Renderer.AnimationRenderer;
import base.Renderer.BoxRenderer;
import base.Renderer.SingleImageRenderer;
import base.game.GameCanvas;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter immuneCounter;
    public int hp;
    boolean immune;
    int direction;

    public Enemy() {
        super();
        this.boxCollider = new BoxCollider(this.position, 15, 15);
        this.renderer = new BoxRenderer(this.boxCollider, Color.BLUE, true);
        this.hp = 3;
        this.immune = false;
        this.immuneCounter = new FrameCounter(60);
        this.velocity.set(1,0);
        this.direction = (int) Math.random()*5 +0;
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
    }

    private void move() {
        if (this.direction == 1) {
            this.position.addThis(0, -Settings.WAY_SIZE/2);
        }
        if (this.direction == 2) {
            this.position.addThis(0, Settings.WAY_SIZE/2);
        }
        if (this.direction == 3) {
            this.position.addThis(-Settings.WAY_SIZE/2, 0);
        }
        if (this.direction == 4) {
            this.position.addThis(Settings.WAY_SIZE/2, 0);
        }
    }

    private void fire() {
    }

    public void takeDamage (int damage) {
        if(this.immune)
            return;
        this.hp -= damage;
        if (hp <= 0) {
            this.hp = 0;
            this.destroy();
        } else {
            this.immune = true;
            this.immuneCounter.reset();
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.immune = false;
        this.immuneCounter.reset();
        this.hp = 3;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void render(Graphics g) {
        if (this.immune) {
            //TODO
            if (this.immuneCounter.run()) {
                this.immune = false;
            }
            if (this.immuneCounter.count % 4 == 0) {
                super.render(g);
            }
        } else {
            super.render(g);
        }
    }
}
