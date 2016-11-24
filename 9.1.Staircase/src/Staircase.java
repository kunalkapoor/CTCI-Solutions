
public class Staircase {
	public int staircase(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;

		int t1, t2, t3, i, temp;
		t1 = 1;
		t2 = 2;
		t3 = 4;

		for (i = 4; i <= n; i++) {
			temp = t1 + t2 + t3;
			t1 = t2;
			t2 = t3;
			t3 = temp;
		}

		return t3;
	}

	public int recursive(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return recursive(n-1) + recursive(n-2) + recursive(n-3);
	}

	public static void main(String[] args) {
		Staircase staircase = new Staircase();
		System.out.println(staircase.staircase(3));
		System.out.println(staircase.staircase(32));
		System.out.println(staircase.recursive(3));
		System.out.println(staircase.recursive(32));
	}
}
