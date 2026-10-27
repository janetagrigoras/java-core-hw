package hw_javacore2;

import java.util.*;

public class task2 {
    public static void main(String[] args) {
        task1 t1 = new task1();
        String lyrics = t1.yellowSubmarine;

        String cleaned = t1.toLowercase(lyrics);
        String[] words = t1.convertToArray(cleaned);

        // convert to list
        List<String> w = Arrays.stream(words).toList();

        System.out.println("--- Use collections to count the words. ---");
        Set<String> uniqueWords = new HashSet<>(w);
        for (String word : uniqueWords) {
            int count = Collections.frequency(w, word);
            System.out.println(word + ": " + count);
        }

        System.out.println("\n--- Remove all duplicate words from the song and print to console. ---");
        System.out.println(uniqueWords);

        System.out.println("\n--- Sort song words by String length. ---");
        List<String> sortedWords = new ArrayList<>(uniqueWords);
        sortedWords.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(sortedWords);
    }
}
