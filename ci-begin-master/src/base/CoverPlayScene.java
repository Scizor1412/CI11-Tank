package base;

import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class CoverPlayScene extends GameObject {
    private static Clip clip;
    static FrameCounter loopCount;

    public CoverPlayScene() {
        clip = AudioUtils.loadSound("assets/sound/background_music.wav");
        loopCount = new FrameCounter(60 * 132);
    }

    @Override
    public void run() {
        super.run();
        if(loopCount.run()) {
            clip.setFramePosition(0);
            playClip();
            loopCount.reset();
        }
    }

    public static void playClip() {
        clip.start();
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-12.0f);
    }

    public static void closeClip() {
        loopCount.reset();
        clip.stop();
    }
}
