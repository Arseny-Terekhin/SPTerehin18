package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {


        System.out.println( "Введите количество денег на вашем счету в доларах");
        Scanner in = new Scanner(System.in);
        int dolar = in.nextInt();
        log.info("Ввод суммы денег находящиеся на банковском счету");
        System.out.println("если вы хотите перевести деньги в рубли нажмите 1. Курс составляетс 1 долар = 65 рублям");
        System.out.println("если вы хотите перевести в биткоин нажмите 2. Курс 1 биткоина составляет 58906 доларов");
        int x = in.nextInt();
        if (x == 1){
            log.info("перевод в рубли");
            int rub = dolar * 65;
            log.info("перевод завершен");
            System.out.println(dolar + "доларов" + " = " + rub + "рублей");
        }

        if (x == 2){
            log.info("перевод в биткоин");
            float bit = dolar / 58906;
            log.info("перевод завершен");
            System.out.println(dolar + "доларов" + " = " + bit + "биткоинов");
        }
    }
}
