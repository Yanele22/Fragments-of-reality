package com.fragmentsofreality.systems;

import com.badlogic.gdx.math.Rectangle;
import java.util.List;

public class CollisionSystem {

    public static boolean isColliding(Rectangle nextPosition, List<Rectangle> walls) {
        for (Rectangle wall : walls) {
            if (nextPosition.overlaps(wall)) {
                return true;
            }
        }
        return false;
    }
}
