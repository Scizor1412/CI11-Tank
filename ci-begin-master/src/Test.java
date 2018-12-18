import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class Test {
    public static void main(String[] args) {
        Clip clip = AudioUtils.loadSound("F:\\ci-begin-master\\assets\\music\\sfx\\enemy-explosion.wav");

        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 500) {
                clip.setFramePosition(0);
                clip.start();
                lastTime = currentTime;
            }
        }
    }
}
