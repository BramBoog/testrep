package miniopdrachten;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Miniopdrachten {
	public static void main(String[] args) {
		
//		new Miniopdrachten().opdracht1();
//		new Miniopdrachten().opdracht2("regenen");
//		
//		int[] testarr = {1, 2, 3, 4};
//		new Miniopdrachten().opdracht3(testarr);
//		
//		new Miniopdrachten().opdracht4(10);
//		
//		boolean[] testOnderdelen = {true, false, false, true};
//		new Miniopdrachten().opdracht5(testOnderdelen);
//		
//		new Miniopdrachten().opdracht6();
		
		int[] testArr = new int[4];
		for(int i=0; i<testArr.length; i++) {
			System.out.println(Arrays.toString(testArr));
		}
	}
	
	void opdracht1() {
		String str1 = "dop";
		String str2 = "erwt";
		String str3 = "en";
		String result = str1 + str2 + str3;
		System.out.println(result);
	}

	void opdracht2(String str) {
		int n=0;
		for(int x=0; x < str.length(); x++) {
			if(str.charAt(x)=='e') {
				n++;
			}
		}
		System.out.println(n);
	}
	
	void opdracht3(int[] getallen) {
		int sum=0;
		for(int x=0; x < getallen.length; x++) {
			sum += getallen[x];
		}
		System.out.println(sum);
	}
	
	void opdracht4(int maxVal) {
		int[] randArr = new int[10];
		for(int x=0; x < randArr.length; x++) {
			Random r = new Random();
			randArr[x] = r.nextInt(maxVal);
		}
		
		System.out.println("Array content: " + Arrays.toString(randArr));
		
		// sorteren
		int[] sortedArr = new int[10];
		
		for(int i=0; i < randArr.length; i++) {
			int indexSmallest = 0;
			int smallestVal = maxVal;
			
			for(int j=0; j < randArr.length; j++) {
				if(randArr[j] < smallestVal) {
					smallestVal = randArr[j];
					indexSmallest = j;
			}
			}
			sortedArr[i] = smallestVal;
			randArr[indexSmallest] = maxVal;
		}
		System.out.println("Sorted array: "+Arrays.toString(sortedArr));
	}
	
	void opdracht5(boolean[] onderdelenBools) {
		Auto auto1 = new Auto(onderdelenBools);
		auto1.statusOnderdelen();
		Monteur monteur1 = new Monteur();
		monteur1.repareren(auto1);
		auto1.statusOnderdelen();
	}
	
	void opdracht6() {
		System.out.println("Typ iets");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		System.out.println("Dit is de tekst: "+text);
		
		int charAmount = text.length();
		char[] charArr = text.toCharArray();
		char[] alphabeticalCharArr = new char[charAmount];
		boolean[] caseBoolArr = new boolean[charAmount];
		
		for(int i=0; i < charAmount; i++) {
			if(Character.isUpperCase(charArr[i])) {
				caseBoolArr[i] = true;
				char x = Character.toLowerCase(charArr[i]);
				charArr[i] = x;
			}
		}
		
		for(int i=0; i < charAmount; i++) {
			int indexSmallest = 0;
			char smallestVal = 'z';
			
			for(int j=0; j < charAmount; j++) {
				
				if(charArr[j] < smallestVal) {
					smallestVal = charArr[j];
					indexSmallest = j;
				}
			}
			
			if(caseBoolArr[indexSmallest] == true) {
				smallestVal = Character.toUpperCase(smallestVal);
			}
			
			alphabeticalCharArr[i] = smallestVal;
			charArr[indexSmallest] = 'z';
		}
		
		System.out.println("Dit is het in alfabetische volgorde: ");
		for(int i=0; i < charAmount; i++) {
			System.out.println(alphabeticalCharArr[i]);
		}
	}
	
	void opdracht7() {
		System.out.println("We gaan Lingo spelen!");
		String word = "fiets";
		System.out.println("_ _ _ _ _");
		Lingo lingo1 = new Lingo(word);
		boolean notFinished = true;
		while(notFinished) {
			int[] result = lingo1.userGuess();
			
		}
		
		
	}
	
}


// Opdracht 5 classes

class Monteur {
	
	void repareren(Auto auto) {
		int totalePrijs = 0;
		for(int i=0; i < auto.onderdelen.length; i++) {
			if(auto.onderdelen[i].kapot==true) {
				auto.onderdelen[i].kapot = false;
				totalePrijs += 25;
			}
		}
		System.out.println("Totale prijs: " + totalePrijs);
	}
}

class Onderdeel {
	boolean kapot;
	String naam;
	
	Onderdeel(String naam) {
		this.naam = naam;
	}
}

class Auto {
	
	Onderdeel[] onderdelen = {
			new Onderdeel("motor"),
			new Onderdeel("deur"),
			new Onderdeel("voorruit"),
			new Onderdeel("uitlaat"),
			};
	
	Auto(boolean[] onderdelenBools) {
		for(int i=0; i < onderdelenBools.length; i++) {
			this.onderdelen[i].kapot = onderdelenBools[i];
		}
	}
	
	void statusOnderdelen() {
		for(int i=0; i < onderdelen.length; i++) {
			if(onderdelen[i].kapot==true) {
				System.out.println("Status " + onderdelen[i].naam + ": " + "kapot.");
			}
			else {
				System.out.println("Status " + onderdelen[i].naam + ": " + "niet kapot.");
			}
		}
		
	}
}
	
	// Opdracht 7 classes

class Lingo {
	
	String word;
	
	Lingo(String word) {
		this.word = word.toLowerCase();
	}
	
	int[] userGuess() {
		Scanner sc = new Scanner(System.in);
		char[] wordCharArr = word.toCharArray();
		int wordLength = word.length();
		boolean invalidGuess = true;
		int[] resultIntArr = new int[wordLength];
		
		while(invalidGuess) {
			
			String guess = sc.next();
			guess.toLowerCase();
			
			if(guess.length() != wordLength) {
				System.out.println("Je gis was niet de goede lengte. Het woord is " + wordLength + "karakters lang. Probeer het nog eens.");
			}
			
			else {
				invalidGuess = false;
				char[] guessCharArr = guess.toCharArray();
				
				// Turn the Character Array of word into an ArrayList in order to use .contains later. 
				ArrayList<Character> wordCharArrLst = new ArrayList<Character>();
				for(int x=0; x < wordLength; x++) {
					wordCharArrLst.add(wordCharArr[x]);
				}
				
				for(int i=0; i < wordLength; i++) {
					
					int score = 0;
					if(wordCharArrLst.contains(guessCharArr[i])) {
						score = 1;
						if(guessCharArr[i] == wordCharArr[i]) {
							score = 2;
						}
					}
					resultIntArr[i] = score;
				}
				System.out.println(Arrays.toString(resultIntArr));
			}
		}
		return resultIntArr;
	}
}