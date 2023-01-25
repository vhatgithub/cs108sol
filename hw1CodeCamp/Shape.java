import java.util.*;

/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
	private List<Point> points;
	
	public Shape() {
		this.points = new ArrayList<Point>();
	}
	
	public Shape(List<Point> initPoints) {
		this.points = initPoints;
	}
	
	public List<Point> getPoints() {
		return this.points;
	}
	
	public void setPoints(List<Point> otherPoints) {
		this.points = otherPoints;
	}
	
	public Point getCenterPoint() {
		double centerX = 0.0;
		double centerY = 0.0;
		
		for(Point point : this.points) {
			centerX += point.getX();
			centerY += point.getY();
		}
		
		centerX = centerX / this.points.size();
		centerY = centerY / this.points.size();
		
		Point point = new Point(centerX, centerY);
		
		return point;
	}
	
	public Point getNearestPoint(Point centerPoint) {
		double nearestDistance = 0.0, distance = 0.0;
		Point nearestPoint = null;
		
		for(Point point : this.points) {
			distance = point.distance(centerPoint);
			
			if(nearestDistance > distance) {
				nearestDistance = distance;
				nearestPoint = point;
			}
		}
		
		return nearestPoint;
	}
	/**
	 * Checks if method calling shape crosses other shape passed as parameter
	 * @param other shape
	 * @return true/false if calling shape crosses otherShape or not.
	 */
	public boolean crossesShape(Shape otherShape) {
		List<Point> shapeAPoints = this.getPoints();
		List<Point> shapeBPoints = otherShape.getPoints();
		
		for(int i = 0; i < shapeAPoints.size() - 1; i++) {
			for(int j = 0; j < shapeBPoints.size() - 1; j++) {
				if(this.isIntersecting(shapeAPoints.subList(i, i + 2), shapeBPoints.subList(j, j + 2))) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	private boolean isIntersecting(List<Point> line1, List<Point> line2) {
//		https://math.stackexchange.com/questions/149622/finding-out-whether-two-line-segments-intersect-each-other
		
		double line1X1 = line1.get(0).getX();
		double line1X2 = line1.get(1).getX();
		double line1Y1 = line1.get(0).getY();
		double line1Y2 = line1.get(1).getY();
		
		double line2X1 = line2.get(0).getX();
		double line2X2 = line2.get(1).getX();
		double line2Y1 = line2.get(0).getY();
		double line2Y2 = line2.get(1).getY();

//		Division by zero in double values yields Infinity. slope formula: (y2 - y1) / (x2 - x1)
		double line1Slope = (line1Y2 - line1Y1) / (line1X2 - line1X1);
		double line2Slope = (line2Y2 - line2Y1) / (line2X2 - line2X1);
		
//		Intercepts of both of the lines
		double line1Intercept;
		double line2Intercept;
		double intersectPointX = 0.0;
		double intersectPointY = 0.0;
		
//		Infinity values cannot be compared using regular == & !=
		if(Double.valueOf(line1Slope).compareTo(Double.POSITIVE_INFINITY) == 0 || Double.valueOf(line1Slope).compareTo(Double.NEGATIVE_INFINITY) == 0) {
			line1Intercept = 0.0;
			intersectPointX = line1X2;
		} else {
			line1Intercept = (line1X1 * line1Y2 - line1X2 * line1Y1) / (line1X1 - line1X2);
		}
		
		if(Double.valueOf(line2Slope).compareTo(Double.POSITIVE_INFINITY) == 0 || Double.valueOf(line2Slope).compareTo(Double.NEGATIVE_INFINITY) == 0) {
			line2Intercept = 0.0;
		} else {
			line2Intercept = (line2X1 * line2Y2 - line2X2 * line2Y1) / (line2X1 - line2X2);
		}
		
//		If slopes are equal, then lines are parallel
		if(line1Slope == line2Slope) {
			return false;
		} else if(line1Intercept != 0.0 && line2Intercept != 0.0){
			intersectPointX = (line2Intercept - line1Intercept) / (line1Slope - line2Slope);
//			intersectPointY = (line2Slope * line1Intercept - line1Slope * line2Intercept) / (line2Slope - line1Slope);
		}
		
		if((intersectPointX >= line2X1 && intersectPointX <= line2X2) || (intersectPointX >= line2X2 && intersectPointX <= line2X1)) {
			return true;
		}
		
		return false;
	}
	
	public int encirclesShape(Shape otherShape) {
		Point otherPointCenter = otherShape.getCenterPoint();
		
		for(Point thisPoint : this.points) {
			if(otherPointCenter.getX() < thisPoint.getX() && otherPointCenter.getY() < thisPoint.getY()) {
				return 2;
			} else if(this.crossesShape(otherShape)) {
				return 1;
			}
		}
		
		return 0;
	}
}
