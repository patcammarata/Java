import java.util.*;

// Unlike the Comparable interface, you implement the Comparator interface in a separate class.
// You can pass this class as a parameter into Collections.sort() or Arrays.sort().
// Comparators also let you sort by multiple attributes. 
// You just need multiple classes that implement Comparator.
// You can also reverse the ordering you get from Comparator with Collections.reverseOrder().
public class ComparatorExample {

	public static void main(String[] args) {

		// Arrays.sort()
		Employee alice = new Employee(2309, 25, "Alice", "Wang");
		Employee bob = new Employee(44029, 25, "Bob", "Liu");
		Employee charlie = new Employee(11021, 25, "Charlie", "Li");
		Employee[] eArray = new Employee[3];
		eArray[0] = charlie;
		eArray[1] = alice;
		eArray[2] = bob;
		System.out.println(Arrays.toString(eArray));
		Arrays.sort(eArray,
				new AgeSorter().thenComparing(new FirstNameSorter()));
		System.out.println(Arrays.toString(eArray));

		// Collections.sort()
		List<Employee> list = new ArrayList<Employee>();
		list.add(charlie);
		list.add(alice);
		list.add(bob);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder(
				new AgeSorter().thenComparing(new LastNameSorter())));
		System.out.println(list);

		// You can also instantiate a sorting class while declaring the variable
		// to be of type Comparator.
		// The class that implements Comparator is at a lower level than Comparator.
		Comparator<Employee> comp = new LastNameSorter();
		Collections.sort(list, Collections.reverseOrder(comp));
		System.out.println(list);
	}

	static class Employee {

		private int id;
		private int age;
		private String firstName;
		private String lastName;

		public Employee(int id, int age, String firstName, String lastName) {
			this.id = id;
			this.age = age;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Employee() {

		}

		public int getId() {
			return this.id;
		}

		public int getAge() {
			return this.age;
		}

		public String getFirstName() {
			return this.firstName;
		}

		public String getLastName() {
			return this.lastName;
		}

		public String toString() {
			return "\nEmployee [id=" + this.id + ", age=" + this.age
					+ ", firstName=" + this.firstName + ", lastName="
					+ this.lastName + "]";
		}

	}

	static class FirstNameSorter implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}

	}

	static class LastNameSorter implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}

	}

	static class AgeSorter implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {
			return o1.getAge() - o2.getAge();
		}

	}

}
