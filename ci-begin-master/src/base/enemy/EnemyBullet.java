package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.game.Platform;
import base.game.Settings;
import base.obstructor.Wall;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.BoxRenderer;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int direction;
    int damage;

    public EnemyBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor,30, 30);
        this.renderer = new BoxRenderer(this.boxCollider, Color.LIGHT_GRAY, true);
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.destroyIfNeeded();
        this.hitPlayer();
        this.hitWall();
    }

    private void hitPlayer() {
        ArrayList<Player> collidedPlayers = GameObject.intersects(Player.class, this.boxCollider);
        if (collidedPlayers != null) {
            for (Player player : collidedPlayers) {
                if(player.immune)
                    return;
                if (player != null) {
                    if (player.hp > 0) {
                        player.hp -= 1;
                        this.destroy();
                        AudioUtils.loadSound("assets/sound/bullet_hit_2.wav").start();
                    }
                    if (player.hp <= 0){
                        player.destroy();
                        this.destroy();
                        AudioUtils.loadSound("assets/sound/explosion_2.wav").start();
                    } else {
                        player.immune = true;
                        player.immuneCounter.reset();
                    }
                }
            }
        }
    }

    private void hitWall() {
        ArrayList<Platform> collidedPlatforms = GameObject.intersects(Platform.class, this.boxCollider);
        if (collidedPlatforms != null) {
            for (Platform platform : collidedPlatforms) {
                if (platform != null) {
                    this.destroy();
                    if (platform.platformType == 3) {
                        platform.takeDamage(damage);
                    }
                }
            }
        }

    }

    private void move() {
        if (this.direction == 1) {
            this.position.addThis(0, -Settings.WAY_SIZE);
        }
        if (this.direction == 2) {
            this.position.addThis(0, Settings.WAY_SIZE);
        }
        if (this.direction == 3) {
            this.position.addThis(-Settings.WAY_SIZE, 0);
        }
        if (this.direction == 4) {
            this.position.addThis(Settings.WAY_SIZE, 0);
        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20
                || this.position.y > Settings.SCREEN_HEIGHT
                || this.position.x < -20
                || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
