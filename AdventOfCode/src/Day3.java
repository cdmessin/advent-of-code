import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
	
	public static int duplicateCount = 0;

	public static void main(String[] args) {
		int[][] fabric = new int[1000][1000];
		Scanner s = null;
		try {
			s = new Scanner(new File("test-files/input-3.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextLine()) {
			processLine(s.nextLine(), fabric);
		}
		System.out.println(duplicateCount);
		//130452 is too high.
		s.close();
	}
	
	private static void processLine(String line, int[][] fabric) {
		Scanner lineScanner = new Scanner(line);
		//Gets rid of ID
		lineScanner.next();
		//Removes the @ sign
		lineScanner.next();
		lineScanner.useDelimiter(",");
		int startColumn = Integer.parseInt(lineScanner.next().trim());
		lineScanner.useDelimiter(":");
		String secondNumber = lineScanner.next();
		int startRow = Integer.parseInt(secondNumber .substring(1, secondNumber.length()));
		lineScanner.useDelimiter(" ");
		//gets rid of anything before the next number
		lineScanner.next();
		lineScanner.useDelimiter("x");
		int endColumn = startColumn + Integer.parseInt(lineScanner.next().trim());
		int endRow = startRow + Integer.parseInt(lineScanner.next().trim());
//		System.out.println("Start Column: " + startColumn);
//		System.out.println(startRow);
//		System.out.println(endColumn);
//		System.out.println(endRow);

		for(int i = startRow; i <= endRow - 1; i++) {
			for(int j = startColumn; j <= endColumn - 1; j++) {
				boolean notFirst = true;
				if(fabric[i][j] == 0) {
					fabric[i][j] = 1;
					notFirst = false;
				} else if (fabric[i][j] == 1 && notFirst){
					duplicateCount++;
					fabric[i][j] = fabric[i][j] + 1;
				} else {
					fabric[i][j] = fabric[i][j] + 1;
				}
			}			
		}
		lineScanner.close();
	}

}
