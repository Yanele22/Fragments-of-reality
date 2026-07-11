package com.fragmentsofreality.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.util.Random;

public class DialogueManager {
    private JsonValue riddles;
    private JsonValue memories;
    private final Random random;

    public DialogueManager() {
        random = new Random();
        loadFiles();
    }

    private void loadFiles() {
        FileHandle riddlesFile = Gdx.files.internal("config/riddles.json");
        FileHandle memoriesFile = Gdx.files.internal("config/memories.json");

        JsonReader reader = new JsonReader();
        riddles = reader.parse(riddlesFile);
        memories = reader.parse(memoriesFile);
    }

    public JsonValue getRandomRiddle(int room) {
        JsonValue roomRiddles = riddles.get("room" + room);
        if (roomRiddles == null) return null;
        int index = random.nextInt(roomRiddles.size);
        return roomRiddles.get(index);
    }

    public boolean checkAnswer(JsonValue question, int selectedAnswer) {
        int correct = question.getInt("answer");
        return selectedAnswer == correct;
    }

    public String getMemoryStory(int room) {
        JsonValue memory = memories.get("room" + room);
        return memory.getString("story");
    }

    public String getMemoryTitle(int room) {
        JsonValue memory = memories.get("room" + room);
        return memory.getString("title");
    }
}
