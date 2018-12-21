package base;

import base.renderer.SingleImageRenderer;
import base.scene.SceneStage1;

import base.game.Settings;
import base.scene.MenuScene;
import base.scene.SceneManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class CoverGameOverScene extends GameObject {
    private Clip clip;
    FrameCounter loopCount;

    public CoverGameOverScene() {
        this.renderer = new SingleImageRenderer("assets/Image/background/gameOver.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
        clip = AudioUtils.loadSound("assets/sound/game_over.wav");
        loopCount = new FrameCounter(60 * 2);
        clip.setFramePosition(0);
        clip.start();

    }

    @Override
    public void run() {
        super.run();
        if(loopCount.run()) {
            clip.setFramePosition(0);
            clip.start();
            loopCount.reset();
        }
    }


}
