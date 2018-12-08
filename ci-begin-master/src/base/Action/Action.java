package base.Action;

import base.GameObject;

public interface Action {
    abstract boolean run(GameObject master);
    abstract void reset();
}