
public class UniqueString {
	public boolean uniqueString(String str, int N) {
		if(str == null || str.length() > N) return false;
		
		boolean[] charFound = new boolean[N];
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i);
			if(charFound[c])
				return false;
			charFound[c] = true;
		}
		return true;
	}
	
	public static void main(String args[]) {
		UniqueString us = new UniqueString();
		System.out.println(us.uniqueString("", 0));
	}
}
