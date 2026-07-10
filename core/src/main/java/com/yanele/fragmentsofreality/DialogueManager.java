package com.yanele.fragmentsofreality;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.Random;

public class DialogueManager {

    private final Json json;
    private JsonValue riddles;
    private JsonValue memories;

    private final Random random;

    public DialogueManager() {
        json = new Json();
        random = new Random();

        loadFiles();
    }

    private void loadFiles() {

        FileHandle riddlesFile =
            Gdx.files.internal("config/riddles.json");

        FileHandle memoriesFile =
            Gdx.files.internal("config/memories.json");

        riddles = json.fromJson(JsonValue.class, riddlesFile);

        memories = json.fromJson(JsonValue.class, memoriesFile);

    }


     // Returns one random riddle from a room.

    public JsonValue getRandomRiddle(int room) {

        JsonValue roomRiddles =
            riddles.get("room" + room);

        if (roomRiddles == null)
            return null;

        int index =
            random.nextInt(roomRiddles.size);

        return roomRiddles.get(index);

    }

      //Checks if the selected answer is correct.

    public boolean checkAnswer(JsonValue question,
                               int selectedAnswer) {

        int correct =
            question.getInt("answer");

        return selectedAnswer == correct;

    }


     //Returns the memory story.

    public String getMemoryStory(int room) {

        JsonValue memory =
            memories.get("room" + room);

        return memory.getString("story");

    }


      //Returns the room title.

    public String getMemoryTitle(int room) {

        JsonValue memory =
            memories.get("room" + room);

        return memory.getString("title");

    }

}
