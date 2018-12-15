package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.game.Platform;
import base.game.Settings;
import base.obstructor.Wall;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter immuneCounter;
    public static int numberEnemy=20;
    public int hp;
    boolean immune;
    int direction;
    FrameCounter moveCounter;
    FrameCounter fireCounter;

    public Enemy() {
        super();
<<<<<<< Updated upstream
        this.anchor.set(0,0);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 15, 15);
        this.createRenderer();
//        this.renderer = new BoxRenderer(this.boxCollider, Color.BLUE, true);
=======

        this.boxCollider = new BoxCollider(this.position, this.anchor, 32, 32);
        this.createrenderer();
>>>>>>> Stashed changes
        this.hp = 3;
        this.immune = false;
        this.immuneCounter = new FrameCounter(20);
        this.moveCounter = new FrameCounter(6);
        this.fireCounter = new FrameCounter(10);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/Image/enemy/1/tank_armor_left_c1_t1.png"));
        images.add(SpriteUtils.loadImage("assets/Image/enemy/1/tank_armor_left_c1_t2.png"));
        this.renderer = new EnemyAnimator(images, 5);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        if(this.fireCounter.run()) {
            this.fire();
        }

    }

    private void move() {
        if (this.moveCounter.run()) {
            if (this.direction == 1) {
                this.position.addThis(0, -Settings.WAY_SIZE / 2);
                ArrayList<Platform> collidedPlatforms = new ArrayList<>();
                collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
                if (collidedPlatforms != null) {
                    for (Platform platform : collidedPlatforms) {
                        if (platform != null) {
                            if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
                                this.position.substractThis(0, -Settings.WAY_SIZE / 2);
                                this.direction = (int) (Math.random() * 4 + 1);
                                break;
                            }
                        }
                    }

                }
            }
            if (this.direction == 2) {
                this.position.addThis(0, Settings.WAY_SIZE / 2);
                ArrayList<Platform> collidedPlatforms = new ArrayList<>();
                collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
                if (collidedPlatforms != null) {
                    for (Platform platform : collidedPlatforms) {
                        if (platform != null) {
                            if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
                                this.position.substractThis(0, Settings.WAY_SIZE / 2);
                                this.direction = (int) (Math.random() * 4 + 1);
                                break;
                            }
                        }
                    }
                }
            }
            if (this.direction == 3) {
                this.position.addThis(-Settings.WAY_SIZE / 2, 0);
                ArrayList<Platform> collidedPlatforms = new ArrayList<>();
                collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
                if (collidedPlatforms != null) {
                    for (Platform platform : collidedPlatforms) {
                        if (platform != null) {
                            if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
                                this.position.substractThis(-Settings.WAY_SIZE / 2, 0);
                                this.direction = (int) (Math.random() * 4 + 1);
                                break;
                            }
                        }
                    }
                }
            }
            if (this.direction == 4) {
                this.position.addThis(Settings.WAY_SIZE / 2, 0);
                ArrayList<Platform> collidedPlatforms = new ArrayList<>();
                collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
                if (collidedPlatforms != null) {
                    for (Platform platform : collidedPlatforms) {
                        if (platform != null) {
                            if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
                                this.position.substractThis(Settings.WAY_SIZE / 2, 0);
                                this.direction = (int) (Math.random() * 4 + 1);
                                break;
                            }
                        }
                    }
                }
            }
            this.moveCounter.reset();
        }
    }

//    private void fire() {
//        if (this.fireCounter.run()) {
//            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
//            bullet.position.set(this.position);
//            bullet.direction = this.direction;
//            if (this.direction == 1) {
//                bullet.velocity.set(0,-5);
//            }
//            if (this.direction == 2) {
//                bullet.velocity.set(0,5);
//            }
//            if (this.direction == 3) {
//                bullet.velocity.set(-5, 0);
//            }
//            if (this.direction == 4) {
//                bullet.velocity.set(5,0);
//            }
//        }
//    }
    private void fire() {
        EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
        enemyBullet.position.set(this.position);
        enemyBullet.direction = this.direction;
        this.fireCounter.reset();
    }

    public void takeDamage (int damage) {
        if(this.immune)
            return;
        this.hp -= damage;
        if (hp <= 0) {
            this.hp = 0;
            this.destroy();
            this.numberEnemy --;
        } else {
            this.immune = true;
            this.immuneCounter.reset();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
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
