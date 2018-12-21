package base;


import base.renderer.SingleImageRenderer;
import base.scene.SceneStage1;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class CoverMenuScene extends GameObject {
    private Clip clip;
    FrameCounter loopCount;

    public CoverMenuScene() {
        this.renderer = new SingleImageRenderer("assets/Image/background/gameStart.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
        clip = AudioUtils.loadSound("assets/sound/stage_start.wav");
        loopCount = new FrameCounter(60 * 5);
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
        if (KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
            clip.close();
        }
    }
}
