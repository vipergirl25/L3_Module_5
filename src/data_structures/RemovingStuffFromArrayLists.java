package data_structures;

import java.util.ArrayList;

/**
 * Copyright The League of Amazing Programmers 2013-2017 Level 3 Two ArrayList
 * Cleaning Exercises Duration=.00 Platform=Eclipse Type=Recipe Objectives=
 */

public class RemovingStuffFromArrayLists {

	public static void main(String[] args) {

		class Stuff {
		}
		class Worm extends Stuff {
		}
		class Dirt extends Stuff {
		}
		ArrayList<Stuff> stuffIFoundInTheYard = new ArrayList<Stuff>();
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());

		System.out.println(stuffIFoundInTheYard.size());
		ArrayList<Stuff>stuffintheyard2 = new ArrayList<Stuff>();

		/* TODO 1: Clean out the dirt but keep the delicious worms. */
		for (Stuff stuff : stuffIFoundInTheYard) {
			if(stuff instanceof Dirt) {
				
			}else {
				System.out.println("hey dalia u censored my bunny");
				stuffintheyard2.add(stuff);
			}
		}
		stuffIFoundInTheYard = stuffintheyard2;

		System.out.println(stuffIFoundInTheYard.size()); // should be 2

		ArrayList<Character> truth = new ArrayList<Character>();
		truth.add('#');
		truth.add('s');
		truth.add('u');
		truth.add('#');
		truth.add('n');
		truth.add('s');
		truth.add(' ');
		truth.add('#');
		truth.add('o');
		truth.add('u');
		truth.add('#');
		truth.add('t');
		truth.add('#');
		truth.add(' ');
		truth.add('g');
		truth.add('#');
		truth.add('n');
		truth.add('s');
		truth.add('#');
		truth.add(' ');
		truth.add('o');
		truth.add('#');
		truth.add('u');
		truth.add('t');
		
		ArrayList<Character> decodedtruth = new ArrayList<Character>();

		/* TODO 2: Remove the hash symbols and print out the truth. */
		for (Character character : truth) {
			if(character.equals('#') || character.equals(' ')) {
			
			}else {
				decodedtruth.add(character);
			}
		}
		truth = decodedtruth;
		String truthstring = truth.toString();
		System.out.println(truthstring);
	}
}
