package com.limbo.exam.wordcounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Break.D on 7/28/16.
 */
public class WordCounter {

    public static void main(String[] args) {

        String filename = System.getProperty("user.dir") + "/src/com/limbo/dp/excercise/WordCounter.java";
        String word = "String";

        System.out.println(new WordCounter().wordCounter(filename, word));

    }

    public int wordCounter(String filename, String word) {

        int counter = 0;

        try (
                FileReader in = new FileReader(filename);
                BufferedReader reader = new BufferedReader(in);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                int index = 0;
                while (line.length() > 0 && (index = line.indexOf(word)) >= 0) {
                    counter++;
                    line = line.substring(index + word.length());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return counter;

    }
}
