package base.game;

import base.CoverGamePauseScene;
import base.CoverPlayScene;
import base.GameObject;
import base.KeyEventPress;
import base.scene.GameOverScene;
import base.scene.MenuScene;
import base.scene.SceneManager;
import base.scene.SceneStage1;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.setTitle("Game Tank");
        this.setResizable(false);
        this.addKeyEvent();
    }

    private void addKeyEvent() {

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = true;
                if (e.getKeyCode() == Settings.UP_BUTTON) {
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == Settings.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == Settings.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == Settings.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == Settings.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = true;
                }
                if (e.getKeyCode() == Settings.PAUSE_BUTTON) {
                    KeyEventPress.isPauseKeyPress = true;
                }
                if (e.getKeyCode() == Settings.RETURN_BUTTON) {
                    KeyEventPress.isReturnKeyPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (SceneManager.currentScene instanceof SceneStage1) {
                        if (GameObject.pause) {
                            CoverPlayScene.playClip();
                            CoverGamePauseScene.closeClip();
                            GameObject.pause = false;
                        } else {
                            CoverPlayScene.closeClip();
                            CoverGamePauseScene.playClip();
                            GameObject.pause = true;
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (SceneManager.currentScene instanceof GameOverScene) {
                        SceneManager.signNewScene(new MenuScene());
                    }
                }
            }
        });

    }
}
