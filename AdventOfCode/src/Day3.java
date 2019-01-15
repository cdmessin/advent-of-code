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
		s.close();
	}
	
	private static void processLine(String line, int[][] fabric) {
		Scanner lineScanner = new Scanner(line);
		//Gets rid of ID
		lineScanner.nextInt();
		int startRow = lineScanner.nextInt();
		int startColumn = lineScanner.nextInt();
		int endColumn = startColumn + lineScanner.nextInt();
		int endRow = startRow + lineScanner.nextInt();
		
		for(int i = startRow; i <= endRow; i++) {
			for(int j = startColumn; j <= endColumn; j++) {
				if(fabric[i][j] == 0) {
					fabric[i][j] = 1;
				} else if (fabric[i][j] == 1){
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
