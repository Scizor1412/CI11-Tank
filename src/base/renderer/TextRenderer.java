package base.renderer;

import base.GameObject;
import base.Vector2D;

import java.awt.*;

public class TextRenderer extends Renderer {
    String text;
    Color color;
    Font font;
    int i;
    public TextRenderer(String text, Color color, int i) {
        this.i = i;
        this.text = text;
        this.color = color;
        this.font = new Font("Verdana", Font.BOLD, i);
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(this.text, (int)master.position.x, (int)master.position.y);
    }
}
