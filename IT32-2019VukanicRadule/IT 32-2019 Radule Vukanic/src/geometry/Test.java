package geometry;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);
		
		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		double result = p.distance(40, 50);
		System.out.println("Distance between points is: " + result);
		
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);
		
		Rectangle r1 = new Rectangle();
		Line l1 = new Line();
		Circle c1 = new Circle();
		
		p.setX(p1.getY());
		System.out.println("X of p = " + p.getX());
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		l1.getEndPoint().setY(23);
		System.out.println("Y of end point of l1 = " + l1.getEndPoint().getY());
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("X of start point of l1 = " + l1.getStartPoint().getX());
		l1.getEndPoint().setX((int) (l1.lenght() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));
		System.out.println("X of end point of l1" + l1.getEndPoint().getX());
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("X of ulp of r1 = " + r1.getUpperLeftPoint().getX());
		System.out.println("Y of ulp of r1 = " + r1.getUpperLeftPoint().getY());
		c1.setCenter(r1.getUpperLeftPoint());
		r1.setHeight(20); 
		r1.setWidth(30);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("X of center of c1 = " + c1.getCenter().getX());
		
		Point p2 = new Point(50, 100);
		Line l2 = new Line(p2, new Point(400, 500));
		Rectangle r2 = new Rectangle(p1, 50, 80);
		Circle c2 = new Circle(new Point(300, 300), 60);
		
		System.out.println(p2.toString());
		System.out.println(l2);
		System.out.println(c2);
		System.out.println(r2);
		
		int a = 5;
		int b = 5;

		System.out.println(a == b);

		String s1 = new String("Hello World");
		String s2 = new String("Hello World");

		System.out.println(s1 == s2);
		System.out.println(c2 == c1);
		System.out.println(s1.equals(s2));

		System.out.println(p2 instanceof Point);
		System.out.println(p2 instanceof Object);

		System.out.println(p2.equals(p1));
		System.out.println(p2.equals(c2));
		
		Donut d = new Donut();
		System.out.println(d instanceof Donut);
		System.out.println(d instanceof Circle);
		System.out.println(d instanceof SurfaceShape);
		System.out.println(d instanceof Shape);
		System.out.println(d instanceof Object);
		
		Circle d1 = new Donut();
		
		Point p4 = new Point(10, 10);
		Point p5 = new Point(5, 5);
		Point p6 = new Point(2, 2);
		Point p7 = new Point(20, 20);
		
		Point[] points = {p4, p5, p6, p7};
		
		System.out.println("Nesortiran niz tacaka: ");
		for (int i = 0; i < points.length; i++)
			System.out.println(points[i]);
		
		Arrays.sort(points);
		System.out.println("Sortiran niz tacaka: ");
		for (int i = 0; i < points.length; i++)
			System.out.println(points[i]);
		
		HashMap<String, Shape> map = new HashMap<String, Shape>();
		map.put("point", p1);
		map.put("rectangle", r1);
		map.put("Point", p2);
		
		System.out.println("point from map is: " + map.get("point"));
		System.out.println("point from map is: " + map.get("Point"));
		
		Point p3 = new Point(40, 40);
		map.put("point", p3);
		System.out.println("point from map is: " + map.get("point"));
		
		Circle c4 = new Circle(p6, 40);
		try {
			c4.setRadius(-150);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally se uvek izvrsava");
		}
		
	}

}
