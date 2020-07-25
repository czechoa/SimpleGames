package org.snake.game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

public class WriterScore {
    public static void write(String string) {
        String path = "results";
        try {
            ClassLoader classLoader = new WriterScore().getClass().getClassLoader();

            File file = new File(classLoader.getResource(path).getFile());

            //File is found
            System.out.println("File Found : " + file.exists());

            FileWriter fw = new FileWriter(file.getPath());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("These text will be written at the end line of file");
            bw.write("trala");
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
