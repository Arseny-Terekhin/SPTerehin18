package com.company;

import javax.imageio.IIOException;
import java.io.*;

public class fileThread extends Thread{
    String pathFileOne;
    String nameFileOne;
    String pathFileTwo;
    String nameFileTwo;
    fileThread(String p, String f, String p2, String f2){
        Thread thread = new Thread();
        this.pathFileOne = p;
        this.nameFileOne = f;
        this.pathFileTwo = p2;
        this.nameFileTwo = f2;
    }

    @Override
    public void run(){
        try {
            File fileOne = new File(pathFileOne, nameFileOne);
            BufferedReader readFile = new BufferedReader(new FileReader(fileOne));
            File fileTwo = new File(pathFileTwo, nameFileTwo);
            BufferedWriter writFile = new BufferedWriter(new FileWriter(fileTwo));
            String s;
            while (((s = readFile.readLine()) != null)) {
                writFile.write(s + "\n");
                writFile.flush();

            }
        }catch (IOException e){
            System.out.println("fale");
        }
    }

}
