package org.snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WriterReaderFileScore {
    public static void write(String string) {
        try {
            File file = loadFileFromResources();

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(string);
            bw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static ArrayList<String> read() {
        ArrayList<String> list = new ArrayList<>();
        try {
            File file =  loadFileFromResources();

            FileReader fw = new FileReader(file);
            BufferedReader bw = new BufferedReader(fw);

            String string;
            while ((string = bw.readLine()) != null) {
                list.add(string);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }
    public static ObservableList<Score> read_1() {
        ObservableList<Score> list = FXCollections.observableArrayList();
        try {
            File file =  loadFileFromResources();

            FileReader fw = new FileReader(file);
            BufferedReader bw = new BufferedReader(fw);

            String oneLine;
            while ((oneLine = bw.readLine()) != null) {
                String[] w = oneLine.split("\\s+");
                try {
                    System.out.printf(w[0]);
                    list.add(new Score(w[0],w[1] +" "+ w[2]));
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }

    private static File loadFileFromResources() {
        String path = "results";

        ClassLoader classLoader = WriterReaderFileScore.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
        System.out.println(file.getPath());

        //File is found
        System.out.println("File Found : " + file.exists());
        return file;
    }
}
