import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
	
//	abcdef contains no letters that appear exactly two or three times.
//	bababc contains two a and three b, so it counts for both.
//	abbcde contains two b, but no letter appears exactly three times.
//	abcccd contains three c, but no letter appears exactly two times.
//	aabcdd contains two a and two d, but it only counts once.
//	abcdee contains two e.
//	ababab contains three a and three b, but it only counts once.
	
//	Of these box IDs, four of them contain a letter which appears exactly twice, and three of them contain a letter which appears exactly three times.
//	Multiplying these together produces a checksum of 4 * 3 = 12.

	public static void main(String[] args) {
		partOne();
		partTwo();
	}

	public static void partOne() {
		Scanner s = null;
		try {
			s = new Scanner(new File("test-files/input-2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[] finalCount = new int[2];
		int[] letterCount;
		while (s.hasNextLine()) {
			letterCount = new int[27];
			String line = s.nextLine();
			for(int i = 0; i <= line.length() - 1; i++) {
				//System.out.println(Character.getNumericValue(line.charAt(i)));
				letterCount[Character.getNumericValue(line.charAt(i)) - 10] += 1;
			}
			boolean twoFound = false;
			boolean threeFound = false;
			for(int i = 0; i <= 26; i++) {
				if((letterCount[i] == 2) && !twoFound) {
					finalCount[0] += 1;
					twoFound = true;
				}
				if((letterCount[i] == 3) && !threeFound) {
					finalCount[1] += 1;
					threeFound = true;
				}
			}
		}
		System.out.println("Two: " + finalCount[0]);
		System.out.println("Three: " + finalCount[1]);
		System.out.println(finalCount[0] * finalCount[1]);

	}
	
//	The IDs abcde and axcye are close, but they differ by two characters (the second and fourth). 
//	However, the IDs fghij and fguij differ by exactly one character, the third (h and u). Those must be the correct boxes.
//	What letters are common between the two correct box IDs?
//	(In the example above, this is found by removing the differing character from either ID, producing fgij.)
	public static void partTwo() {
		Scanner s = null;
		try {
			s = new Scanner(new File("test-files/input-2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> words = new ArrayList<String>();
//		int[] similarityCount;
		words.add(s.nextLine());
		while (s.hasNextLine()) {
			String currentLine = s.nextLine();
			words.add(currentLine);
			//Checks against every word already in the array.
			for(int k = words.size() - 1; k >= 0; k--) {
				int diffCount = currentLine.length();
				//For each word, goes through each letter and sees if they are the same.
				for(int j = 0; j <= currentLine.length() - 1; j++) {
					if(currentLine.charAt(j) == words.get(k).charAt(j)) {
						diffCount--;
					}
				}
				if(diffCount == 1) {
					System.out.println(currentLine);
					System.out.println(words.get(k));
				}
			}

		}
	}
}


