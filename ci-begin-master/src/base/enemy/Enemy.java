package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.game.Platform;
import base.game.Settings;
import base.menu.MenuWhite;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import tklibs.AudioUtils;
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
    FrameCounter turnCounter;


    public Enemy() {
        super();
        ArrayList<Integer> directions = new ArrayList<Integer>();
        for (int i=1; i<5; i++) {
            directions.add(i);
        }

        this.boxCollider = new BoxCollider(this.position, this.anchor, 15, 15);
        this.createRenderer();
//        this.renderer = new BoxRenderer(this.boxCollider, Color.BLUE, true);

        this.hp = 2;
        this.immune = false;
        this.immuneCounter = new FrameCounter(15);
        this.moveCounter = new FrameCounter(6);
        this.fireCounter = new FrameCounter(20);
        this.turnCounter = new FrameCounter(300);
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
        this.turn();
        if(this.fireCounter.run()) {
            this.fire();
        }

    }

    private void turn() {
        if (this.turnCounter.run()) {
            this.direction = (int) (Math.random() * 4 + 1);
            this.turnCounter.reset();
        }
    }

    private void move() {
        if (this.moveCounter.run()) {
            if (this.direction == 1 && this.position.y > Settings.WAY_SIZE) {
                float vy = -Settings.WAY_SIZE / 2;
                float vx = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);
                this.collidePlayer(vx, vy);
                this.collideEnemy(vx, vy);
            }

            else if (this.direction == 2 && this.position.y < Settings.GAME_HEIGHT - Settings.WAY_SIZE/2) {
                float vy = Settings.WAY_SIZE / 2;
                float vx = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);
                this.collidePlayer(vx, vy);
                this.collideEnemy(vx, vy);
            }
            else if (this.direction == 3 && this.position.x > Settings.WAY_SIZE) {
                float vx = -Settings.WAY_SIZE / 2;
                float vy = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);
                this.collidePlayer(vx, vy);
                this.collideEnemy(vx, vy);
            }
            else if (this.direction == 4 && this.position.x < Settings.GAME_WIDTH - Settings.WAY_SIZE/2) {
                float vx = Settings.WAY_SIZE / 2;
                float vy = 0;
                this.position.addThis(vx, vy);
                this.collidePlatform(vx, vy);
                this.collidePlayer(vx, vy);
                this.collideEnemy(vx, vy);
            } else {
                this.direction = (int) (Math.random() * 4 + 1);
            }
            this.moveCounter.reset();
        }
    }


    private void collideEnemy(float vx, float vy) {
        ArrayList<Enemy> collidedEnemies = GameObject.intersects(Enemy.class, this.boxCollider);
        if (collidedEnemies != null) {
            this.position.substractThis(vx, vy);
            this.direction = (int) (Math.random() * 4 + 1);
        }
    }

    private void collidePlayer(float vx, float vy) {
        ArrayList<Player> collidedPlayer = GameObject.intersects(Player.class, this.boxCollider);
        if (collidedPlayer != null) {
            this.position.substractThis(vx, vy);
            this.direction = (int) (Math.random() * 4 + 1);
        }
    }

    private void collidePlatform(float vx, float vy) {
        ArrayList<Platform> collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
        if (collidedPlatforms != null) {
            for (Platform platform: collidedPlatforms) {
                if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 6) {
                    this.position.substractThis(vx, vy);
                    this.direction = (int) (Math.random() * 4 + 1);
                    break;
                }
            }
        }
    }
//        ArrayList<Platform> collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
//        if (collidedPlatforms != null) {
//            for (Platform platform : collidedPlatforms) {
//                if (platform != null) {
//                    if (platform.platformType == 1 || platform.platformType == 2 || platform.platformType == 3) {
//                        this.position.substractThis(vx, vy);
//                        this.direction = (int) (Math.random() * 4 + 1);
//                        break;
//                    }
//                }
//            }
//        }

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
        AudioUtils.loadSound("assets/sound/bullet_hit_1.wav").start();
        if (hp <= 0) {
            this.hp = 0;
            this.destroy();
        } else {
            this.immune = true;
            this.immuneCounter.reset();
            AudioUtils.loadSound("assets/sound/explosion_1.wav").start();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (numberEnemy >= 0) {
            numberEnemy = numberEnemy -1;
        }
        else {
            numberEnemy = 20;
        }
        MenuWhite menuWhite = GameObject.recycle(MenuWhite.class);
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
