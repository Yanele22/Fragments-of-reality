package com.fragmentsofreality.data;

import java.util.List;


//  Represents a single riddle question.

public class Question {

    private String question;
    private List<String> choices;
    private int answer;

    // Required for libGDX Json
    public Question() {
    }

    public Question(String question, List<String> choices, int answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return question;
    }
}
