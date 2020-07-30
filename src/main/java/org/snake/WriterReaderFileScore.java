package org.snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface WriterReaderFileScore {
    static void write(String string) {
        try {
            File file = loadFileFromResources();

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(string);
            bw.close();
        } catch (Exception ignored) {
        }
    }

    static ObservableList<Score> read() {
        ObservableList<Score> list = FXCollections.observableArrayList();
        try {
            File file = loadFileFromResources();

            FileReader fw = new FileReader(file);
            BufferedReader bw = new BufferedReader(fw);

            String oneLine;
            while ((oneLine = bw.readLine()) != null) {
                String[] w = oneLine.split("\\s+");
                try {
                    list.add(new Score(w[0], w[1] + " " + w[2]));
                } catch (Exception ignored) {

                }
            }
        } catch (Exception ignored) {
        }

        return list;
    }

    private static File loadFileFromResources() {
        String path = "results";

        ClassLoader classLoader = WriterReaderFileScore.class.getClassLoader();

        return new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
    }
}
