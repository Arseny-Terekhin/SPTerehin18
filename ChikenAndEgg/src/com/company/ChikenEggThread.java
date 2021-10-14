package com.company;

class ChickenEggThread extends Thread{
    String animalName;
    int i;
    ChickenEggThread(String name){
        Thread thread = new Thread(this.animalName = name);
    }

    @Override
    public void run(){
        int time = 10;
        for (i = 1; i <= 10; i++){
            try{
                Thread.sleep(time);
                System.out.println(animalName);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
