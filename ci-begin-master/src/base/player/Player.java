package base.player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.game.Platform;
import base.game.Settings;
import base.menu.MenuWhite2;
import base.obstructor.Wall;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.scene.GameOverScene;
import base.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter moveCounter;
    int direction;
    FrameCounter fireCounter;
    public static int hp = 3;

    public Player() {
        this.position.set(16, 586);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 16, 16);
        this.createRenderer();
        this.moveCounter = new FrameCounter(4);
        this.fireCounter = new FrameCounter(15);
        this.direction = 1;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/Image/player/1/tank_player1_left_c0_t1_s1.png"));
        images.add(SpriteUtils.loadImage("assets/Image/player/1/tank_player1_left_c0_t1_s1.png"));

        this.renderer = new PlayerAnimator(images, 5);
    }

    @Override
    public void run() {
        this.turn();
        this.move();
        if (this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void turn() {
        if (KeyEventPress.isUpPress) {
            this.direction = 1;
        } else if (KeyEventPress.isDownPress) {
            this.direction = 2;
        } else if (KeyEventPress.isLeftPress) {
            this.direction = 3;
        } else if (KeyEventPress.isRightPress) {
            this.direction = 4;
        }
    }

    private void move() {
        if (moveCounter.run()) {
            if (KeyEventPress.isUpPress) {
                float vy = -Settings.WAY_SIZE / 2;
                float vx = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);

            } else if (KeyEventPress.isDownPress) {
                float vy = Settings.WAY_SIZE / 2;
                float vx = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);

            } else if (KeyEventPress.isLeftPress) {
                float vx = -Settings.WAY_SIZE / 2;
                float vy = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);

            } else if (KeyEventPress.isRightPress) {
                float vx = Settings.WAY_SIZE / 2;
                float vy = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);
            }
            moveCounter.reset();
        }
    }

    private void collidePlatform(float vx, float vy) {
        ArrayList<Platform> collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
        if (collidedPlatforms != null) {
            for (Platform platform : collidedPlatforms) {
                if (platform != null) {
                    if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
                        this.position.substractThis(vx, vy);
                        break;
                    }
                }
                if(this.position.x>Settings.SCREEN_WIDTH){
                    this.position.substractThis(Settings.WAY_SIZE / 2, 0);
                }
            }
        }
    }


    private void fire() {
        GameObject playerBullet = GameObject.recycle(PlayerBullet.class);
        playerBullet.position.set(this.position);
        ((PlayerBullet) playerBullet).direction=this.direction;
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

    @Override
    public void destroy() {
        super.destroy();
        SceneManager.signNewScene(new GameOverScene());
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        MenuWhite2 menuWhite2 = GameObject.recycle(MenuWhite2.class);
        if (this.hp <= 0) {
            this.destroy();
            hp = 3;
        }
    }
}
