package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ThreadDownload extends  Thread {

    private String pathFile;
    private String linkFile;

    //конструктор создание потока
    ThreadDownload(String link, String path){
        Thread thread = new Thread();
        this.pathFile = path;
        this.linkFile = link;
    }

    @Override
    public void run(){
        try {
            //Скачивание файла за счет запуска потока
            InputStream url = new URL(linkFile).openStream();
            Files.copy(url, Path.of(pathFile), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Скачивание завершено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
