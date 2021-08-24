package super_suspicious;

public class first {
	public static void main(String[] args) {
		int i = 12;
		System.out.println("value of i at first : " + i);

		Integer j = new Integer(10);
		System.out.println("value of Integer j : " + j);

		i = j;
		System.out.println("value of i after changes :" + j);

		Character c = new Character('a');
		System.out.println("value of Character c :" + c);

		i = c;
		System.out.println("value of i after c :" + i);

		Long l = new Long(99L);
		float f = l;

		System.out.println("value of long is " + l);
		System.out.println("value when assigned to float variable: " + f);

	}

}




