package base.scene;

import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.maps.Map;
import base.menu.MenuLife;
import base.menu.MenuScore;
import base.menu.MenuWhite;
import base.menu.MenuWhite2;
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
        enemySummoner.position.set(620, 0);
        Map map = Map.load("assets/Image/map/tank..json");
        map.generate();
        MenuWhite menuWhite = GameObject.recycle(MenuWhite.class);
        MenuWhite2 menuWhite2 = GameObject.recycle(MenuWhite2.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
