package hw_javacore2;

import java.io.*;
import java.util.Locale;

class BeatlesException extends Exception {
    public BeatlesException(String msg) {
        super("Beatles: " + msg);
    }
}

public class task4 {

    static void saveSongToFile(String filename, String song) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(song);
        }
    }

    static String readSongFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    static void verifyStringInSong(String song, String target) throws BeatlesException {
        if (!song.toLowerCase().contains(target.toLowerCase())) {
            throw new BeatlesException("The phrase: " + target + " was not found in the song :(");
        }
        System.out.println("Success! Found phrase: '" + target + "'");
    }

    public static void main(String[] args) throws IOException {
        task1 t1 = new task1();
        String lyrics = t1.yellowSubmarine;

        String filename = "yellow_submarine.txt";
        saveSongToFile(filename, lyrics);
        try {

        String loadedSong = readSongFromFile(filename);
        System.out.println("\n--- Song Loaded From File ---");
        System.out.println(loadedSong);

        System.out.println("--- Verifying Search Phrases ---");

        // Successful search
        verifyStringInSong(loadedSong, "yellow submarine");

        // Failed search (Triggers BeatlesException)
        verifyStringInSong(loadedSong, "Show must go on!");
        saveSongToFile(filename, lyrics);
        System.out.println("Song saved to " + filename);
        } catch (IOException e) {
            System.err.println("File I/O Error: " + e.getMessage());
        } catch (BeatlesException e) {
            System.err.println("Caught custom exception: " + e.getMessage());
        }

    }
}
