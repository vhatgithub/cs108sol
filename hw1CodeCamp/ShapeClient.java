import java.util.*;

public class ShapeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String coordinates = null;
		String[] coordinatesArray = null;
		Point point = null;
		List<Point> shapeAPoints = new ArrayList<Point>();
		List<Point> shapeBPoints = new ArrayList<Point>();
		List<Point> shapeCPoints = new ArrayList<Point>();
		List<Point> shapeDPoints = new ArrayList<Point>();
		Shape shapeA = null;
		Shape shapeB = null;
		Shape shapeC = null;
		Shape shapeD = null;
		
		Scanner scanner = new Scanner(System.in);
		
//		Shape A coordinates
		System.out.println("Enter coordinates of shape A:");
		
		coordinates = scanner.nextLine();
		coordinatesArray = coordinates.split("\\s");
		
		for(int i = 0; i < coordinatesArray.length; i = i + 2) {
			point = new Point(Double.valueOf(coordinatesArray[i]), Double.valueOf(coordinatesArray[i + 1]));
			shapeAPoints.add(point);
		}
		
		shapeA = new Shape(shapeAPoints);
		
//		Shape B coordinates
		System.out.println("Enter coordinates of shape B:");
		
		coordinates = scanner.nextLine();
		coordinatesArray = coordinates.split("\\s");
				
		for(int i = 0; i < coordinatesArray.length; i = i + 2) {
			point = new Point(Double.valueOf(coordinatesArray[i]), Double.valueOf(coordinatesArray[i + 1]));
			shapeBPoints.add(point);
		}
		
		shapeB = new Shape(shapeBPoints);
				
//		Shape C coordinates
		System.out.println("Enter coordinates of shape C:");
		
		coordinates = scanner.nextLine();
		coordinatesArray = coordinates.split("\\s");
				
		for(int i = 0; i < coordinatesArray.length; i = i + 2) {
			point = new Point(Double.valueOf(coordinatesArray[i]), Double.valueOf(coordinatesArray[i + 1]));
			shapeCPoints.add(point);
		}
		
		shapeC = new Shape(shapeCPoints);
				
//		Shape D coordinates
		System.out.println("Enter coordinates of shape D:");
		
		coordinates = scanner.nextLine();
		coordinatesArray = coordinates.split("\\s");
				
		for(int i = 0; i < coordinatesArray.length; i = i + 2) {
			point = new Point(Double.valueOf(coordinatesArray[i]), Double.valueOf(coordinatesArray[i + 1]));
			shapeDPoints.add(point);
		}
		
		shapeD = new Shape(shapeDPoints);
		
		
		System.out.println("a crosses b:" + shapeA.crossesShape(shapeB));
		System.out.println("a crosses c:" + shapeA.crossesShape(shapeC));
		System.out.println("a crosses d:" + shapeA.crossesShape(shapeD));
		
//		System.out.println("a encircles b:" + shapeA.encirclesShape(shapeB));
//		System.out.println("a encircles c:" + shapeA.encirclesShape(shapeC));
//		System.out.println("a encircles d:" + shapeA.encirclesShape(shapeD));
	}

}
