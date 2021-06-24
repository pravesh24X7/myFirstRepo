import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class ArraysAndCollections {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		list.add("prince");
		list.add("pravesh");
		list.add("king");
		list.add("opti");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		students();
		frequent();
	}


	static class Student {
		int age;
		String name;
		
		public Student(String name, int age) {
			this.age = age;
			this.name = name;
		}
		
		public String toString() {
			return this.age +  " " + this.name;
		}

		public boolean equals(Object s) {
			Student stu = (Student) s;
			return this.age == stu.age && this.name == stu.name;
		}
	}
		
	static class SortByAge implements Comparator<Student> {
		public int compare(Student a, Student b) {
			return a.age - b.age;
		}
		

	}

	public static void students() {
		Student[] arr = { new Student("prince", 12), new Student("pravesh", 11), new Student("king", 13), new Student("Opti", 15), new Student("prince", 12)};

		System.out.println(Arrays.asList(arr));
		Collections.sort(Arrays.asList(arr), new SortByAge());
		System.out.println(Arrays.asList(arr));
		System.out.println(arr[0].equals(arr[arr.length - 1]));
	}

	public static void frequent() {
		
		List<String> list = new LinkedList<>();
		list.add("prince");
		list.add("pravesh");
		list.add("king");
		list.add("prince");
	
		System.out.println(list);
		Collections.rotate(list, 2);
		System.out.println(list);

		System.out.println(Collections.frequency(list, "prince"));
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);

	}
}

