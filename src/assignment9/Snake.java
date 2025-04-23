package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private double MOVEMENT_SIZE;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private double direction;
	private int count;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<BodySegment>();  // Initialize the segments list
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
        int direction = 0;
        MOVEMENT_SIZE = 0.02;
        count = 0;
	}
	
	public void changeDirection(int newDirection) {
	    // Prevent reversing direction
	    if ((direction == 1 && newDirection == 2) ||  // up → down
	        (direction == 2 && newDirection == 1) ||  // down → up
	        (direction == 3 && newDirection == 4) ||  // left → right
	        (direction == 4 && newDirection == 3)) {  // right → left
	        return; // Invalid move: ignore it
	    }

	    // Valid direction change
	    direction = newDirection;
	    if (direction == 1) { // up
	        deltaY = MOVEMENT_SIZE;
	        deltaX = 0;
	    } else if (direction == 2) { // down
	        deltaY = -MOVEMENT_SIZE;
	        deltaX = 0;
	    } else if (direction == 3) { // left
	        deltaY = 0;
	        deltaX = -MOVEMENT_SIZE;
	    } else if (direction == 4) { // right
	        deltaY = 0;
	        deltaX = MOVEMENT_SIZE;
	    }
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		// Move each segment to the position of the previous segment, starting from the tail
        for (int i = segments.size() - 1; i > 0; i--) {
            BodySegment current = segments.get(i);
            BodySegment previous = segments.get(i - 1);
            current.setPosition(previous.getX(), previous.getY());
        }

        // Move the head by the deltaX and deltaY
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
        head.setPosition(newX, newY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for (BodySegment segment : segments) {
            segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
        if (head.getX() <= f.getX() + 0.02 && head.getX() >= f.getX() - 0.02 && head.getY() <= f.getY() + 0.02 && head.getY() >= f.getY() - 0.02) {
            segments.add(new BodySegment(segments.getLast().getX(), segments.getLast().getY(), SEGMENT_SIZE));  // Add a new segment at the end
            count += 1;
            MOVEMENT_SIZE += .002;
            return true;  // Snake has eaten the food
        }
		return false;
		
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.getFirst();
        double x = head.getX();
        double y = head.getY();
        // The window bounds are from -1 to 1
        return (x >= -0.01 + SEGMENT_SIZE && x <= 1.01 - SEGMENT_SIZE && y >= -0.01 + SEGMENT_SIZE && y <= 1.01 - SEGMENT_SIZE);
	}
}
