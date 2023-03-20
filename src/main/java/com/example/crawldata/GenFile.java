package com.example.crawldata;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;

public class GenFile {
    public void genFile(List<Data> lst) {
        String file = "data.csv";
        try {
            File f = new File(file);
            FileWriter fw = new FileWriter(file);
            for (Data e : lst) {
                fw.append(e.getTitle()).append("\t")
                        .append(e.getContent()).append("\n");
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
