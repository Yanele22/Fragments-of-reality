package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HelperNPC {
    public Vector2 position;
        public Rectangle bounds;
            public boolean hasGivenClue = false;

                public HelperNPC(float x, float y) {
                        this.position = new Vector2(x, y);
                                this.bounds = new Rectangle(x, y, 32, 32); // Interaction radius
                                    }

                                        public boolean canInteract(Rectangle playerBounds) {
                                                return this.bounds.overlaps(playerBounds) && !hasGivenClue;
                                                    }
                                                    }
                                                    package com.fragmentsofreality.entities;

                                                    import com.badlogic.gdx.math.Rectangle;
                                                    import com.badlogic.gdx.math.Vector2;

                                                    public class HelperNPC {
                                                        public Vector2 position;
                                                            public Rectangle bounds;
                                                                public boolean hasGivenClue = false;

                                                                    public HelperNPC(float x, float y) {
                                                                            this.position = new Vector2(x, y);
                                                                                    this.bounds = new Rectangle(x, y, 32, 32); // Interaction radius
                                                                                        }

                                                                                            public boolean canInteract(Rectangle playerBounds) {
                                                                                                    return this.bounds.overlaps(playerBounds) && !hasGivenClue;
                                                                                                        }
                                                                                                        }
                                                                                                        