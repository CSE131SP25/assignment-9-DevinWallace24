package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
        this.y = y;
        this.size = size;
        
        this.color = Color.GREEN; 
		
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(color);  // Set the color for the body segment
        StdDraw.filledCircle(x, y, size); 
	}
	
	public double getY() {
        return y;
    }
	
	public double getX() {
        return x;
    }
	
	public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

	
}
