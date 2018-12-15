package base.scene;

import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.obstructor.Wall;
import base.player.Player;

public class SceneStage1 extends Scene {

    public static GameObject background;
    public static GameObject player;
    public EnemySummoner enemySummoner;
    public Wall wall;

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class); //khởi tạo
        this.player = GameObject.recycle(Player.class); //new Player
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
        this.wall = GameObject.recycle(Wall.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
