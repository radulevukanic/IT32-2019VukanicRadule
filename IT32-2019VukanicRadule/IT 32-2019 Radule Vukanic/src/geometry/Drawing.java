package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
//javax = java with an extension tj. prosirena verzija osnovnog java paketa
import javax.swing.UIManager;

public class Drawing extends JPanel{

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing"); //title frame-a
		frame.setSize(800, 600); //velicina frame-a
		frame.setBackground(Color.WHITE);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(50, 50, true, Color.BLUE);
		Line l = new Line(new Point(150, 50), new Point(150, 140), true, Color.DARK_GRAY);
		Circle c = new Circle(new Point(320, 240), 50, true, Color.GRAY, Color.YELLOW);
		Rectangle r = new Rectangle(new Point(620, 220), 60, 120, true, Color.BLUE, Color.MAGENTA);
		Donut d = new Donut(new Point(400, 430), 70, 30, true, Color.BLACK, Color.GREEN);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>(); 
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(r);
		shapes.add(d);
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			System.out.println("Selected: " + it.next().isSelected());
		}
		
		shapes.get(2).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.get(3).draw(g);
		
		Line l1 = new Line(new Point(200, 100), new Point(200, 190), true, Color.BLACK);
		shapes.add(3, l1);
		shapes.get(3).draw(g);
		
		shapes.remove(1); 

		for(Shape s: shapes) {
			s.draw(g);
		}
		
		for(Shape s: shapes) {
			if(s instanceof SurfaceShape)
			s.draw(g);
		}
		
	}

}
