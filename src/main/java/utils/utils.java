package utils;


import businessobjects.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.nio.file.Files.deleteIfExists;

public class utils {

    public static String getRandomString(int length) {
        final String neededChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(neededChars.charAt(rnd.nextInt(neededChars.length())));
        return sb.toString();
    }

    public static List<String> readLines(File file) throws Exception {
        if (!file.exists()) {
            return new ArrayList<String>();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> results = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            results.add(line);
            line = reader.readLine();
        }
        reader.close();
        return results;
    }

    public static void deleteFileFromDownloads(File file) throws IOException {
        Path path = Paths.get(System.getProperty("user.home") + "/Downloads/" + file.getName());
        deleteIfExists(path);
    }

}
