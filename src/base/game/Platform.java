package base.game;

import base.GameObject;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;

import javax.swing.*;

public class Platform extends GameObject implements Physics {
    BoxCollider boxCollider;
    Vector2D masterAnchor;
    public int platformType;
    int hp;

    public Platform() {
        this.anchor.set(0,0);
        this.boxCollider = new BoxCollider(this.position, this.anchor, Settings.WAY_SIZE, Settings.WAY_SIZE);
        this.hp=3;
    }

    public static Platform create(int platformType) {
        Platform platform = new Platform();
        platform.platformType = platformType;
        if (platformType == 1) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/sea.png");
        }
        if (platformType == 2) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/steel.png");
        }
        if (platformType == 3) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/brick.png");
        }
        if (platformType == 4) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/forest.png");
        }
        return platform;
    }

    public void takeDamage(int damage) {
        if (this.platformType == 3) {
            this.hp -= damage;
            if (hp <= 0) {
                this.hp = 0;
                this.destroy();
            }
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
