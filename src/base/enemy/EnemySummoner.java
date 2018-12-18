package base.enemy;

import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionWait;
import base.GameObject;
import base.game.Settings;
import base.renderer.BoxRenderer;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;
import java.util.ArrayList;

public class EnemySummoner extends GameObject implements Physics {
    BoxCollider boxCollider;
    Action actionSummon;

    public EnemySummoner() {
        this.anchor.set(0,0);
        this.boxCollider = new BoxCollider(this.position, this.anchor,20, 40);
        this.actionSummon = this.Summon();
    }

    private Action Summon() {
        Action summonEnemy = new Action() {

            @Override
            public boolean run(GameObject master) {
                Enemy enemy = GameObject.recycle(Enemy.class);
                enemy.position.set(master.position.add(20 + Settings.WAY_SIZE/2,0+Settings.WAY_SIZE/2));
                enemy.direction = (int) (Math.random()*4 +1);
                return true;
            }

            @Override
            public void reset() {
            }
        };

        Action actionSummon = new ActionWait(600, summonEnemy);
        Action actionSummonEnemy = new ActionRepeat(actionSummon);
        return actionSummonEnemy;
    }

    @Override
    public void run() {
        super.run();
        this.actionSummon.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
