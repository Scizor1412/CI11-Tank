package base.player;
import base.GameObject;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class PlayerBulletDirection extends Renderer {
    BufferedImage image;
    AffineTransform transform;
    AffineTransform emptyTransform;
    double angle;
    public PlayerBulletDirection(BufferedImage image) {
        this.image=image;
        this.angle = 0;
        this.transform = new AffineTransform();
        this.emptyTransform = new AffineTransform();
    }

    @Override
    public void render(Graphics g, GameObject master) {
        PlayerBullet playerBullet = (PlayerBullet) master; // rotate
        Graphics2D g2D = (Graphics2D) g;
        this.syncTransform(playerBullet, this.image);
        g2D.drawImage(this.image, this.transform, null);
    }
    public void syncTransform(PlayerBullet master, BufferedImage image) {
        this.transform.setTransform(this.emptyTransform);

        double x = master.position.x - image.getWidth() * master.anchor.x;
        double y = master.position.y - image.getHeight() * master.anchor.y;
        this.transform.translate(x, y);

        switch(master.direction) {
            case 1:
                this.angle = Math.PI / 2;
                break;
            case 2:
                this.angle = -Math.PI / 2;
                break;
            case 3:
                this.angle = 0;
                break;
            case 4:
                this.angle = Math.PI;
                break;
        }
        this.transform.rotate(this.angle, image.getWidth() / 2
                , image.getHeight() / 2);
    }
}


