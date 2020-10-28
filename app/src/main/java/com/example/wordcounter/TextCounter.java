package com.example.wordcounter;

public class TextCounter {
    public static int getCharsCount(String text){
        return text.length();
    }

    public static int getWordsCount(String text){
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }
}
