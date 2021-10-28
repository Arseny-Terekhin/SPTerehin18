package com.company;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ThreadsFile  extends  Thread{
    private String pathFile;
    private String pathCopyFile;

    ThreadsFile(String pf, String pcf ){
        Thread thread = new Thread();
        this.pathFile = pf;
        this.pathCopyFile = pcf;
    }

    @Override
    public void run() {
        try {
        Path original = Paths.get(pathFile);
        Path copied = Paths.get(pathCopyFile);
        Files.copy(original, copied, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
