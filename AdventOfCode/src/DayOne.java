import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DayOne {
	public static int[] data;
	
	public static void main(String[] args) {
//		System.out.println(dayOneOne());
		dayOneTwo();

	}
	
//	private static int dayOneOne() {
//		int sum = 0;
//		Scanner s = null;
//		try {
//			s = new Scanner(new File("test-files/input.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		int i = 0;
//		while (s.hasNextInt()) {
//			int temp = s.nextInt();
//			sum += temp;
//			data[i] = temp;
//			i++;
//		}
//		return sum;
//	}
	
	private static void dayOneTwo() {
		int sum = 0;
		ArrayList<Integer> changes = new ArrayList<Integer>();
		Scanner s = null;
		try {
			s = new Scanner(new File("test-files/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (s.hasNextInt()) {
			changes.add(s.nextInt());
		}
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		boolean found = false;
		while(!found) {
			for(int i = 0; i <= changes.size() - 1; i++) {
				sum += changes.get(i);
				System.out.println(sum);
				if(frequencies.contains(sum)) {
					System.out.println(changes.get(i));
					found = true;
					break;
				}
				frequencies.add(sum);

			}
		}
	}
}