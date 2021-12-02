package com.company;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.*;

public class Main {

    private static final String pathFile = "src\\com\\company\\inFile.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader inFile = new BufferedReader(new FileReader(pathFile));//Создание обьекта файла с которого будет считываться сфлка и путь
        String s;
        ThreadDownload thread = null;
        //считывание одной строки из файла
        while ((s = inFile.readLine()) != null) {
            //Разделение строки ссылка путь на отдельные строчные значения
            String[] arrayLinkAndPath = s.split(" ");
            thread = new ThreadDownload(arrayLinkAndPath[0], arrayLinkAndPath[1]);//Запуск потока
            thread.start();
        }
        thread.join();//Ожидание окончания потока

        System.out.println("Начало воспроизведения музыки");

        //Воспроизведение скаченной музыки
        try (FileInputStream inputStream = new FileInputStream("src\\com\\company\\music.mp3")) {//Поиск музыки
            try {
                Player player = new Player(inputStream);//запуск потока плэйера
                player.play();//начать воспроизведение
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
