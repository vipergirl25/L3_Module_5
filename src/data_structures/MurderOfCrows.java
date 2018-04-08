package data_structures;


/** Copyright The League of Amazing Programmers 2013-2017
 *    Level 3
 *    A Murder of Crows
 *    Duration=.00
 *    Platform=Eclipse
 *    Type=Recipe
 *    Objectives=n/a
*/

import java.util.ArrayList;
import java.util.Random;

public class MurderOfCrows {
	int deathNumber=-1;

    ArrayList<Crow> theMurder = new ArrayList<Crow>();

    public static void main(String[] args) {
        MurderOfCrows murderOfCrows = new MurderOfCrows();
        murderOfCrows.initializeCrows();
        murderOfCrows.findTheDiamond();
    }

    private void findTheDiamond() {
        /*
         * 1. One of the Crows has eaten the diamond. You need to search through the stomach of each Crow, 
         * then print the name of the guilty Crow.
         */
    		for (Crow crow : theMurder) {
    				deathNumber++;
    				
    				ArrayList contents = crow.getStomachContents();
    				String name = crow.getName();
    			
    				for (Object object : contents) {
						if(object.equals("diamond")) {
							System.out.println(name + " TIME FOR EXECUTION");
							System.out.println("so " + deathNumber + " of you died bc u were in cahoots with the eater of the diamond");
							break;
						}else {
						}
					}
    			
			}
        
        /* 2. How many innocent crows had to die before the diamond was found? */
        
    }

    private void initializeCrows() {
        theMurder.add(new Crow("Dalia"));
        theMurder.add(new Crow("Joseph"));
        theMurder.add(new Crow("Matt bc he didn't like my game"));
        theMurder.add(new Crow("delaras typing record"));
        theMurder.add(new Crow("tampa haha bc newark beat u"));
        hideTheDiamond();
        
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++) {
            this.stomachContents.add(getRandomCrowFood());
        }
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }

}

