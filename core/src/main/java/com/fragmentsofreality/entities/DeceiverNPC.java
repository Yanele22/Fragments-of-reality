package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class DeceiverNPC {
    public Vector2 position;
        public Rectangle bounds;
            public boolean hasLied = false;

                public DeceiverNPC(float x, float y) {
                        this.position = new Vector2(x, y);
                                this.bounds = new Rectangle(x, y, 32, 32);
                                    }

                                        public boolean canInteract(Rectangle playerBounds) {
                                                return this.bounds.overlaps(playerBounds) && !hasLied;
                                                    }
                                                    }
                                                    