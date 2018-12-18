package base;

import base.game.Settings;
import base.renderer.SingleImageRenderer;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class CoverGamePauseScene extends GameObject {
    private static Clip clip;
    static FrameCounter loopCount;

    public CoverGamePauseScene() {
        this.renderer = new SingleImageRenderer("assets/Image/background/gamePause.png");
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
        clip = AudioUtils.loadSound("assets/sound/stage_start.wav");
        loopCount = new FrameCounter(60 * 5);
    }

    @Override
    public void run() {
        super.run();
        if(loopCount.run()) {
            playClip();
            loopCount.reset();
        }
    }

    public static void playClip() {
        clip.setFramePosition(0);
        clip.start();
    }

    public static void closeClip() {
        loopCount.reset();
        clip.stop();
    }
}
