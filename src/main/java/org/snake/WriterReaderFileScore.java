package org.snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

public class WriterReaderFileScore {
    public static void write(String string) {
        String path = "results";
        try {
            ClassLoader classLoader = WriterReaderFileScore.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
            System.out.println(file.getPath());

            //File is found
            System.out.println("File Found : " + file.exists());

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(string);
            bw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static ArrayList<String> read() {
        String path = "results";
        ArrayList<String> list = new ArrayList<>();

        try {
            ClassLoader classLoader = WriterReaderFileScore.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
            System.out.println(file.getPath());

            //File is found
            System.out.println("File Found : " + file.exists());

            FileReader fw = new FileReader(file);
            BufferedReader bw = new BufferedReader(fw);

            String string;
            while ((string = bw.readLine()) != null){
                list.add(string);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }
}
