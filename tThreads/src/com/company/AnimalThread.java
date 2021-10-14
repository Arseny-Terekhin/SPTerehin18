package com.company;

public class AnimalThread extends  Thread{
    String animalName;
    int priority;
    int i;
    AnimalThread(String name, int prior){
        Thread animal = new Thread(this.animalName = name);
        animal.setPriority(this.priority = prior);
    }

    @Override
    public void run(){
        int time = 10;
        for (i = 1; i <= 100; i++){
            try{
                Thread.sleep(time);
                System.out.println(animalName + " преодолел " + i + " метров ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(animalName + "финишировал-");
    }
}
