package base;

import base.renderer.SingleImageRenderer;
import base.scene.SceneStage1;

import base.game.Settings;
import base.scene.MenuScene;
import base.scene.SceneManager;

public class CoverGameOverScene extends GameObject {
    public CoverGameOverScene() {
        this.renderer = new SingleImageRenderer("assets/Image/background/gameOver.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if(KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new MenuScene());
            KeyEventPress.isAnyKeyPress = false;
        }
    }


}
