package base.scene;

import base.Background;
import base.CoverPlayScene;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.maps.Map;
import base.player.Player;

public class SceneStage1 extends Scene {

    public static GameObject background;
    public static GameObject player;
    public EnemySummoner enemySummoner;

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class); //khởi tạo
        this.player = GameObject.recycle(Player.class); //new Player
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
        EnemySummoner enemySummoner = GameObject.recycle(EnemySummoner.class);
        enemySummoner.position.set(-20, 0);
        EnemySummoner enemySummoner1 = GameObject.recycle(EnemySummoner.class);
        enemySummoner1.position.set(620, 0);
        Map map = Map.load("assets/Image/map/tank..json");
        map.generate();
        CoverPlayScene playScene = GameObject.recycle(CoverPlayScene.class);
        CoverPlayScene.playClip();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
