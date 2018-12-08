package base;

import base.Renderer.SingleImageRenderer;
import base.Scene.SceneManager;
//import base.Scene.SceneStage1;
import base.game.GameCanvas;
import base.game.Settings;

public class CoverMenuScene extends GameObject {

    public CoverMenuScene() {
        this.renderer = new SingleImageRenderer("D:\\Techkids\\Code Intensive\\sokoban\\ci-begin-master\\assets\\images\\background\\menuScene.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress) {
//            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
