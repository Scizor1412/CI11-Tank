package base;

import base.Renderer.SingleImageRenderer;
import base.Scene.SceneManager;
//import base.Scene.SceneStage1;
import base.game.Settings;

public class CoverGameOverScene extends GameObject {
    public CoverGameOverScene() {
        this.renderer = new SingleImageRenderer("assets/images/background/GameOver.jpg");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if(KeyEventPress.isAnyKeyPress) {
//            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
