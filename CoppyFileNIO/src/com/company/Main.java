package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ThreadsFile copy = new ThreadsFile("D:\\1.txt", "D:\\2.txt");
        ThreadsFile copyTwo = new ThreadsFile("D:\\11.txt", "D:\\22.txt");
        copy.start();
        copyTwo.start();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Параллельное " + elapsed);



        try {
            start = System.currentTimeMillis();
            Path original = Paths.get("D:\\3.txt");
            Path copied = Paths.get("D:\\33.txt");
            Files.copy(original, copied, StandardCopyOption.REPLACE_EXISTING);

            Path original1 = Paths.get("D:\\4.txt");
            Path copied1 = Paths.get("D:\\44.txt");
            Files.copy(original1, copied1, StandardCopyOption.REPLACE_EXISTING);
            finish = System.currentTimeMillis();
            elapsed = finish - start;
            System.out.println("Последовательное " + elapsed);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
