package base.scene;

import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.maps.Map;
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
        EnemySummoner enemySummoner = GameObject.recycle(EnemySummoner.class);
        enemySummoner.position.set(-20, 0);
        EnemySummoner enemySummoner1 = GameObject.recycle(EnemySummoner.class);
        enemySummoner1.position.set(300, 0);
        Map map = Map.load("assets/Image/map/tank2.json");
        map.generate();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
