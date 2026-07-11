package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Phantom {
    public Vector2 position;
        public Rectangle bounds;
            public float speed = 90f;
                public boolean isAwake = false;

                    public Phantom(float startX, float startY) {
                            this.position = new Vector2(startX, startY);
                                    this.bounds = new Rectangle(startX, startY, 32, 32);
                                        }

                                            public void hunt(Vector2 targetPosition, float delta) {
                                                    if (isAwake) {
                                                                // Calculate direction vector toward the player, normalize it, and apply speed
                                                                            Vector2 direction = new Vector2(targetPosition).sub(position).nor();
                                                                                        position.add(direction.scl(speed * delta));
                                                                                                    bounds.setPosition(position.x, position.y);
                                                                                                            }
                                                                                                                }
                                                                                                                }
                                                                                                                