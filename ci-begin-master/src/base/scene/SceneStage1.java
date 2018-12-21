package base.scene;

import base.Background;
import base.CoverPlayScene;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.maps.Map;
import base.menu.MenuWhite;
import base.menu.MenuWhite2;
import base.player.Player;

public class SceneStage1 extends Scene {

    public static GameObject background;
    public static GameObject player;
    public EnemySummoner enemySummoner;

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
        MenuWhite menuWhite = GameObject.recycle(MenuWhite.class);
        MenuWhite2 menuWhite2 = GameObject.recycle(MenuWhite2.class);
        CoverPlayScene playScene = GameObject.recycle(CoverPlayScene.class);
        CoverPlayScene.playClip();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
