package org.snake;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface WriterReaderFileScore {

    String fileName = "result";
    static void write(String string) {
        try {
            File file = new File(fileName);
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
            BufferedReader bw = new BufferedReader(new FileReader(fileName));
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

}
