package com.fragmentsofreality.data;


//  Represents one recovered memory.

public class MemoryFragment {

    private String title;
    private String story;

    // Required for libGDX Json
    public MemoryFragment() {
    }

    public MemoryFragment(String title, String story) {
        this.title = title;
        this.story = story;
    }

    public String getTitle() {
        return title;
    }

    public String getStory() {
        return story;
    }

    @Override
    public String toString() {
        return title;
    }
}
