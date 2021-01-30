package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.UIManager;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		
	} 
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius); 
		setSelected(selected);
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		this(center, radius, innerRadius, selected); 
		setColor(color);
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color); 
		setInnerColor(innerColor);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	@Override
	public void fill(Graphics g) {
		g.setColor(Color.BLACK);
		super.fill(g);
		g.setColor(new Color(238, 238, 238));
		g.fillOval(this.getCenter().getX()-this.innerRadius+1, this.getCenter().getY()-this.innerRadius+1,
				this.innerRadius*2-2, this.innerRadius*2-2);
	}
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(this.getCenter().getX()-this.innerRadius, this.getCenter().getY()-this.innerRadius, 
				this.innerRadius*2, this.innerRadius*2);
		this.fill(g);
	}
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI; 
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(this.getCenter().equals(temp.getCenter()) && this.getRadius() == temp.getRadius() && this.innerRadius == temp.innerRadius)
				return true;
			else
				return false;
		} else
			return false;
	}
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	@Override
	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius;
	}
	
}
