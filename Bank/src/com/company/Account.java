package com.company;

import java.util.Scanner;

public class Account  extends Thread{

    private int balance;
    private int pinCode;
    private int testPinCode;
    public Scanner in = new Scanner(System.in);

    Account(int b, int pin){
        Thread thread = new Thread();
        this.balance = b;
        this.pinCode = pin;
    }

    public void run(){
        while (true){
            System.out.println("Введите пин-код");
            testPinCode = in.nextInt();
            if (pinCode == testPinCode){
                while (true){
                    System.out.println("если вы хотите пополнить баланс введите 1");
                    System.out.println("если вы хотите снять деньги введите 2");
                    System.out.println("если вы хотите узнать баланс введите 3");
                    int choice = in.nextInt();
                    while((3 < choice) || (choice < 1)){
                        System.out.println("не верно введена команда, введите еще раз");
                        choice = in.nextInt();
                    }
                    if (choice == 1){
                        topUpBalance();
                    }

                    if(choice == 2){
                        takeOffBalance();
                    }

                    if (choice == 3){
                        System.out.println("ваш баланс состовляет " + balance);
                    }
                    System.out.println("Если вы хотите выйти нажмите 1");
                    System.out.println("Если вы хотите продолжить нажмите 2");
                    int choiceTwo = in.nextInt();
                    while ((2 < choice) || (choice < 1)){
                        System.out.println("не верно введена команда, введите еще раз");
                        choiceTwo = in.nextInt();
                    }
                    if (choiceTwo == 1){
                        break;
                    }
                    if (choiceTwo == 2){
                        continue;
                    }
                }
            }else{
                System.out.println("Пин-код не верный");
                break;
            }
            break;

        }

    }

    private void topUpBalance(){
        System.out.println("Введите сумму для пополнения баланса");
        int tooUp = in.nextInt();
        balance += tooUp;
        System.out.println("баланс пополнен на сумму " + tooUp);
    }

    private void takeOffBalance(){
        System.out.println("Введите сумму, котрую хотите вы снять с баланса");
        int takeOff = in.nextInt();
        while (balance < takeOff){
            System.out.println("На вашем счету не достаточно средств, введите другуб сумму");
            takeOff = in.nextInt();
        }
        balance -= takeOff;
        System.out.println("С бвлвнсв снятв сумма в размер " + takeOff);
    }


}
