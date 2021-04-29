import java.util.*;

// Custom sorts!
public class ComparableExample {
	
	public static void main(String[] args) {
		Point[] points = {new Point(5, 13), new Point(5, 11), new Point(1, 3), new Point (1, 1)};
		Arrays.sort(points);
		System.out.println(Arrays.toString(points));
		Comparator<Point> comp = new ReversePoints();
		Arrays.sort(points, comp);
		System.out.println(Arrays.toString(points));
	}
	
	// Pay close attention to the Comparable<T> syntax.
	static class Point implements Comparable<Point> {

		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point() {
			
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		@Override
		public int compareTo(Point other) {
			if (this.x != other.x) {
				return this.x - other.x;
			} else {
				return this.y - other.y;
			}
		}
		
		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
		
	}
	
	// You can still create a Comparator for a class that implements Comparable.
	// Using this Comparator in a sort has the same effect as using Collections.reverseOrder().
	static class ReversePoints implements Comparator<Point> {
		
		public int compare(Point o1, Point o2) {
			if (o1.getX() != o2.getX()) {
				return o2.getX() - o1.getX();
			} else {
				return o2.getY() - o1.getY();
			}
		}
		
	}
	
}
