package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Rectangle bounds;
    public float speed = 200f;

    public Player(float startX, float startY) {
        this.position = new Vector2(startX, startY);
        this.bounds = new Rectangle(startX, startY, 32, 32);
    }

    public void update(float delta, float dirX, float dirY) {
        // Move position based on input vectors
        position.add(dirX * speed * delta, dirY * speed * delta);
        // Sync collision box to new position
        bounds.setPosition(position.x, position.y);
    }
}