package base.maps;

import base.GameObject;
import base.game.Platform;
import base.game.Settings;
import base.physics.BoxCollider;

import java.util.List;

import static base.GameObject.gameObjects;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void generate() {
        for (int tileY = 0; tileY <height; tileY ++) {
            for (int tileX = 0; tileX <width; tileX++) {
                int mapData = data.get(tileY*width + tileX);
                if (mapData !=0) {
                    Platform platform = Platform.create(mapData);
                    platform.position.set(tileX* Settings.WAY_SIZE/2, tileY*Settings.WAY_SIZE/2);
                    gameObjects.add(platform);
                }
            }
        }
    }
}
