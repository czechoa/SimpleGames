package org.snake;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    public static List<String> readerFile(String path){
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;

    }
}
