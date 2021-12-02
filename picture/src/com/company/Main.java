package com.company;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {

    private static final String path = "src\\com\\company\\file.txt";
    private static final String picture = "src\\com\\company\\p.mp3";

    public static void main(String[] args) throws IOException {

        BufferedReader inFile = new BufferedReader(new FileReader(path));
        String s;
        while ((s = inFile.readLine()) != null){
            InputStream url = new URL(s).openStream();
            Files.copy(url, Path.of(picture), StandardCopyOption.REPLACE_EXISTING);
        }

    }
}
