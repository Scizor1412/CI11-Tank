package base.enemy;

import base.Action.Action;
import base.Action.ActionRepeat;
import base.Action.ActionWait;
import base.GameObject;
import base.Renderer.BoxRenderer;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class EnemySummoner extends GameObject implements Physics {
    BoxCollider boxCollider;
    Action actionSummon;

    public EnemySummoner() {
        this.boxCollider = new BoxCollider(this.position, 20, 40);
        this.position.set(-20, 10);
        this.renderer = new BoxRenderer(this.boxCollider, Color.WHITE, true);
        this.actionSummon = this.Summon();
    }

    private Action Summon() {
        Action summonEnemy = new Action() {

            @Override
            public boolean run(GameObject master) {
                Enemy enemy = GameObject.recycle(Enemy.class);
                enemy.position.set(master.position.add(20,0));
                return true;
            }

            @Override
            public void reset() {
            }
        };

        Action actionSummon = new ActionWait(120, summonEnemy);
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
