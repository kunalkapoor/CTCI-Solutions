import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortRomanName {

	static HashMap<Character, Integer> romanToNumber = new HashMap<Character, Integer>();
	
	static Comparator<String> comparator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			String[] o1split = o1.split(" ");
			String[] o2split = o2.split(" ");

			int comp = o1split[0].compareTo(o2split[0]);
			if (comp < 0)
				return -1;
			else if (comp > 0)
				return 1;

			int num1 = convertToNumeral(o1split[1]);
			int num2 = convertToNumeral(o2split[1]);
			if (num1 < num2)
				return -1;
			else if (num1 > num2)
				return 1;
			
			return 0;
		}
	};
	
	static int convertToNumeral(String roman) {
		int currValue = 0, prevValue = 0, sum = 0;
		for (int i=0; i<roman.length(); i++) {
			currValue = romanToNumber.get(roman.charAt(i));
			if (prevValue < currValue)
				currValue -= prevValue;
			else
				sum += prevValue;
			prevValue = currValue;
		}
		sum += prevValue;
		return sum;
	}
	
	static void initializeMap() {
		romanToNumber.put('I', 1);
		romanToNumber.put('V', 5);
		romanToNumber.put('X', 10);
		romanToNumber.put('L', 50);
	}
	
	static String[] getSortedList(String[] names) {
		initializeMap();
		Arrays.sort(names, comparator);
		return names;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.asList(getSortedList(new String[] {
				"Philippe I",
				"Philip II"
		})));
	}
}
