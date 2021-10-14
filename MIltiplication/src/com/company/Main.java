package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            File File_Multiplication = new File("D:\\", "1.txt");
            BufferedReader Reader = new BufferedReader(new FileReader(File_Multiplication));
            String s;
            while ((s = Reader.readLine()) != null){
                StringScan Scanner = new StringScan(s);
                int[] mas_num = Scanner.Reg();
                Multiplication Multiplication_Numbers = new Multiplication(mas_num[0], mas_num[1]);
                int num = Multiplication_Numbers.Multi();
                System.out.println(num);
               }
        }
        catch(IOException ex){
                ex.printStackTrace();
            }
    }
}
