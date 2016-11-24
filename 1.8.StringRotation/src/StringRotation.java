
public class StringRotation {
	public boolean isRotation(String s1, String s2)
	{
		String s3 = s1 + s1;
		return isSubstring(s3, s2);
	}
	
	public boolean isSubstring(String s1, String s2)
	{
		return s1.contains(s2);
	}
	
	public static void main(String args[])
	{
		System.out.println(new StringRotation().isRotation("waterbottle", "erbottlewat"));
	}
}
