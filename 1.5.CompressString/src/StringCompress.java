
public class StringCompress {

	public String compress(String str) {
		if (str == null || str.isEmpty())
			return str;

		StringBuffer sb = new StringBuffer();
		char repChar = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == repChar)
				count++;
			else {
				sb.append(repChar + "" + count);
				repChar = currChar;
				count = 1;
				if (sb.length() >= str.length())
					break;
			}
		}

		if (sb.length() + 2 >= str.length())
			return str;
		sb.append(repChar + "" + count);
		return sb.toString();
	}

	public static void main(String args[]) {
		StringCompress sc = new StringCompress();
		System.out.println(sc.compress("aabccccaa"));
	}
}
