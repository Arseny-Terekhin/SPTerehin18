package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fileThread thread1 = new fileThread("D:\\", "1.txt", "D:\\", "2.txt" );
        fileThread thread2 = new fileThread("D:\\", "11.txt","D:\\", "22.txt");
        thread1.start();
        thread2.start();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }
}
