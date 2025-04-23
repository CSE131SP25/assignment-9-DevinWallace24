package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		snake = new Snake();
        food = new Food();
	}
	
	public void play() {
		while (true) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			if (dir != -1) {
                snake.changeDirection(dir);  // Change the snake's direction based on key press
            }

            snake.move();  // Move the snake
            if (snake.eatFood(food)) {
                food = new Food();  // Create new food after the snake eats it
            }

            if (!snake.isInbounds()) {
                System.out.println("Game Over!");
                break;  // End the game if the snake goes out of bounds
            }

            updateDrawing();  // Update the screen with the new game state
            StdDraw.pause(50);  
        }
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();  // Clear the screen
        snake.draw();     
        food.draw();      
        StdDraw.show();   
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
