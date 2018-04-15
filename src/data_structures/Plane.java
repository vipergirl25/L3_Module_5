package data_structures;

import java.util.ArrayList;
import java.util.Random;

public class Plane {
	public static void main(String[] args) {
		int numberOfPassengers;
		numberOfPassengers = new Random().nextInt(150);
		int totalvenom = 0;
		int chanceofdeath = 0;
		ArrayList<Snake>snakes = new ArrayList<Snake>();
		Randomness r = new Randomness();
		for (int i = 0; i < 100; i++) {
			snakes.add(new Snake(r.randomtruefalse(), r.randomnumber()));
		}
		for (Snake snek : snakes) {
			if(snek.venemous==true) {
				totalvenom+=snek.viciousness;
			}else {
				
			}
		}
		chanceofdeath = (totalvenom*10)/numberOfPassengers;
		if(chanceofdeath>100) {
			chanceofdeath = 100;
		}else {
			
		}
		System.out.println("The chance of death is " + chanceofdeath + "%"
				+ "");
	}
}
