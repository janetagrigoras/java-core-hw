package hw_javacore2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        task1 t1 = new task1();
        String lyrics = t1.yellowSubmarine;

        String cleaned = t1.toLowercase(lyrics);
        String[] words = t1.convertToArray(cleaned);

        // convert to list
        List<String> wordsArray = new ArrayList<>(Arrays.stream(words).toList());
        System.out.println("\n--- Remove all world \"\"yellow\"\" and \"\"submarine\"\"\". Print the result. ---");
        wordsArray.removeAll(List.of("yellow", "submarine"));
        System.out.println(wordsArray);

    }
}
