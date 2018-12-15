package base;

<<<<<<< HEAD
import base.renderer.SingleImageRenderer;
//import base.scene.SceneStage1;
=======
>>>>>>> 6abbd64c32c35882f1ff2a7348025cfd6245905e
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;

public class CoverMenuScene extends GameObject {

    public CoverMenuScene() {
        this.renderer = new SingleImageRenderer("F:\\Project-CI\\CI11-Tank\\ci-begin-master\\assets\\Image\\background\\gameStart.png");
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
