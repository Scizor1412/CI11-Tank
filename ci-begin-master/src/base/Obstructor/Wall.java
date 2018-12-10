package base.Obstructor;

import base.GameObject;
import base.Renderer.BoxRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class Wall extends GameObject implements Physics {
    BoxCollider boxCollider;

    public void Wall(){
        this.boxCollider = new BoxCollider(this.position, Settings.WAY_SIZE, Settings.WAY_SIZE);
        this.renderer = new BoxRenderer(this.boxCollider, Color.GREEN, true);
        this.position.set(Settings.WAY_SIZE*5, Settings.WAY_SIZE*5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
