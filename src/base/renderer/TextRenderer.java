package base.renderer;

import base.GameObject;
import base.Vector2D;

import java.awt.*;

public class TextRenderer extends Renderer {
    public Vector2D position;
    String text;
    Color color;
    Font font;
    int i;
    public TextRenderer(Vector2D position, String text, Color color, int i) {
        this.i = i;
        this.position = position;
        this.text = text;
        this.color = color;
        this.font = new Font("Verdana", Font.BOLD, i);
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(this.text, (int)this.position.x, (int)this.position.y);
    }
}
