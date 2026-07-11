package com.fragmentsofreality.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents a non-playable character (NPC) that can provide a one-time clue to the player.
 * This class manages its own position, interaction bounds, and state.
 */
public class HelperNPC {

    // --- Fields are private to protect them from outside modification ---
    private final Vector2 position;
    private final Rectangle interactionBounds;
    private boolean hasGivenClue;

    /**
     * Constructs a new HelperNPC at a specific location.
     * @param x The horizontal position of the NPC.
     * @param y The vertical position of the NPC.
     */
    public HelperNPC(float x, float y) {
        this.position = new Vector2(x, y);
        // The interaction bounds are centered on the NPC's position.
        // Assuming the (x, y) is the center, we offset by half the width/height.
        this.interactionBounds = new Rectangle(x - 16, y - 16, 32, 32);
        this.hasGivenClue = false;
    }

    /**
     * Checks if the player is within the interaction radius and the clue has not been given yet.
     * @param playerBounds The Rectangle representing the player's bounds.
     * @return true if interaction is possible, false otherwise.
     */
    public boolean canInteract(Rectangle playerBounds) {
        // The check is more readable and the logic is clear.
        return !hasGivenClue && interactionBounds.overlaps(playerBounds);
    }

    /**
     * Call this method when the NPC gives the clue to the player.
     * This updates the NPC's state so it cannot give the clue again.
     */
    public void giveClue() {
        this.hasGivenClue = true;
        // You could also add logic here to display a message, play a sound, etc.
        System.out.println("NPC says: 'Be wary of the shadows in the east!'");
    }

    // --- Public "Getters" to allow other classes to safely read the NPC's data ---

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getInteractionBounds() {
        return interactionBounds;
    }

    public boolean hasGivenClue() {
        return hasGivenClue;
    }
}
