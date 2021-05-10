
public class AlphabateSpecial {

	public static void main(String[] args) {
		int count =0;
		String str="$&#23479";
		for (int i = 0; i < str.length(); i++) {
			System.out.println((int)str.charAt(i));
			if((str.charAt(i) >= 33 && str.charAt(i) <= 47)) {
				count++;
			}
			if((str.charAt(i) >= 48 && str.charAt(i) <= 57)) {
				count++;
			}
		}
		System.out.println("Count:" + count);
	}

}
