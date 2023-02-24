package org.example;

public class StringCount {


    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";

        String[] words = input.split("\\s+");

        int count = words.length;

        System.out.println("Number of words: " + count);
    }
}

