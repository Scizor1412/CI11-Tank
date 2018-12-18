package base;


import base.renderer.SingleImageRenderer;
import base.scene.SceneStage1;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;

public class CoverMenuScene extends GameObject {

    public CoverMenuScene() {
        this.renderer = new SingleImageRenderer("assets/Image/background/gameStart.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
