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
    Action action;

    public Enemy() {
        super();
        this.boxCollider = new BoxCollider(this.position, 28, 28);
        this.renderer = new BoxRenderer(this.boxCollider, Color.BLUE, true);
        this.hp = 3;
        this.immune = false;
        this.immuneCounter = new FrameCounter(60);
        GameObject enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(200, 300);
    }

    @Override
    public void run() {
        super.run();
        this.action.run(this);
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
        this.velocity.set(0,3);
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
