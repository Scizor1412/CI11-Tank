package base.game;

import base.GameObject;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;

public class Platform extends GameObject implements Physics {
    BoxCollider boxCollider;
    public int platformType;
    int hp;
    public int direction;

    public Platform() {

        this.anchor.set(0,0);
        this.boxCollider = new BoxCollider(this.position, this.anchor, Settings.WAY_SIZE/2, Settings.WAY_SIZE/2);
        this.hp=1;
    }

    public static Platform create(int platformType) {
        Platform platform = new Platform();
        platform.platformType = platformType;
        if (platformType == 2) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/sea.png");
        }
        if (platformType == 6) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/steel.png");
        }
        if (platformType == 1) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/brick_1.png");
        }
        if (platformType == 7) {
            platform.renderer = new SingleImageRenderer("assets/Image/objects/forest.png");
        }
        return platform;
    }

    public void takeDamage(int damage) {
        if (this.platformType == 1) {
            this.hp -= damage;
            if (hp <= 0) {
                this.destroy();
            }
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
