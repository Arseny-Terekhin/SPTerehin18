package com.company;

import java.sql.Time;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	ChickenEggThread chicken = new ChickenEggThread("Курица");
	ChickenEggThread egg = new ChickenEggThread("Яйцо");
	chicken.start();
	egg.start();
	String win;
	while (true){
		if (chicken.isAlive() == false && egg.isAlive() == true){

			win = "выйграло яйцо";
			break;
		}
		if ((chicken.isAlive() == true) && (egg.isAlive() == false)){
			win = "выйграла курица";
			break;
		}
	}
	chicken.join();
	egg.join();
	System.out.println(win);
    }

}
