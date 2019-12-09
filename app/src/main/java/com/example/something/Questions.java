package com.example.something;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private static List<String> questions = new ArrayList<>();

    /*
    Questions() {
        questions[0] = "Be careful not to vacuum the  _________  when you clean";
        questions[1] = "I like my hot dogs with ketchup, relish, and ______";
        questions[2] = "One venti iced coffee with extra ______ please!";
        questions[3] = "BBQ at my house! Everyone’s invited, and it’s Bring Your Own ____.";
        questions[4] = "I like my donuts with extra ______ on them.";
        questions[5] = "______ is the best thing in the world!";
        questions[6] = "Today I went to the zoo and I saw a huge ________.";
        questions[7] = "I grabbed my _______ and put it into my bag.";
        questions[8] = "On Halloween, I saw people dress up in ________ costumes.";
        questions[9] = "I went to Disney World and saw Micky Mouse ________.";
        questions[10] = "Alex played my ________ all day long.";
        questions[11] = "I nearly fell off the ______ yesterday.";
    }
    */

    Questions() {
        questions.add(0, "Be careful not to vacuum the  _________  when you clean");
        questions.add(1, "I like my hot dogs with ketchup, relish, and ______");
        questions.add(2, "One venti iced coffee with extra ______ please!");
        questions.add(3, "BBQ at my house! Everyone’s invited, and it’s Bring Your Own ____.");
        questions.add(4, "I like my donuts with extra ______ on them.");
        questions.add(5, "______ is the best thing in the world!");
        questions.add(6, "Today I went to the zoo and I saw a huge ________.");
        questions.add(7, "I grabbed my _______ and put it into my bag.");
        questions.add(8, "On Halloween, I saw people dress up in ________ costumes.");
        questions.add(9, "I went to Disney World and saw Micky Mouse ________.");
        questions.add(10, "Alex played my ________ all day long.");
        questions.add(11, "I nearly fell off the ______ yesterday.");
    }

    //need to initialise all questions

    public static String randomQuestion() {
        Random r = new Random();
        final int rand = r.nextInt(questions.size() - 1);
        String randomQuestion = questions.get(rand);
        return randomQuestion;
    }
}
