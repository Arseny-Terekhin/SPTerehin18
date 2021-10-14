package com.company;

public class RabbitAndTurtle {

    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("rabbit", 5);
        AnimalThread turtle = new AnimalThread("turtle", 7);
        rabbit.start();
        turtle.start();

    }

}
