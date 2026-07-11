package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.fragmentsofreality.systems.CollisionSystem;
import java.util.List;

public class Player {
    public Vector2 position;
    public Rectangle bounds;
    public float speed = 200f;

    public Player(float startX, float startY) {
        this.position = new Vector2(startX, startY);
        this.bounds = new Rectangle(startX, startY, 28, 28);
    }

    public void update(float delta, float dirX, float dirY, List<Rectangle> walls) {
        float stepX = dirX * speed * delta;
        float stepY = dirY * speed * delta;

        Rectangle nextX = new Rectangle(position.x + stepX, position.y, bounds.width, bounds.height);
        if (!CollisionSystem.isColliding(nextX, walls)) {
            position.x += stepX;
        }

        Rectangle nextY = new Rectangle(position.x, position.y + stepY, bounds.width, bounds.height);
        if (!CollisionSystem.isColliding(nextY, walls)) {
            position.y += stepY;
        }

        bounds.setPosition(position.x, position.y);
    }
}
